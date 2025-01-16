package december_2024;

import java.util.*;

public class LRUCache2 {

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

    // Remove the node from the linked list
    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    // Insert the node just before the right (most recent) node
    private void insert(Node node) {
        Node prev = right.prev;
        Node next = right;
        prev.next = node;
        next.prev = node;
        node.prev = prev;
        node.next = next;
    }

    // Get the value of the key if it exists, and move it to the most recent position
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);  // Move the accessed node to the most recent position
            return node.value;
        }
        return -1;
    }

    // Put the key-value pair into the cache
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // If the key exists, remove the old node
            remove(cache.get(key));
        }

        // Insert the new node at the most recent position
        Node node = new Node(key, value);
        cache.put(key, node);
        insert(node);

        // If the cache exceeds the capacity, remove the LRU node
        if (cache.size() > capacity) {
            Node lru = left.next; // LRU is always the node right after `left`
            remove(lru);
            cache.remove(lru.key); // Remove from the cache
        }
    }

    // Node definition for the doubly linked list
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
