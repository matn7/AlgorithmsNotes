package january_2026;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));

        System.out.println();
    }

    // O(n) time | O(n) space
    private Map<Integer, ListNode> cache;
    private int capacity;
    ListNode head;
    ListNode tail;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.head = new ListNode(-1, -1);
        this.tail = new ListNode(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    // O(1) time
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        ListNode node = cache.get(key);

        // remove node
        removeNode(node);

        // add to head
        addNode(node);

        return node.value;
    }

    // O(1) time
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            ListNode nodeToRemove = cache.get(key);
            cache.remove(key);
            removeNode(nodeToRemove);
        }
        // add to head
        ListNode newNode = new ListNode(key, value);
        addNode(newNode);
        cache.put(key, newNode);

        if (cache.size() > capacity) {
            // remove tail
            ListNode lastNode = tail.prev;

            // remove node
            removeNode(lastNode);
            cache.remove(lastNode.key);
        }
    }

    private void addNode(ListNode node) {
        ListNode next = this.head.next;
        head.next = node;
        next.prev = node;
        node.next = next;
        node.prev = head;
    }

    private void removeNode(ListNode node) {
        ListNode next = node.next;
        ListNode prev = node.prev;

        prev.next = next;
        next.prev = prev;
    }

    static class ListNode {
        int key;
        int value;
        ListNode next;
        ListNode prev;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


}
