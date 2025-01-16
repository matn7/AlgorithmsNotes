package december_2024;

import java.util.*;

public class CountComponents {

    public static void main(String[] args) {
//        int n = 6;
//        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {4, 5}};

        int n = 3;
        int[][] edges = {{0, 1}, {0, 2}};

        CountComponents countComponents = new CountComponents();
        int result = countComponents.countComponents(n, edges);
        System.out.println(result);
    }

    // O(v + e) time
    public int countComponents(int n, int[][] edges) {
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

        int count = 0;
        Set<Integer> visit = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!visit.contains(i)) {
                count++;
                dfs(i, -1, adj, visit);
            }
        }

        return count;
    }

    private void dfs(int j, int prev, Map<Integer, List<Integer>> adj, Set<Integer> visit) {
        if (visit.contains(j)) {
            return;
        }
        visit.add(j);
        List<Integer> neighbors = adj.get(j);
        for (int neighbor : neighbors) {
            if (neighbor == prev) {
                continue;
            }
            dfs(neighbor, j, adj, visit);
        }
    }

}
