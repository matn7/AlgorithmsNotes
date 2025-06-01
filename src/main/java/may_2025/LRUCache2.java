package may_2025;

import java.util.HashMap;
import java.util.Map;

public class LRUCache2 {

    public static void main(String[] args) {
        LRUCache2 lruCache = new LRUCache2(1);
        lruCache.put(2, 1);
        System.out.println(lruCache.get(2));
    }


    int capacity;
    Map<Integer, Node> cache;
    Node head;
    Node tail;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.tail.next = this.head;
        this.head.prev = this.tail;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        remove(node);
        addFirst(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node newNode = new Node(key, value);
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
        }
        addFirst(newNode);
        cache.put(key, newNode);
        if (cache.size() > capacity) {
            Node tail = this.tail.next;
            // tail key?
            remove(tail);
            cache.remove(tail.key);
        }

    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void addFirst(Node node) {
        if (this.tail.next == this.head) {
            this.tail.next = node;
            this.head.prev = node;
            node.next = this.head;
            node.prev = this.tail;
        } else {
            Node prev = this.head.prev;
            prev.next = node;
            this.head.prev = node;
            node.next = this.head;
            node.prev = prev;
        }

    }

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
