package january_2026;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MaxStack {

    private static class Node {
        int val;
        Node prev, next;

        Node(int v) {
            val = v;
        }
    }

    private Node head, tail; // dummy nodes
    private TreeMap<Integer, List<Node>> map;

    public MaxStack() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
        map = new TreeMap<>();
    }

    // dodaje na koniec listy (szczyt stosu)
    public void push(int x) {
        Node node = new Node(x);
        addNode(node);

        map.computeIfAbsent(x, k -> new ArrayList<>()).add(node);
    }

    public int pop() {
        Node node = tail.prev;
        removeNode(node);
        removeFromMap(node);
        return node.val;
    }

    public int top() {
        return tail.prev.val;
    }

    public int peekMax() {
        return map.lastKey();
    }

    public int popMax() {
        int max = map.lastKey();
        List<Node> nodes = map.get(max);
        Node node = nodes.remove(nodes.size() - 1); // najbliższy szczytu

        if (nodes.isEmpty()) {
            map.remove(max);
        }

        removeNode(node);
        return max;
    }

    /* ---------- helpers ---------- */

    private void addNode(Node node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void removeFromMap(Node node) {
        List<Node> nodes = map.get(node.val);
        nodes.remove(nodes.size() - 1);
        if (nodes.isEmpty()) {
            map.remove(node.val);
        }
    }
}
