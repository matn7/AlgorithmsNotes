package may_2025;

import java.util.*;

public class MinCostConnectPoints {

    public static void main(String[] args) {
        // [[0,0],[2,2],[3,10],[5,2],[7,0]]
        int[][] points = {{0,0}, {2,2}, {3,10}, {5,2}, {7,0}};
        MinCostConnectPoints minCostConnectPoints = new MinCostConnectPoints();
        int result = minCostConnectPoints.minCostConnectPoints(points);
        System.out.println(result);
    }

    // O(E * log(V)) time | O(V + E) space
    public int minCostConnectPoints(int[][] points) {
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int[] source = points[i];
                int[] dest = points[j];
                int dist = Math.abs(source[0] - dest[0]) + Math.abs(source[1] - dest[1]);
                adj.get(i).add(new int[] {j, dist});
                adj.get(j).add(new int[] {i, dist});
            }
        }
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.add(new int[] {0, 0});
        int sum = 0;

        while (visited.size() < points.length) {
            int[] current = queue.poll();
            int n1 = current[0];
            int w1 = current[1];
            if (visited.contains(n1)) {
                continue;
            }
            sum += w1;
            visited.add(n1);
            List<int[]> neighbors = adj.get(n1);
            for (int[] neighbor : neighbors) {
                int n2 = neighbor[0];
                int w2 = neighbor[1];
                if (visited.contains(n2)) {
                    continue;
                }
                queue.add(new int[] {n2, w2});
            }
        }

        return sum;
    }

}
