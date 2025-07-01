package june_2025;

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
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        CloneGraph cloneGraph = new CloneGraph();
        Node node = cloneGraph.cloneGraph(node1);
        System.out.println(node);
    }

    // O(V + E) time | O(V) space
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Integer, Node> adj = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Set<Integer> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            int currVal = curr.val;
            if (visited.contains(currVal)) {
                continue;
            }
            visited.add(currVal);

            if (!adj.containsKey(currVal)) {
                Node newCurr = new Node(currVal);
                adj.put(newCurr.val, newCurr);
            }

            List<Node> neighbors = curr.neighbors;
            for (Node nei : neighbors) {
                queue.add(nei);
                int neiVal = nei.val;
                if (visited.contains(neiVal)) {
                    continue;
                }
                if (!adj.containsKey(neiVal)) {
                    Node newNeighbor = new Node(neiVal);
                    adj.put(newNeighbor.val, newNeighbor);
                }
                Node newCurr = adj.get(currVal);
                Node newNeighbor = adj.get(neiVal);
                newCurr.neighbors.add(newNeighbor);
                newNeighbor.neighbors.add(newCurr);
            }
        }
        return adj.get(node.val);
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }
    }

}
