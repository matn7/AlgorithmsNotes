package june_2025;

import java.util.*;

public class NetworkDelayTime {

    public static void main(String[] args) {
        int[][] times = {{2,1,1}, {2,3,1}, {3,4,1}};
        int n = 4;
        int k = 2;

        NetworkDelayTime networkDelayTime = new NetworkDelayTime();
        int result = networkDelayTime.networkDelayTime(times, n, k);
        System.out.println(result);
    }

    // O(E log(V)) time | O(E) space
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] time : times) {
            int s = time[0];
            int d = time[1];
            int w = time[2];
            adj.get(s).add(new int[] {d, w});
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.add(new int[] {k, 0});

        int[] costs = new int[n + 1];
        Arrays.fill(costs, -1);
        int visited = 0;
        int max = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int cost = current[1];
            if (costs[node] != -1) {
                continue;
            }
            costs[node] = cost;
            max = Math.max(max, cost);
            visited++;

            List<int[]> neighbors = adj.get(node);
            for (int[] neighbor : neighbors) {
                int d = neighbor[0];
                int w = neighbor[1];
                queue.add(new int[] {d, cost + w});
            }
        }
        return visited < n ? -1 : max;
    }

}
