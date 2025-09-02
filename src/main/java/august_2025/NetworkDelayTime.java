package august_2025;

import java.util.*;

public class NetworkDelayTime {

    public static void main(String[] args) {
//        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
//        int n = 4;
//        int k = 2;

        int[][] times = {{1,2,1},{2,3,2},{1,3,2}};
        int n = 3;
        int k = 1;

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

        int maxTime = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.add(new int[] {k, 0});
        Set<Integer> visited = new HashSet<>();

        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[k] = 0;

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int currNode = current[0];
            int w = current[1];
            if (visited.contains(currNode)) {
                continue;
            }
            visited.add(currNode);

            maxTime = Math.max(maxTime, w);
            List<int[]> neighbors = adj.get(currNode);
            for (int[] nei : neighbors) {
                int neiNode = nei[0];
                if (visited.contains(neiNode)) {
                    continue;
                }
                int neiWeight = nei[1];
                if (w + neiWeight < distances[neiNode]) {
                    distances[neiNode] = w + neiWeight;
                    minHeap.add(new int[] {neiNode, w + neiWeight});
                }
            }
        }
        return visited.size() == n ? maxTime : -1;
    }


}
