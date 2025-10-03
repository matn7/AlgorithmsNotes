package september_2025;

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

    Map<Integer, ListNode> cache;
    ListNode head;
    ListNode tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.prev = tail;
        tail.next = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        ListNode node = cache.get(key);
        // remove node
        remove(node);
        // add at head
        addNode(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // remove node
            ListNode nodeToRemove = cache.get(key);
            cache.remove(key);
            remove(nodeToRemove);
        }
        ListNode newNode = new ListNode(value, key);
        cache.put(key, newNode);
        // add at head
        addNode(newNode);
        if (cache.size() > capacity) {
            ListNode nodeToRemove = tail.next;
            int nodeKey = nodeToRemove.key;
            // remove node
            remove(nodeToRemove);
            cache.remove(nodeKey);
        }
    }

    private void remove(ListNode node) {
        ListNode prev = node.prev;
        ListNode next = node.next;

        next.prev = prev;
        prev.next = next;
    }

    private void addNode(ListNode node) {
        ListNode prev = head.prev;
        prev.next = node;
        node.prev = prev;

        head.prev = node;
        node.next = head;
    }

    static class ListNode {
        int val;
        int key;
        ListNode next;
        ListNode prev;

        public ListNode(int val, int key) {
            this.val = val;
            this.key = key;
        }
    }

}
