package april_2025;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    int cap;
    Map<Integer, Node> cache;
    Node left;
    Node right;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.cache = new HashMap<>();
        // left = LRU, right = most recent
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    // remove from list
    private void remove(Node node) {
        Node prev = node.prev;
        Node nxt = node.next;

        prev.next = nxt;
        nxt.prev = prev;
    }

    // insert at right
    private void insert(Node node) {
        Node prev = this.right.prev;
        Node nxt = this.right;
        prev.next = node;
        nxt.prev = node;
        node.next = nxt;
        node.prev = prev;
    }

    public int get(int key) {
        if (this.cache.containsKey(key)) {
            // update the most recent
            remove(this.cache.get(key));
            insert(this.cache.get(key));
            return this.cache.get(key).val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (this.cache.containsKey(key)) {
            remove(this.cache.get(key));
        }
        Node newNode = new Node(key, value);
        this.cache.put(key, newNode);
        insert(this.cache.get(key));

        if (this.cache.size() > this.cap) {
            // remove from the list and delete from the LRU from the hashmap
            Node lru = this.left.next;
            remove(lru);
            this.cache.remove(lru.key);
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
