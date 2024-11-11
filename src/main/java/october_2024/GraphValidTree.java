package october_2024;

import java.util.*;

public class GraphValidTree {

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};

        GraphValidTree graphValidTree = new GraphValidTree();
        boolean result = graphValidTree.validTree(5, edges);
        System.out.println(result);
    }

    // leetcode premium 261

    // O(v + e) time | O(v + e) space
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, Node> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new Node(i, null));
        }

        for (int[] edge : edges) {
            int source = edge[0];
            int destination = edge[1];
            Node sourceNode = graph.get(source);
            Node destinationNode = graph.get(destination);
            sourceNode.addNeighbor(destinationNode);
            destinationNode.addNeighbor(sourceNode);
            destinationNode.prev = sourceNode;
        }

        Set<Integer> visited = new HashSet<>();

        Node node = graph.get(0);
        if (dfs(node, visited)) {
            return false;
        }

        // check if all nodes are connected
        return visited.size() == n;
    }

    private boolean dfs(Node node, Set<Integer> visited) {
        if (visited.contains(node.value)) {
            return true;
        }
        visited.add(node.value);
        List<Node> neighbors = node.neighbors;
        for (Node neighbor : neighbors) {
            if (node.prev == neighbor) {
                continue;
            }
            if (dfs(neighbor, visited)) {
                return true;
            }
        }
        return false;
    }

    static class Node {
        int value;
        Node prev;
        List<Node> neighbors;

        public Node(int value, Node prev) {
            this.value = value;
            this.prev = prev;
            this.neighbors = new ArrayList<>();
        }

        public void addNeighbor(Node node) {
            this.neighbors.add(node);
        }
    }

}
