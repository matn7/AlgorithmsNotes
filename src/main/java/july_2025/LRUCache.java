package july_2025;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2)); // -1
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1)); // -1
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }

    Node head;
    Node tail;
    int capacity;
    Map<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.prev = tail;
        tail.next = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        remove(node);
        insertHead(node);
        return node.val;

    }

    public void put(int key, int value) {
        // insert front
        Node newNode = new Node(key, value);
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            cache.remove(key);
        }
        cache.put(key, newNode);
        insertHead(newNode);

        if (cache.size() > capacity) {
            Node tailNode = tail.next;
            remove(tailNode);
            cache.remove(tailNode.key);
        }
    }

    private void remove(Node node) {
        if (isEmpty()) {
            return;
        }
        Node next = node.next;
        Node prev = node.prev;

        prev.next = next;
        next.prev = prev;
    }
    private boolean isEmpty() {
        return head.prev == tail && tail.next == head;
    }

    private void insertHead(Node node) {
        if (isEmpty()) {
            tail.next = node;
            head.prev = node;
            node.next = head;
            node.prev = tail;
        } else {
            Node prev = head.prev;
            prev.next = node;
            head.prev = node;
            node.next = head;
            node.prev = prev;
        }
    }

    static class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

}
