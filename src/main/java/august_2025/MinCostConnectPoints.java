package august_2025;

import java.util.*;

public class MinCostConnectPoints {

    public static void main(String[] args) {
        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};

        MinCostConnectPoints minCostConnectPoints = new MinCostConnectPoints();
        int res = minCostConnectPoints.minCostConnectPoints(points);
        System.out.println(res);

    }

    // O(n^2 log(n)) time | O(n^2) space
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

        int res = 0;
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.add(new int[] {0, 0});

        while (visited.size() != points.length) {
            int[] current = minHeap.poll();
            int node = current[0];
            int dist = current[1];
            if (visited.contains(node)) {
                continue;
            }
            res += dist;
            visited.add(node);
            List<int[]> neighbors = adj.get(node);
            for (int[] nei : neighbors) {
                int neiNode = nei[0];
                int neiDist = nei[1];
                if (visited.contains(neiNode)) {
                    continue;
                }
                minHeap.add(new int[] {neiNode, neiDist});
            }
        }
        return res;
    }

}
