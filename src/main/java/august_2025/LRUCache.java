package august_2025;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    int capacity;
    Map<Integer, Node> cache;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        // remove node
        remove(node);
        // add node to front
        addNode(node);
        return node.value;

    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // remove node
            Node node = cache.get(key);
            remove(node);
        }
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        // add newNode to front
        addNode(newNode);
        if (cache.size() > capacity) {
            Node tailNode = tail.prev;
            // remove tailNode
            remove(tailNode);
            cache.remove(tailNode.key);
        }
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        next.prev = prev;
        prev.next = next;
    }

    private void addNode(Node node) {
        if (head.prev == tail) {
            Node prev = tail;
            head.next = node;
            prev.prev = node;
            node.next = prev;
            node.prev = head;
        } else {
            Node prev = head.next;
            head.next = node;
            prev.prev = node;
            node.next = prev;
            node.prev = head;
        }
    }

    static class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}
