package october_2024;

import java.util.*;

public class NumberOfConnectedComponents {

    public static void main(String[] args) {
        int[][] edges = {{0,1}, {1,2}, {3,4}};
        int n = 5;

        NumberOfConnectedComponents numberOfConnectedComponents = new NumberOfConnectedComponents();
        int result = numberOfConnectedComponents.countComponents(n, edges);
        System.out.println(result);
    }


    // leetcode 323 premium

    // O(v + e) time | O(v) space
    public int countComponents(int n, int[][] edges) {
        Map<Integer, Node> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new Node(i));
        }

        for (int[] edge : edges) {
            Node node1 = graph.get(edge[0]); // 0
            Node node2 = graph.get(edge[1]); // 1
            node1.addNeighbor(node2);
            node2.addNeighbor(node1);
            node2.prev = node1;
        }

        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                count++;
                Node node = graph.get(i);
                dfs(node, visited);
            }
        }

        return count;
    }

    private void dfs(Node node, Set<Integer> visited) {
        if (visited.contains(node.idx)) {
            return;
        }
        visited.add(node.idx);
        Node prev = node.prev;
        List<Node> neighbors = node.neighbors;
        for (Node neighbor : neighbors) {
            if (prev != neighbor) {
                dfs(neighbor, visited);
            }
        }
    }

    static class Node {
        int idx;
        Node prev;
        List<Node> neighbors;

        public Node(int idx) {
            this.idx = idx;
            this.neighbors = new ArrayList<>();
        }

        public void addNeighbor(Node node) {
            this.neighbors.add(node);
        }
    }

}
