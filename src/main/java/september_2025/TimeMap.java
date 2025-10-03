package september_2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {
    Map<String, List<Pair>> times;
    public TimeMap() {
        times = new HashMap<>();
    }

    // O(1) time | O(1) space
    public void set(String key, String value, int timestamp) {
        Pair pair = new Pair(value, timestamp);
        List<Pair> pairs;
        if (times.containsKey(key)) {
            pairs = times.get(key);
            pairs.add(pair);
        } else {
            pairs = new ArrayList<>();
            pairs.add(pair);
        }
        times.put(key, pairs);
    }

    // O(log(n)) time | O(1) space
    public String get(String key, int timestamp) {
        if (!times.containsKey(key)) {
            return "";
        }
        List<Pair> pairs = times.get(key);
        int l = 0;
        int r = pairs.size() - 1;

        String value = "";
        while (l <= r) {
            int m = (l + r) / 2;
            Pair pair = pairs.get(m);
            int time = pair.timestamp;
            if (time == timestamp) {
                return pair.value;
            } else if (timestamp > time) {
                value = pair.value;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return value;
    }

    static class Pair {
        String value;
        int timestamp;

        public Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}
