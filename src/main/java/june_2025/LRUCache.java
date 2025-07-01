package june_2025;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    int capacity;
    Map<Integer, Node> cache;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(0, -1);
        this.tail = new Node(0, -2);

        this.head.prev = this.tail;
        this.tail.next = this.head;

    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node currNode = cache.get(key);
        removeNode(currNode);
        addNode(currNode);
        return currNode.val;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node currNode = cache.get(key);
            removeNode(currNode);
        }
        Node newNode = new Node(value, key);
        cache.put(key, newNode);
        addNode(newNode);
        if (cache.size() > this.capacity) {
            Node tailNode = this.tail.next;
            cache.remove(tailNode.key);
            removeNode(tailNode);
        }
    }

    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;

    }

    private void addNode(Node newNode) {
        if (this.tail.next == this.head) {
            // list is empty
            this.tail.next = newNode;
            this.head.prev = newNode;
            newNode.prev = this.tail;
            newNode.next = this.head;
        } else {
            // there are elements
            Node prev = this.head.prev;

            prev.next = newNode;
            this.head.prev = newNode;
            newNode.prev = prev;
            newNode.next = this.head;
        }
    }

    static class Node {
        int val;
        int key;
        Node next;
        Node prev;

        public Node(int val, int key) {
            this.val = val;
            this.key = key;
        }
    }

}
