package january_2025;

import java.util.*;

public class MinCostToConnectPoints2 {

    public int minCostConnectPoints2(int[][] points) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        int N = points.length;
        for (int i = 0; i < N; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < N; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                adj.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[] {dist, j});
                adj.computeIfAbsent(j, k -> new ArrayList<>()).add(new int[] {dist, i});
            }
        }

        Set<Integer> visited = new HashSet<>();
        int result = 0;
        PriorityQueue<int[]> minHeap =
                new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.add(new int[] {0, 0});

        while (visited.size() < N) {
            int[] current = minHeap.poll();
            int cost = current[0];
            int node = current[1];
            if (visited.contains(node)) {
                continue;
            }
            visited.add(node);
            result += cost;

            List<int[]> neighbors = adj.getOrDefault(node, new ArrayList<>());
            for (int[] neighbor : neighbors) {
                int neiNode = neighbor[1];
                if (!visited.contains(neiNode)) {
                    int neiCost = neighbor[0];
                    minHeap.add(new int[] {neiCost, neiNode});
                }
            }
        }


        return result;
    }
}
