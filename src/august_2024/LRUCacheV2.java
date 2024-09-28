package august_2024;

import java.util.*;

public class LRUCacheV2 {

    public static void main(String[] args) {
        LRUCacheV2 lruCache = new LRUCacheV2(4);

        lruCache.put("A", 12);
        lruCache.put("B", 22);
        lruCache.put("C", 42);
        lruCache.put("D", 89);

        System.out.println();
        lruCache.get("C");
        System.out.println();
        lruCache.put("E", 997);
        System.out.println();
        lruCache.put("D", 112);
        System.out.println();
    }

    Deque<String> queue = new LinkedList<>();
    Map<String, Integer> cache = new HashMap<>();
    int size;

    public LRUCacheV2(int size) {
        this.size = size;
    }

    public int put(String key, int value) {
        if (!cache.containsKey(key)) {
            if (queue.size() == this.size) {
                String lastElement = queue.removeLast();
                cache.remove(lastElement);
            }
        } else {
            queue.remove(key);
        }
        cache.put(key, value);
        queue.addFirst(key);
        return value;
    }

    public int get(String key) {
        if (!cache.containsKey(key)) {
            throw new RuntimeException("Element with key does not exists");
        }
        queue.remove(key);
        queue.addFirst(key);
        return cache.get(key);
    }

}
