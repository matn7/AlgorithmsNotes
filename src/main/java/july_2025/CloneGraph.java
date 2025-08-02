package july_2025;

import june_2025.CloneGraph2;

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

    // O(V + E) time | O(V) space
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> origToNew = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Set<Integer> seen = new HashSet<>();

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int val = current.val;
            if (!origToNew.containsKey(current)) {
                Node newNode = new Node(val);
                origToNew.put(current, newNode);
            }
            if (seen.contains(val)) {
                continue;
            }
            seen.add(current.val);
            List<Node> neighbors = current.neighbors;
            for (Node nei : neighbors) {
                if (!origToNew.containsKey(nei)) {
                    int neiVal = nei.val;
                    Node newNeiNode = new Node(neiVal);
                    origToNew.put(nei, newNeiNode);
                }
                if (seen.contains(nei.val)) {
                    continue;
                }
                Node newCurrent = origToNew.get(current);
                Node newNei = origToNew.get(nei);
                newCurrent.neighbors.add(newNei);
                newNei.neighbors.add(newCurrent);
                queue.add(nei);
            }
        }
        return origToNew.get(node);
    }

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node(int val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }
    }
}
