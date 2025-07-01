package june_2025;

import java.util.*;

public class GraphValidTree {

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0,1}, {0,2}, {0,3}, {1,4}};

        GraphValidTree graphValidTree = new GraphValidTree();
        boolean result = graphValidTree.validTree(n, edges);
        System.out.println(result);
    }

    // O(V + E) time | O(V + E) space
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            int s = edge[0];
            int d = edge[1];
            adj.get(s).add(d);
            adj.get(d).add(s);
        }
        Set<Integer> visited = new HashSet<>();
        if (cycle(adj, 0, -1, visited)) {
            return false;
        }
        return visited.size() == n;
    }

    private boolean cycle(Map<Integer, List<Integer>> adj, int node, int prev, Set<Integer> visited) {
        if (visited.contains(node)) {
            return false;
        }

        List<Integer> neighbors = adj.get(node);
        for (int nei : neighbors) {
            if (nei == prev) {
                continue;
            }
            if (cycle(adj, nei, node, visited)) {
                return true;
            }
        }

        visited.add(node);
        return false;
    }

}
