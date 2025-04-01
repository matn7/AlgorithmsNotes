package march_2025;

import java.util.*;

public class MinCostConnectPoints {

    public static void main(String[] args) {
        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};

        MinCostConnectPoints minCostConnectPoints = new MinCostConnectPoints();
        int result = minCostConnectPoints.minCostConnectPoints(points);
        System.out.println(result);
    }

    // O(n^2 * log(n)) time | O(n^2) space
    public int minCostConnectPoints(int[][] points) {
        Map<Integer, List<int[]>> adj = new HashMap<>(); // {source: [{destination, cost}]}

        for (int i = 0; i < points.length; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int i = 0; i < points.length; i++) {
            int[] point1 = points[i];
            int x1 = point1[0];
            int y1 = point1[1];
            for (int j = i + 1; j < points.length; j++) {
                int[] point2 = points[j];
                int x2 = point2[0];
                int y2 = point2[1];
                int cost = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                adj.get(i).add(new int[] {j, cost});
                adj.get(j).add(new int[] {i, cost});
            }
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(a -> a[1]));
        queue.add(new int[] {0, 0});
        Set<Integer> visited = new HashSet<>();
        int result = 0;
        while (visited.size() < points.length) {
            int[] current = queue.poll();
            int source = current[0];
            int cost = current[1];
            if (visited.contains(source)) {
                continue;
            }

            visited.add(source);
            result += cost;

            List<int[]> neighbors = adj.get(source);

            for (int[] neighbor : neighbors) {
                int neiDest = neighbor[0];
                int neiCost = neighbor[1];
                if (!visited.contains(neiDest)) {
                    queue.add(new int[] {neiDest, neiCost});
                }
            }
        }
        return result;
    }

}
