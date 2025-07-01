package june_2025;

import java.util.*;

public class MinCostConnectPoints {

    public static void main(String[] args) {
        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};

        MinCostConnectPoints minCostConnectPoints = new MinCostConnectPoints();
        int result = minCostConnectPoints.minCostConnectPoints(points);
        System.out.println(result);

    }

    // O(n^2 log(n)) time | O(n^2) space
    public int minCostConnectPoints(int[][] points) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                // |xi - xj| + |yi - yj|
                int[] a = points[i];
                int[] b = points[j];
                int dist = Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
                adj.get(i).add(new int[] {j, dist});
                adj.get(j).add(new int[] {i, dist});
            }
        }
        int distance = 0;
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.add(new int[] {0, 0});

        while (visited.size() < points.length) {
            int[] current = queue.poll();
            int node = current[0];
            int dist = current[1];
            if (visited.contains(node)) {
                continue;
            }
            visited.add(node);
            distance += dist;

            List<int[]> neighbors = adj.get(node);
            for (int[] neighbor : neighbors) {
                if (!visited.contains(neighbor[0])) {
                    queue.add(new int[] {neighbor[0], neighbor[1]});
                }
            }
        }

        return distance;
    }

}
