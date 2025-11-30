package november_2025;

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

    // O(1) time | O(1) space
    ListNode head;
    ListNode tail;
    Map<Integer, ListNode> cache;
    int capacity;

    public LRUCache(int capacity) {
        head = new ListNode(0, 0);
        tail = new ListNode(0, 0);
        head.prev = tail;
        tail.next = head;
        cache = new HashMap<>();
        this.capacity = capacity;
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
        if (cache.containsKey(key)) {
            // remove node
            ListNode node = cache.get(key);
            removeNode(node);
            // remove from cache
            cache.remove(key);
        }
        ListNode newNode = new ListNode(key, value);
        // add to head
        addNode(newNode);

        cache.put(key, newNode);
        if (cache.size() > capacity) {
            ListNode tailNode = tail.next;
            // remove tail node
            removeNode(tailNode);
            cache.remove(tailNode.key);
        }
    }

    private void addNode(ListNode newNode) {
        ListNode prev = head.prev;
        prev.next = newNode;
        head.prev = newNode;
        newNode.next = head;
        newNode.prev = prev;
    }

    private void removeNode(ListNode node) {
        ListNode next = node.next;
        ListNode prev = node.prev;
        next.prev = prev;
        prev.next = next;
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
