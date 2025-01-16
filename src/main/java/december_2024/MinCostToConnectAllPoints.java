package december_2024;

import java.util.*;

public class MinCostToConnectAllPoints {

    public static void main(String[] args) {
        // [[0,0],[2,2],[3,3],[2,4],[4,2]]
        int[][] points = {{0, 0}, {2, 2}, {3, 3}, {2, 4}, {4, 2}};
    }

    public int minCostConnectPoints(int[][] points) {
        int N = points.length;

        Map<Integer, List<Integer[]>> adj = new HashMap<>();
        for (int i = 0; i < N; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];

            for (int j = i + 1; j < N; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                adj.get(i).add(new Integer[]{dist, j});
                adj.get(j).add(new Integer[]{dist, i});
            }
        }

        // Prim's
        int res = 0;
        Set<Integer> visit = new HashSet<>();

        PriorityQueue<Integer[]> minH = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minH.add(new Integer[]{0, 0});

        while (visit.size() < N) {
            Integer[] node = minH.poll();
            int cost = node[0];
            int i = node[1];
            if (visit.contains(i)) {
                continue;
            }
            res += cost;
            visit.add(i);
            for (Integer[] neighbor : adj.get(i)) {
                int neiCost = neighbor[0];
                int nei = neighbor[1];
                if (!visit.contains(nei)) {
                    minH.add(new Integer[]{neiCost, nei});
                }
            }
        }
        return res;
    }

}
