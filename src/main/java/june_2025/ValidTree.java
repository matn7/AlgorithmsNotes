package june_2025;

import java.util.*;

public class ValidTree {

    public static void main(String[] args) {
        // n = 5
        // edges = [[0, 1], [0, 2], [0, 3], [1, 4]]
        // n = 5
        // edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]]
        int n = 5;
//        int[][] edges = {{0,1}, {0,2}, {0,3}, {1,4}};
        int[][] edges = {{0,1}, {1,2}, {2,3}, {1,3}, {1,4}};

        ValidTree validTree = new ValidTree();
        boolean result = validTree.validTree(n, edges);
        System.out.println(result);
    }

    // O(V + E) time | O(V + E) space
    public boolean validTree(int n, int[][] edges) {

        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> visiting = new HashSet<>();

        if (cycle(0, -1, adj, visiting, visited)) {
            return false;
        }

        return visited.size() == n;
    }

    private boolean cycle(int node, int from, Map<Integer, List<Integer>> adj, Set<Integer> visiting, Set<Integer> visited) {
        if (visiting.contains(node)) {
            return true;
        }
        if (visited.contains(node)) {
            return false;
        }
        visiting.add(node);
        List<Integer> neighbors = adj.get(node);
        for (int nei : neighbors) {
            if (nei != from) {
                if (cycle(nei, node, adj, visiting, visited)) {
                    return true;
                }
            }
        }

        visiting.remove(node);
        visited.add(node);
        return false;
    }

}
