package august_2025;

import java.util.*;

public class CloneGraph {


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
        node4.neighbors.add(node3);
        node4.neighbors.add(node1);

        CloneGraph cloneGraph = new CloneGraph();
        Node node = cloneGraph.cloneGraph(node1);
        System.out.println(node);
    }

    public Node cloneGraph(Node node) {
        Map<Node, Node> oldToNew = new HashMap<>();

        return dfs(node, oldToNew);
    }

    private Node dfs(Node node, Map<Node, Node> oldToNew) {
        if (node == null) {
            return null;
        }
        if (oldToNew.containsKey(node)) {
            return oldToNew.get(node);
        }
        Node copy = new Node(node.val);
        oldToNew.put(node, copy);

        for (Node nei : node.neighbors) {
            copy.neighbors.add(dfs(nei, oldToNew));
        }

        return copy;
    }

    // O(v + e) time | O(v) space
    public Node cloneGraph2(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> origToNew = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Set<Integer> seen = new HashSet<>();

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (!origToNew.containsKey(current)) {
                origToNew.put(current, new Node(current.val));
            }
            if (seen.contains(current.val)) {
                continue;
            }
            seen.add(current.val);
            List<Node> neighbors = current.neighbors;
            for (Node nei : neighbors) {
                if (!origToNew.containsKey(nei)) {
                    origToNew.put(nei, new Node(nei.val));
                }
                Node newCurrent = origToNew.get(current);
                Node newCurrentNei = origToNew.get(nei);
                newCurrent.neighbors.add(newCurrentNei);
                queue.add(nei);
            }
        }
        return origToNew.get(node);
    }

    static class Node {
        int val;
        List<Node> neighbors;

        public Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }
    }
}
