package october_2025;

import java.util.*;

public class NetworkTimeDelay {

    public static void main(String[] args) {
//        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
//        int n = 4;
//        int k = 2;

        int[][] times = {{1,2,1}};
        int n = 2;
        int k = 2;

        NetworkTimeDelay networkTimeDelay = new NetworkTimeDelay();
        int result = networkTimeDelay.networkDelayTime(times, n, k);
        System.out.println(result);
    }

    // O(e * log(v)) time | O(v + e) space
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

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]); // [node, cost]
        minHeap.add(new int[] {k, 0});
        int time = 0;
        Set<Integer> visited = new HashSet<>();

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int node = current[0];
            int cost = current[1];
            if (visited.contains(node)) {
                continue;
            }
            visited.add(node);
            time = Math.max(time, cost);
            List<int[]> neighbors = adj.get(node);
            for (int[] nei : neighbors) {
                int neiNode = nei[0];
                int neiCost = nei[1];
                if (visited.contains(neiNode)) {
                    continue;
                }
                minHeap.add(new int[] {neiNode, neiCost + cost});
            }
        }

        return visited.size() == n ? time : -1;
    }


}
