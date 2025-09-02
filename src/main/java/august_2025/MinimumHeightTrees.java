package august_2025;

import java.util.*;

public class MinimumHeightTrees {

    // O(v + e) time | O(v) space
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            List<Integer> res = new ArrayList<>();
            res.add(0);
            return res;
        }

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

        Map<Integer, Integer> edgeCnt = new HashMap<>();
        LinkedList<Integer> leaves = new LinkedList<>();

        for (Map.Entry<Integer, List<Integer>> element : adj.entrySet()) {
            int src = element.getKey();
            List<Integer> neighbors = element.getValue();
            if (neighbors.size() == 1) {
                leaves.add(src);
            }
            edgeCnt.put(src, neighbors.size());
        }

        while (!leaves.isEmpty()) {
            if (n <= 2) {
                return new ArrayList<>(leaves);
            }
            int size = leaves.size();
            for (int i = 0; i < size; i++) {
                int node = leaves.poll();
                n--;
                List<Integer> neighbors = adj.get(node);
                for (int nei : neighbors) {
                    edgeCnt.put(nei, edgeCnt.getOrDefault(nei, 0) - 1);
                    if (edgeCnt.get(nei) == 1) {
                        leaves.add(nei);
                    }
                }
            }
        }
        return new ArrayList<>();
    }

}
