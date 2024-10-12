package september_2024;

import java.util.HashMap;
import java.util.Map;

public class LRUCache2 {

    public static void main(String[] args) {
        LRUCache2 lruCache = new LRUCache2(2);
        lruCache.put(2, 1);
        lruCache.put(2, 2);
        lruCache.get(2);
        lruCache.put(3, 3);
        System.out.println();
        int result = lruCache.get(2);
        System.out.println(result);
    }

    Map<Integer, Node> cache;
    Node left;
    Node right;
    int capacity;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        // left = LRU, right = most recent
        left = new Node(0, 0);
        right = new Node(0, 0);
        left.next = right;
        right.prev = left;
    }


    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        node.next = prev;
    }

    private void insert(Node node) {
        Node prev = right.prev;
        Node next = right;
        prev.next = node;
        next.prev = node;
        node.next = next;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
            insert(cache.get(key));
            return cache.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        cache.put(key, new Node(key, value));
        insert(cache.get(key));

        if (cache.size() > capacity) {
            // remove from the list and delete the LRU from cache
            Node lru = left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }

    static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
