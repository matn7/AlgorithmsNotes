package december_2024;

import java.util.*;

public class NetworkTimeDelay2 {

    public static void main(String[] args) {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4;
        int k = 2;

        NetworkTimeDelay2 networkTimeDelay = new NetworkTimeDelay2();
        int result = networkTimeDelay.networkDelayTime(times, n, k);
        System.out.println(result);
    }

    // O(E log(V)) time | O(V + E) space
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>(); // id : [dest, w]
        for (int i = 1; i <= n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] time : times) {
            int s = time[0];
            int d = time[1];
            int w = time[2];
            adj.get(s).add(new int[] {d, w});
        }

        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = 0;
        distances[k] = 0;
        queue.add(new int[] {k, 0});

        int max = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int weight = current[1];
            if (visited.contains(node)) {
                continue;
            }
            visited.add(node);
            max = Math.max(max, weight);

            List<int[]> neighbors = adj.get(node);
            for (int[] neighbor : neighbors) {
                int neiDest = neighbor[0];
                int neiWeight = neighbor[1];
                if (weight + neiWeight < distances[neiDest]) {
                    distances[neiDest] = weight + neiWeight;
                    if (!visited.contains(neiDest)) {
                        queue.add(new int[] {neiDest, weight + neiWeight});
                    }
                }
            }
        }
        return visited.size() < n ? -1 : max;
    }

}
