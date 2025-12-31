package december_2025;

import java.util.*;

public class MinCostToConnectAllPoints {

    public static void main(String[] args) {
        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};

        MinCostToConnectAllPoints minCostToConnectAllPoints = new MinCostToConnectAllPoints();
        int result = minCostToConnectAllPoints.minCostConnectPoints(points);
        System.out.println(result);

    }

    // O(n^2) time | O(n) space
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
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.add(new int[] {0, 0});
        int total = 0;
        while (visited.size() != points.length) {
            int[] current = minHeap.poll();
            int node = current[0];
            int cost = current[1];
            if (visited.contains(node)) {
                continue;
            }
            visited.add(node);
            total += cost;
            List<int[]> neighbors = adj.get(node);
            for (int[] nei : neighbors) {
                int n2 = nei[0];
                int c2 = nei[1];
                if (visited.contains(n2)) {
                    continue;
                }
                minHeap.add(new int[] {n2, c2});
            }
        }
        return total;
    }

}
