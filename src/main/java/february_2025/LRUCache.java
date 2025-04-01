package february_2025;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        int result = lruCache.get(1);
        System.out.println(result);
        lruCache.put(3, 3);
        int result1 = lruCache.get(2);
        System.out.println();
    }

    Map<Integer, Node> cache;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.head.prev = this.tail;
        this.tail.next = this.head;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        // move to front
        removeNode(node);
        addNode(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node currNode = cache.get(key);
            currNode.val = value;
            removeNode(currNode);
            addNode(currNode);
            return;
        }
        Node newNode = new Node(key, value);
        addNode(newNode);
        cache.put(key, newNode);
        if (cache.size() > capacity) {
            Node lastNode = this.tail.next;
            removeNode(lastNode);
            cache.remove(lastNode.key);
        }
    }

    private void addNode(Node node) {
        // node is empty
        if (head.prev == tail) {
            node.next = this.head;
            node.prev = this.tail;
            this.head.prev = node;
            this.tail.next = node;
        } else {
            Node prevNode = this.head.prev;
            this.head.prev = node;
            prevNode.next = node;
            node.next = this.head;
            node.prev = prevNode;
        }
    }

    private void removeNode(Node node) {
        // one node
        if (node.prev == this.tail && node.next == this.head) {
            this.head.prev = this.tail;
            this.tail.next = this.head;
        } else {
            Node prev = node.prev;
            Node next = node.next;
            next.prev = prev;
            prev.next = next;
        }
    }

    static class Node {
        int val;
        int key;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

}
