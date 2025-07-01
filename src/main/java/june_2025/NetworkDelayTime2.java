package june_2025;

import java.util.*;

public class NetworkDelayTime2 {

    public static void main(String[] args) {
        int[][] times = {{2,1,1}, {2,3,1}, {3,4,1}};
        int n = 4;
        int k = 2;

        NetworkDelayTime2 networkDelayTime2 = new NetworkDelayTime2();
        int result = networkDelayTime2.networkDelayTime(times, n, k);
        System.out.println(result);
    }

    // O(E * log(V)) time | O(V + E) space
    public int networkDelayTime(int[][] times, int n, int k) {

        int[] cost = new int[n + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);

        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] time : times) {
            int s = time[0];
            int d = time[1];
            int w = time[2];
            adj.get(s).add(new int[] {d, w});
        }

        cost[k] = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        queue.add(new int[] {k, 0});
        Set<Integer> visited = new HashSet<>();
        int max = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int n1 = curr[0];
            int w1 = curr[1];
            if (visited.contains(n1)) {
                continue;
            }
            visited.add(n1);
            max = Math.max(max, w1);

            List<int[]> neighbors = adj.get(n1);
            for (int[] nei : neighbors) {
                int n2 = nei[0];
                int w2 = nei[1];
                if (w2 + w1 < cost[n2]) {
                    cost[n2] = w1 + w2;
                    queue.add(new int[] {n2, w1 + w2});
                }
            }
        }

        return visited.size() == n ? max : -1;
    }

}
