package april_2025;

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

    // O(V + E) time | O(V + E) space
    public Node cloneGraph(Node node) {

        Map<Integer, Node> adj = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Set<Integer> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            Node originalNode = queue.poll();
            int originalVal = originalNode.val;
            if (visited.contains(originalVal)) {
                continue;
            }
            visited.add(originalVal);
            if (!adj.containsKey(originalVal)) {
                Node newNode = new Node(originalVal);
                adj.put(newNode.val, newNode);
            }
            List<Node> originalNodeNeighbors = originalNode.neighbors;
            for (Node neighbor : originalNodeNeighbors) {
                if (visited.contains(neighbor.val)) {
                    continue;
                }
                Node newNode = adj.get(originalVal);
                Node newNeighborNode = adj.getOrDefault(neighbor.val, new Node(neighbor.val));
                if (!adj.containsKey(neighbor.val)) {
                    adj.put(neighbor.val, newNeighborNode);
                }
                newNode.neighbors.add(newNeighborNode);
                newNeighborNode.neighbors.add(newNode);
                queue.add(neighbor);
            }
        }
        return adj.get(node.val);
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
