package august_2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {

    Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    // O(1) time
    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key)) {
            List<Pair> pairs = map.get(key);
            pairs.add(new Pair(value, timestamp));
            map.put(key, pairs);
        } else {
            List<Pair> pairs = new ArrayList<>();
            pairs.add(new Pair(value, timestamp));
            map.put(key, pairs);
        }
    }

    // O(log(n)) time
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<Pair> pairs = map.get(key);
        int l = 0;
        int r = pairs.size() - 1;

        String value = "";
        while (l <= r) {
            int m = (l + r) / 2;
            Pair pair = pairs.get(m);
            if (pair.timestamp == timestamp) {
                return pair.value;
            } else if (timestamp > pair.timestamp) {
                value = pair.value;
                l = m + 1;
                // right
            } else {
                // left
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
