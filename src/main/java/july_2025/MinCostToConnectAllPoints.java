package july_2025;

import java.util.*;

public class MinCostToConnectAllPoints {

    public static void main(String[] args) {
        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};

        MinCostToConnectAllPoints minCostToConnectAllPoints = new MinCostToConnectAllPoints();
        int result = minCostToConnectAllPoints.minCostConnectPoints(points);
        System.out.println(result);

    }

    // O(n^2 * log(n)) time | O(n^2) space
    public int minCostConnectPoints(int[][] points) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int i = 0; i < points.length; i++) {
            int[] p1 = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int[] p2 = points[j];
                int dist = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
                adj.get(i).add(new int[] {j, dist});
                adj.get(j).add(new int[] {i, dist});
            }
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.add(new int[] {0, 0});
        Set<Integer> seen = new HashSet<>();
        int cost = 0;
        while (seen.size() < points.length) {
            int[] current = queue.poll();
            int n1 = current[0];
            int d1 = current[1];
            if (seen.contains(n1)) {
                continue;
            }

            seen.add(n1);
            cost += d1;

            List<int[]> neighbors = adj.getOrDefault(n1, Collections.emptyList());
            for (int[] nei : neighbors) {
                int n2 = nei[0];
                int d2 = nei[1];
                if (!seen.contains(n2)) {
                    queue.add(new int[] {n2, d2});
                }
            }

        }
        return cost;
    }

}
