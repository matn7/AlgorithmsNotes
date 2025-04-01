package february_2025;

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
        Map<Integer, Node> adjList = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node original = queue.poll();
            if (original == null) {
                continue;
            }
            int id = original.val;
            if (visited.contains(id)) {
                continue;
            }
            visited.add(id);
            if (!adjList.containsKey(id)) {
                adjList.put(id, new Node(id));
            }
            List<Node> neighbors = original.neighbors;
            for (Node neighbor : neighbors) {
                if (!adjList.containsKey(neighbor.val)) {
                    adjList.put(neighbor.val, new Node(neighbor.val));
                }
                Node newNodeSource = adjList.get(id);
                Node newNodeDest = adjList.get(neighbor.val);
                newNodeSource.neighbors.add(newNodeDest);
                queue.add(neighbor);
            }
        }
        return adjList.get(node.val);
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
