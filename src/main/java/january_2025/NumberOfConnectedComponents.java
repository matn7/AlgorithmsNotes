package january_2025;

import java.util.*;

public class NumberOfConnectedComponents {

    public static void main(String[] args) {
        NumberOfConnectedComponents numberOfConnectedComponents = new NumberOfConnectedComponents();
        int n = 5;
        int[][] edges = {{0,1}, {1,2}, {3,4}};
        int result = numberOfConnectedComponents.countComponents(n, edges);
        System.out.println(result);
    }

    // O(E + V) time | O(E + V) space
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int s = edge[0];
            int d = edge[1];
            adj.computeIfAbsent(s, k -> new ArrayList<>()).add(d);
            adj.computeIfAbsent(d, k -> new ArrayList<>()).add(s);
        }

        int count = 0;
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                count++;
                dfs(i, -1, adj, visited);
            }
        }

        return count;
    }

    private void dfs(int node, int prev, Map<Integer, List<Integer>> adj, Set<Integer> visited) {

        visited.add(node);
        List<Integer> neighbors = adj.getOrDefault(node, new ArrayList<>());

        for (Integer neighbor : neighbors) {
            if (prev != neighbor && !visited.contains(neighbor)) {
                dfs(neighbor, node, adj, visited);
            }
        }
    }

}
