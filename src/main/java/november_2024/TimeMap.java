package november_2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {

    Map<String, List<Element>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (timeMap.containsKey(key)) {
            List<Element> elements = timeMap.get(key);
            elements.add(new Element(value, timestamp));
            timeMap.put(key, elements);
        } else {
            List<Element> elements = new ArrayList<>();
            elements.add(new Element(value, timestamp));
            timeMap.put(key, elements);
        }
    }

    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) {
            return "";
        }
        List<Element> elements = timeMap.get(key);
        int start = 0;
        int end = elements.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            Element currElement = elements.get(mid);
            if (currElement.timestamp == timestamp) {
                return currElement.value;
            } else if (currElement.timestamp < timestamp) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
//        for (int i = elements.size() - 1; i >= 0; i--) {
//            Element currElement = elements.get(i);
//            if (currElement.timestamp <= timestamp) {
//                return currElement.value;
//            }
//        }
        return "";
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