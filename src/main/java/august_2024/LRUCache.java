package august_2024;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {

    Map<Integer, Integer> keyToValue;
    Deque<Integer> cache; // store keys
    int capacity;

    public void init(int c) {
        this.keyToValue = new HashMap<>();
        this.cache = new LinkedList<>();
        this.capacity = c;
    }

    public void put(int key, int value) {
        if (!keyToValue.containsKey(key)) {
            if (cache.size() == capacity) {
                Integer oldestKey = cache.removeLast();
                keyToValue.remove(oldestKey);
            }
        } else {
            cache.remove(key);
        }
        cache.addFirst(key);
        keyToValue.put(key, value);
    }

    public int get(int key) {
        if (!keyToValue.containsKey(key)) {
            throw new RuntimeException("Key does not exists");
        }
        Integer value = keyToValue.get(key);
        cache.remove(key);
        cache.addFirst(key);
        return value;
    }

}
