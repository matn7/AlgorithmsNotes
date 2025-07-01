package june_2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {

    Map<String, List<Pair>> times;

    public TimeMap() {
        times = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        times.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!times.containsKey(key)) {
            return "";
        }
        List<Pair> pairs = times.get(key);

        int l = 0;
        int r = pairs.size() - 1;
        String value = "";
        while (l <= r) {
            int m = l + (r - l) / 2;
            Pair pair = pairs.get(m);
            if (pair.timestamp == timestamp) {
                return pair.value;
            }
            if (pair.timestamp < timestamp) {
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
