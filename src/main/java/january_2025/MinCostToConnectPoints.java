package january_2025;

import java.util.*;

public class MinCostToConnectPoints {

    public static void main(String[] args) {
        int[][] points = {{0,0}, {2,2}, {3,3}, {2,4}, {4,2}};

        MinCostToConnectPoints minCostToConnectPoints = new MinCostToConnectPoints();
        int result = minCostToConnectPoints.minCostConnectPoints(points);
        System.out.println(result);
    }

    // O(n^2log(n)) time | O(n^2) space
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
                adj.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[] {dist, j});
                adj.computeIfAbsent(j, k -> new ArrayList<>()).add(new int[] {dist, i});
            }
        }

        Set<Integer> visited = new HashSet<>();
        int result = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
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
                int neighborCost = neighbor[0];
                int neighborNode = neighbor[1];
                if (!visited.contains(neighborNode)) {
                    minHeap.add(new int[] {neighborCost, neighborNode});
                }
            }
        }

        return result;
    }
}
