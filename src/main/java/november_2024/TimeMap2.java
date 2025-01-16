package november_2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap2 {

    Map<String, List<Element>> store;

    public TimeMap2() {
        store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!store.containsKey(key)) {
            store.put(key, new ArrayList<>());
        }
        store.get(key).add(new Element(value, timestamp));
    }

    public String get(String key, int timestamp) {
        String res = "";
        if (!store.containsKey(key)) {
            return res;
        }
        List<Element> values = store.get(key);

        int l = 0;
        int r = values.size() - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            if (values.get(m).timestamp <= timestamp) {
                res = values.get(m).value;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return res;
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