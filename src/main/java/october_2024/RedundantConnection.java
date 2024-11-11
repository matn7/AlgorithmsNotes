package october_2024;

import java.util.*;

public class RedundantConnection {

    public static void main(String[] args) {
        // int[][] edges = {{1,2}, {1,3}, {2,3}};
        int[][] edges = {{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};

        RedundantConnection redundantConnection = new RedundantConnection();
        int[] result = redundantConnection.findRedundantConnection(edges);
        System.out.println(result);
    }

    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, Node> graph = new HashMap<>();
        for (int i = 1; i <= edges.length; i++) {
            graph.put(i, new Node(i));
        }
        Set<Integer> visited = new HashSet<>();
        Node maxNode = getMaxNode(edges, graph);
        dfs(maxNode, maxNode, visited);
        return null;
    }

    private void dfs(Node node, Node sourceNode, Set<Integer> visited) {
        if (visited.contains(node.id)) {
            return;
        }
        visited.add(node.id);

        List<Node> neighbors = node.neighbors;
        for (Node neighbor : neighbors) {
            if (neighbor == sourceNode) {
                // found last node
                System.out.println();
            }
            dfs(neighbor, sourceNode, visited);
        }

    }

    private Node getMaxNode(int[][] edges, Map<Integer, Node> graph) {
        Node maxNode = graph.get(1);
        int max = 0;
        for (int[] edge : edges) {
            int vertex1 = edge[0];
            int vertex2 = edge[1];
            Node node1 = graph.get(vertex1);
            Node node2 = graph.get(vertex2);
            node1.addNeighbor(node2);
            node2.addNeighbor(node1);
            node1.degree++;
            node2.degree++;

            int currMax = Math.max(node1.degree, node2.degree);
            if (currMax > max) {
                max = currMax;
                if (node1.degree >= node2.degree) {
                    maxNode = node1;
                } else {
                    maxNode = node2;
                }
            }
        }
        return maxNode;
    }

    static class Node {
        int id;
        int degree;
        List<Node> neighbors;

        public Node(int id) {
            this.id = id;
            this.neighbors = new ArrayList<>();
        }

        public void addNeighbor(Node node) {
            this.neighbors.add(node);
        }
    }
}
