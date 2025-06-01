package may_2025;

import java.util.*;

public class NetworkTimeDelay {

    public static void main(String[] args) {
        int[][] times = {{2,1,1}, {2,3,1}, {3,4,1}};
        int n = 4;
        int k = 2;

        NetworkTimeDelay networkTimeDelay = new NetworkTimeDelay();
        int result = networkTimeDelay.networkDelayTime(times, n, k);
        System.out.println(result);
    }

    // O(E * log(E)) time | O(E + V) space
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
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.add(new int[] {k, 0});
        Set<Integer> visit = new HashSet<>();

        int max = 0;
        while (!queue.isEmpty()) {
            int[] currNode = queue.poll();
            int n1 = currNode[0];
            int w1 = currNode[1];
            if (distance[n1] != -1) {
                continue;
            }
            visit.add(n1);
            distance[n1] = w1;
            max = Math.max(max, w1);
            List<int[]> neighbors = adj.get(n1);
            for (int[] neighbor : neighbors) {
                int n2 = neighbor[0];
                int w2 = neighbor[1];
                if (distance[n2] == -1) {
                    queue.add(new int[] {n2, w2 + w1});
                }
            }
        }
        return visit.size() == n ? max : -1;
    }

}
