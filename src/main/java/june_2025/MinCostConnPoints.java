package june_2025;

import java.util.*;

public class MinCostConnPoints {

    public static void main(String[] args) {
        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};

        MinCostConnPoints minCostConnPoints = new MinCostConnPoints();
        int result = minCostConnPoints.minCostConnectPoints(points);
        System.out.println(result);

    }

    // O(n^2 log(n)) time | O(n^2) space
    public int minCostConnectPoints(int[][] points) {

        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int i = 0; i < points.length; i++) {
            int[] curr = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int[] other = points[j];
                int dist = Math.abs(curr[0] - other[0]) + Math.abs(curr[1] - other[1]);
                adj.get(i).add(new int[] {dist, j});
                adj.get(j).add(new int[] {dist, i});
            }
        }
        int res = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.add(new int[] {0, 0});
        boolean[] visited = new boolean[points.length];

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int d1 = current[0];
            int n1 = current[1];
            if (visited[n1]) {
                continue;
            }
            visited[n1] = true;
            res += d1;

            List<int[]> neighbors = adj.getOrDefault(n1, Collections.emptyList());
            for (int[] nei : neighbors) {
                int d2 = nei[0];
                int n2 = nei[1];
                if (!visited[n2]) {
                    minHeap.add(new int[] {d2, n2});
                }
            }
        }
        return res;
    }

}
