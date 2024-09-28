package september_2024;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(2, 2);
        lruCache.get(2);
        lruCache.put(3, 3);
        System.out.println();
        int result = lruCache.get(2);
        System.out.println(result);
    }

    Map<Integer, Integer> elementsMap;
    Deque<Integer> keysList;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        elementsMap = new HashMap<>();
        keysList = new ArrayDeque<>();
    }

    public int get(int key) {
        if (!elementsMap.containsKey(key)) {
            return -1;
        }
        Integer value = elementsMap.get(key);
        keysList.remove(key);
        keysList.addFirst(key);
        // update LL value go to front
        return value;
    }

    public void put(int key, int value) {
        if (elementsMap.containsKey(key)) {
            keysList.remove(key);
            elementsMap.remove(key);
        } else if (keysList.size() == capacity) {
            Integer last = keysList.removeLast();
            elementsMap.remove(last);
        }
        elementsMap.put(key, value);
        keysList.addFirst(key);
    }

}
