package december_2024;

import java.util.*;

public class MinCostToConnectAllPoints2 {

    public static void main(String[] args) {
        // [[0,0],[2,2],[3,3],[2,4],[4,2]]
        int[][] points = {{0, 0}, {2, 2}, {3, 3}, {2, 4}, {4, 2}};

        MinCostToConnectAllPoints2 minCost = new MinCostToConnectAllPoints2();
        int result = minCost.minCostConnectPoints(points);
        System.out.println(result);
    }

    public int minCostConnectPoints(int[][] points) {
        int N = points.length;
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < N; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                adj.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[]{dist, j});
                adj.computeIfAbsent(j, k -> new ArrayList<>()).add(new int[]{dist, i});
            }
        }

        PriorityQueue<int[]> minH = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minH.add(new int[] {0, 0});
        int res = 0;
        Set<Integer> visit = new HashSet<>();
        while (visit.size() < N) {
            int[] current = minH.poll();
            int dist = current[0];
            int i = current[1];
            if (visit.contains(i)) {
                continue;
            }
            res += dist;
            visit.add(i);
            for (int[] neighbor : adj.getOrDefault(i, Collections.emptyList())) {
                int neiCost = neighbor[0];
                int neiIndex = neighbor[1];
                if (!visit.contains(neiIndex)) {
                    minH.add(new int[] {neiCost, neiIndex});
                }
            }
        }

        return res;
    }

}
