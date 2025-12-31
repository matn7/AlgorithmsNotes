package december_2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {

    // O(log(n)) time | O(1) space
    Map<String, List<Pair>> timesMap;

    public TimeMap() {
        timesMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        timesMap.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!timesMap.containsKey(key)) {
            return "";
        }

        List<Pair> pairs = timesMap.get(key);
        int l = 0;
        int r = pairs.size() - 1;
        String value = "";

        while (l <= r) {
            int mid = (l + r) / 2;
            Pair midPair = pairs.get(mid);

            if (midPair.timestamp == timestamp) {
                return midPair.value;
            }
            if (timestamp > midPair.timestamp) {
                value = midPair.value;;
                l = mid + 1;
            } else {
                r = mid - 1;
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
