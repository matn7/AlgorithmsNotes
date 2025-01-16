package december_2024;

import java.util.*;

public class GraphValidTree2 {

    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            int n1 = edge[0];
            int n2 = edge[1];
            adj.get(n1).add(n2);
            adj.get(n2).add(n1);
        }
        Set<Integer> visit = new HashSet<>();
        return dfs(0, -1, visit, adj) && visit.size() == n;
    }

    private boolean dfs(int i, int prev, Set<Integer> visit, Map<Integer, List<Integer>> adj) {
        if (visit.contains(i)) {
            return false;
        }
        visit.add(i);
        List<Integer> neighbors = adj.get(i);
        for (int j : neighbors) {
            if (j == prev) {
                continue;
            }
            if (!dfs(j, i, visit, adj)) {
                return false;
            }
        }
        return true;
    }

}
