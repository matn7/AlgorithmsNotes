package december_2024;

import java.util.*;

public class LRUCache {

    int capacity;

    Map<Integer, Integer> keyValueMap;
    ArrayDeque<Integer> keyLinkedList;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        keyValueMap = new HashMap<>();
        keyLinkedList = new ArrayDeque<>();
    }

    public int get(int key) {
        if (!keyValueMap.containsKey(key)) {
            return -1;
        }
        Integer value = keyValueMap.get(key);
        keyLinkedList.remove(key);
        keyLinkedList.addFirst(key);
        return value;
    }

    public void put(int key, int value) {
        if (!keyValueMap.containsKey(key)) {
            if (keyValueMap.size() == capacity) {
                // remove last one
                Integer removed = keyLinkedList.removeLast();
                keyValueMap.remove(removed);
            }
            // update as head
        } else {
            keyLinkedList.remove(key);
            // update as head
        }
        keyValueMap.put(key, value);
        keyLinkedList.addFirst(key);
    }

}
