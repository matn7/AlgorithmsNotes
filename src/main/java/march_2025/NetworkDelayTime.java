package march_2025;

import java.util.*;

public class NetworkDelayTime {

    public static void main(String[] args) {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4;
        int k = 2;

        NetworkDelayTime networkDelayTime = new NetworkDelayTime();
        int result = networkDelayTime.networkDelayTime(times, n, k);
        System.out.println(result);
    }

    // O(E * log(V) time | O(E + V) space
    public int networkDelayTime(int[][] times, int n, int k) {
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
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        minHeap.add(new int[] {k, 0});
        int max = 0;
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int n1 = current[0];
            int w1 = current[1];
            if (dist[n1] != -1) {
                continue;
            }
            dist[n1] = w1;
            max = Math.max(max, w1);
            List<int[]> neighbors = adj.get(n1);
            for (int[] neighbor : neighbors) {
                int n2 = neighbor[0];
                int w2 = neighbor[1];
                minHeap.add(new int[] {n2, w1 + w2});
            }
        }
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == -1) {
                return dist[i];
            }
        }
        return max;
    }

}
