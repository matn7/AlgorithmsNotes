package october_2025;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
//        lruCache.put(2, 2);
//        System.out.println(lruCache.get(1));
//        lruCache.put(3, 3);
//        System.out.println(lruCache.get(2));
//        lruCache.put(4, 4);
//        System.out.println(lruCache.get(1));
//        System.out.println(lruCache.get(3));
//        System.out.println(lruCache.get(4));
        System.out.println();
    }

    ListNode head;
    ListNode tail;
    Map<Integer, ListNode> cache;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new ListNode(-1, -1);
        this.tail = new ListNode(-1, -1);

        this.head.prev = this.tail;
        this.tail.next = this.head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        ListNode node = cache.get(key);
        // remove node
        removeNode(node);
        // add to head
        addNode(node);
        return node.val;
    }

    public void put(int key, int value) {
        Object a = new Object() {
            public int hashCode() { return 1; }
            public boolean equals(Object o) { return this == o; }
        };
        Object b = new Object() {
            public int hashCode() { return 1; }
            public boolean equals(Object o) { return this == o; }
        };

        Map<Object, String> mapa = new HashMap<>();
        mapa.put(a, "jabłko");
        mapa.put(b, "pomarańcza");

        System.out.println(mapa);
        System.out.println(mapa.get(a));
        System.out.println(mapa.get(b));

        if (cache.containsKey(key)) {
            ListNode nodeToRemove = cache.get(key);
            // remove node
            removeNode(nodeToRemove);
        }
        ListNode newNode = new ListNode(key, value);
        cache.put(key, newNode);
        // add to head
        addNode(newNode);

        if (cache.size() > capacity) {
            ListNode tailNode = tail.next;
            // remove node
            removeNode(tailNode);
            cache.remove(tailNode.key);
        }
    }

    private void addNode(ListNode newNode) {
        ListNode prev = this.head.prev;
        this.head.prev = newNode;
        prev.next = newNode;
        newNode.next = this.head;
        newNode.prev = prev;
    }

    private void removeNode(ListNode node) {
        ListNode next = node.next;
        ListNode prev = node.prev;
        next.prev = prev;
        prev.next = next;
        node.next = null;
        node.prev = null;
    }

    static class ListNode {
        int key;
        int val;
        ListNode prev;
        ListNode next;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

}
