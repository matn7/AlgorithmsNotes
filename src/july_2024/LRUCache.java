package july_2024;

import java.util.*;

public class LRUCache {

    public static void main(String[] args) {

        LRUCache lruCache = new LRUCache();
        lruCache.initialize(4);

        lruCache.put(1, 1);
        lruCache.put(2, 11);
        lruCache.put(3, 111);
        lruCache.put(4, 1111);

        System.out.println(lruCache);

    }

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

    // O(c) time | O(1) space
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
