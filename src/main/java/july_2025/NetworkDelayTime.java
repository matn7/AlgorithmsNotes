package july_2025;

import java.util.*;

public class NetworkDelayTime {

    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4;
        int k = 2;

        NetworkDelayTime networkDelayTime = new NetworkDelayTime();
        int result = networkDelayTime.networkDelayTime(times, n, k);
        System.out.println(result);
    }

    // O(E * log(V)) time | O(V + E) space
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
        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.add(new int[] {k, 0});
        distances[k] = 0;
        Set<Integer> seen = new HashSet<>();
        int count = n;
        int delayTime = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int s1 = current[0];
            int w1 = current[1];

            if (seen.contains(s1)) {
                continue;
            }
            seen.add(s1);
            count--;
            delayTime = Math.max(delayTime, w1);
            List<int[]> neighbors = adj.get(s1);
            for (int[] nei : neighbors) {
                int d2 = nei[0];
                int w2 = nei[1];
                if (w1 + w2 < distances[d2]) {
                    distances[d2] = w1 + w2;
                    queue.add(new int[] {d2, w1 + w2});
                }
            }
        }
        return count == 0 ? delayTime : -1;
    }

}
