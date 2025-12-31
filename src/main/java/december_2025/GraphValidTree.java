package december_2025;

import java.util.*;

public class GraphValidTree {

    public static void main(String[] args) {
//        int n = 5;
//        int[][] edges = {{0,1},{0,2},{0,3},{1,4}};

        int n = 5;
        int[][] edges = {{0,1},{1,2},{2,3},{1,3},{1,4}};

        GraphValidTree graphValidTree = new GraphValidTree();
        boolean result = graphValidTree.validTree(n, edges);
        System.out.println(result);

    }

    // O(v + e) time | O(v + e) space
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
        Set<Integer> visiting = new HashSet<>();

        if (cycle(0, -1, adj, visiting, visited)) {
            return false;
        }
        return visited.size() == n;
    }

    private boolean cycle(int node, int parent, Map<Integer, List<Integer>> adj, Set<Integer> visiting, Set<Integer> visited) {
        if (visited.contains(node)) {
            return false;
        }
        if (visiting.contains(node)) {
            return true;
        }

        visiting.add(node);

        List<Integer> neighbors = adj.get(node);
        for (int nei : neighbors) {
            if (nei == parent) {
                continue;
            }
            if (cycle(nei, node, adj, visiting, visited)) {
                return true;
            }
        }

        visiting.remove(node);
        visited.add(node);
        return false;
    }

}
