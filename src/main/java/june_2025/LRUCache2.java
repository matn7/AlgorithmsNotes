package june_2025;

import java.util.HashMap;
import java.util.Map;

public class LRUCache2 {

    public static void main(String[] args) {
        LRUCache2 lruCache2 = new LRUCache2(2);
        lruCache2.put(1, 1);
        lruCache2.put(2,2);
        System.out.println(lruCache2.get(1)); // 1
        lruCache2.put(3, 3);
        System.out.println(lruCache2.get(2)); // -1
        lruCache2.put(4, 4);
        System.out.println(lruCache2.get(1)); // -1
        System.out.println(lruCache2.get(3)); // 3
        System.out.println(lruCache2.get(4)); // 4
    }


    private Map<Integer, Node> cache;
    private Node head;
    private Node tail;
    private int capacity;

    public LRUCache2(int capacity) {
        cache = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.prev = tail;
        tail.next = head;
        this.capacity = capacity;
    }

    // O(1) time | O(1) space
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        remove(node);
        addFront(node);
        return node.val;
    }

    // O(1) time | O(n) space
    public void put(int key, int value) {
        Node newNode = new Node(key, value);
        if (cache.containsKey(key)) {
            Node nodeToReplace = cache.get(key);
            remove(nodeToReplace);
            cache.remove(nodeToReplace.key);
        }
        cache.put(key, newNode);
        addFront(newNode);

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


    private void addFront(Node node) {
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
