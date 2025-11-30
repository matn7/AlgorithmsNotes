package november_2025;

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

        for (int i = 1; i <= n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] time : times) {
            int s = time[0];
            int d = time[1];
            int w = time[2];
            adj.get(s).add(new int[] {d, w});
        }

        int delay = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]); // [node, delay]
        minHeap.add(new int[] {k, 0});
        Set<Integer> visited = new HashSet<>();

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int n1 = current[0];
            int w1 = current[1];
            if (visited.contains(n1)) {
                continue;
            }
            visited.add(n1);
            delay = Math.max(delay, w1);
            List<int[]> neighbors = adj.get(n1);
            for (int[] nei : neighbors) {
                int n2 = nei[0];
                int w2 = nei[1];
                if (visited.contains(n2)) {
                    continue;
                }
                minHeap.add(new int[] {n2, w1 + w2});
            }
        }

        return visited.size() == n ? delay : -1;
    }

}
