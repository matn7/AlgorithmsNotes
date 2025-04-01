package january_2025;

import java.util.HashMap;
import java.util.Map;

public class LRUCache3 {

    public static void main(String[] args) {
        LRUCache3 lruCache3 = new LRUCache3(1);
        lruCache3.put(2, 1);
        int result = lruCache3.get(2);
        System.out.println(result);

    }

    int capacity;
    Map<Integer, Node> cache;
    Node left;
    Node right;

    public LRUCache3(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.right = new Node(0, 0);
        this.left = new Node(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            // move element to right
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // move to front do not add
            Node node = cache.get(key);
            remove(node);
        }
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        // add to right
        insert(newNode);
        // check capacity
        if (cache.size() > capacity) {
            // remove last element
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }

    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insert(Node node) {
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
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
