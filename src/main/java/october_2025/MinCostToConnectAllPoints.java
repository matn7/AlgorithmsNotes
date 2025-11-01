package october_2025;

import java.util.*;

public class MinCostToConnectAllPoints {

    public static void main(String[] args) {
        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};

        MinCostToConnectAllPoints minCostToConnectAllPoints = new MinCostToConnectAllPoints();
        int result = minCostToConnectAllPoints.minCostConnectPoints(points);
        System.out.println(result);
    }

    // O(n^2 log(n)) time | O(n^2) space
    public int minCostConnectPoints(int[][] points) {
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            int[] src = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int[] dst = points[j];
                int distance = Math.abs(src[0] - dst[0]) + Math.abs(src[1] - dst[1]);
                adj.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[] {distance, j});
                adj.computeIfAbsent(j, k -> new ArrayList<>()).add(new int[] {distance, i});
            }
        }

        int result = 0;
        Set<Integer> visit = new HashSet<>();
        PriorityQueue<int[]> minH = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minH.add(new int[] {0, 0});
        while (visit.size() < points.length) {
            int[] curr = minH.poll();
            int cost = curr[0];
            int i = curr[1];
            if (visit.contains(i)) {
                continue;
            }
            result += cost;
            visit.add(i);
            for (int[] nei : adj.getOrDefault(i, Collections.emptyList())) {
                int neiCost = nei[0];
                int neiIndex = nei[1];
                if (!visit.contains(neiIndex)) {
                    minH.add(new int[] {neiCost, neiIndex});
                }
            }
        }

        return result;
    }

}
