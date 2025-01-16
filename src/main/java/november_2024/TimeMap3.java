package november_2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap3 {

    public static void main(String[] args) {
        TimeMap3 timeMap3 = new TimeMap3();
        timeMap3.set("test", "one", 10);
        timeMap3.set("test", "two", 20);
        timeMap3.set("test", "three", 30);

        System.out.println(timeMap3.get("test", 15));
        System.out.println(timeMap3.get("test", 25));
        System.out.println(timeMap3.get("test", 35));
    }

    Map<String, List<Element>> timeMap;

    public TimeMap3() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!timeMap.containsKey(key)) {
            List<Element> newElements = new ArrayList<>();
            newElements.add(new Element(value, timestamp));
            timeMap.put(key, newElements);
        } else {
            List<Element> allElements = timeMap.get(key);
            allElements.add(new Element(value, timestamp));
            timeMap.put(key, allElements);
        }
    }

    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) {
            return "";
        }
        List<Element> timeEntries = timeMap.get(key);
        int l = 0;
        int r = timeEntries.size() - 1;

        int idx = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (timeEntries.get(m).timestamp == timestamp) {
                return timeEntries.get(m).value;
            } else if (timeEntries.get(m).timestamp > timestamp) {
                r = m - 1;
            } else {
                idx = Math.max(m, idx);
                l = m + 1;
            }
        }

        return idx == -1 ? "" : timeEntries.get(idx).value;
    }

    static class Element {
        String value;
        int timestamp;

        public Element(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

}
