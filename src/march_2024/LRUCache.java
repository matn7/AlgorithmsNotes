package march_2024;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {

    Map<Integer, Integer> keyToValue;
    Deque<Integer> cache;
    int capacity;

    // O(c) space
    public void initialize(int c) {
        cache = new LinkedList<>();
        keyToValue = new HashMap<>();
        capacity = c;
    }

    // O(c) time | O(1) space
    public int get(Integer key) {
        if (!keyToValue.containsKey(key)) {
            return -1;
        }
        cache.remove(key);
        cache.addFirst(key);
        return keyToValue.get(key);
    }

    public void put(Integer key, Integer value) {
        if (!keyToValue.containsKey(key)) {
            if (cache.size() == capacity) {
                Integer oldest = cache.removeLast();
                keyToValue.remove(oldest);
            }
        } else {
            cache.remove(key);
        }
        keyToValue.put(key, value);
        cache.addFirst(key);
    }

}
