package december_2024;

import java.util.*;

public class GraphValidTree {

    public static void main(String[] args) {
        int n = 4;
//        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
//        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};

        int[][] edges = {{0,1},{2,3}};

        GraphValidTree graphValidTree = new GraphValidTree();
        boolean result = graphValidTree.validTree(n, edges);
        System.out.println(result);
    }

    // O(v + e) time
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, Node> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new Node(i));
        }
        for (int[] edge : edges) {
            Node node1 = graph.get(edge[0]);
            Node node2 = graph.get(edge[1]);
            node1.neighbors.add(node2);
            node2.neighbors.add(node1);
        }
        Set<Integer> visited = new HashSet<>();
        Set<Integer> visiting = new HashSet<>();

        Node node = graph.get(0);
        boolean cycle = dfs(node, null, visited, visiting);
        return !cycle && visited.size() == n;
    }

    private boolean dfs(Node node, Node prev, Set<Integer> visited, Set<Integer> visiting) {
        if (visiting.contains(node.id)) {
            return true;
        }
        if (visited.contains(node.id)) {
            return false;
        }
        visiting.add(node.id);

        List<Node> neighbors = node.neighbors;
        for (Node neighbor : neighbors) {
            if (neighbor != prev) {
                if (dfs(neighbor, node, visited, visiting)) {
                    return true;
                }
            }
        }

        visiting.remove(node.id);
        visited.add(node.id);
        return false;
    }

    static class Node {
        int id;
        List<Node> neighbors;

        public Node(int id) {
            this.id = id;
            this.neighbors = new ArrayList<>();
        }
    }

}
