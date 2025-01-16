package january_2025;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class LRUCache2 {

    int capacity;
    Map<Integer, Integer> cache;
    ArrayDeque<Integer> queue;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        queue = new ArrayDeque<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        queue.remove(key);
        queue.addFirst(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.remove(key);
            queue.remove(key);
        } else if (cache.size() == capacity) {
            Integer lastKey = queue.removeLast();
            cache.remove(lastKey);
        }
        cache.put(key, value);
        queue.addFirst(key);
    }

}
