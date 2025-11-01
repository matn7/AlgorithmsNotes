package october_2025;

import java.util.*;

public class CloneGraph2 {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        CloneGraph2 cloneGraph2 = new CloneGraph2();
        Node node = cloneGraph2.cloneGraph(node1);
        System.out.println(node);
    }

    // O(n) time | O(n) space
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> adj = new HashMap<>();
        dfs(node, adj);
        return adj.get(node);
    }

    private Node dfs(Node node, Map<Node, Node> adj) {
        if (adj.containsKey(node)) {
            return adj.get(node);
        }
        Node copy = new Node(node.val);
        adj.put(node, copy);

        for (Node nei : node.neighbors) {
            copy.neighbors.add(dfs(nei, adj));
        }
        return copy;
    }

    // O(V + E) time | O(V + E) space
    public Node cloneGraph2(Node node) {
        if (node == null) {
            return null;
        }
        Map<Integer, Node> adj = new HashMap<>();
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.addLast(node);
        Set<Integer> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            Node current = queue.removeFirst();
            if (visited.contains(current.val)) {
                continue;
            }
            visited.add(current.val);
            int curVal = current.val;
            if (!adj.containsKey(curVal)) {
                adj.put(curVal, new Node(curVal));
            }
            List<Node> neighbors = current.neighbors;
            for (Node nei : neighbors) {
                int neiVal = nei.val;
                if (!adj.containsKey(neiVal)) {
                    adj.put(neiVal, new Node(neiVal));
                }
                Node newNei = adj.get(neiVal);
                if (!adj.get(curVal).neighbors.contains(newNei)) {
                    adj.get(curVal).neighbors.add(newNei);
                }
                if (!visited.contains(neiVal)) {
                    queue.addLast(nei);
                }
            }
        }

        return adj.get(node.val);
    }

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

}
