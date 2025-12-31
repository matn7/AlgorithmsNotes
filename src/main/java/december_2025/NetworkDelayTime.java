package december_2025;

import java.util.*;

public class NetworkDelayTime {

    public static void main(String[] args) {
        /*
        Input: n = 6,
       edges = [
         [0, 1, 5],
         [0, 2, 3],
         [1, 2, 1],
         [1, 3, 4],
         [2, 3, 4],
         [2, 4, 5],
       ],
       start = 0
Output: [0, 4, 3, 7, 8, -1]
         */
//        int n = 6;
//        int start = 0;
//        int[][] edges = {{0, 1, 5}, {0, 2, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 4}, {2, 4, 5}};
        NetworkDelayTime networkDelayTime = new NetworkDelayTime();
//        int[] output = networkDelayTime.shortestPath(edges, n, start);
//        System.out.println();

//        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
//        int n = 4;
//        int k = 2;

        int[][] times = {{1,2,1}};
        int n = 2;
        int k = 2;
        int result = networkDelayTime.networkDelayTime(times, n, k);
        System.out.println(result);
    }

    // O((n + e) * log(n)) time | O(n + e) space
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
//            adj.get(d).add(new int[] {s, w});
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.add(new int[] {k, 0}); // [node, weight]
        Set<Integer> visited = new HashSet<>();
        int delay = 0;
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int node = current[0];
            int cost = current[1];
            if (visited.contains(node)) {
                continue;
            }
            visited.add(node);
            delay = Math.max(delay, cost);
            List<int[]> neighbors = adj.get(node);
            for (int[] nei : neighbors) {
                int n2 = nei[0];
                if (visited.contains(n2)) {
                    continue;
                }
                int c2 = nei[1];
                int newCost = cost + c2;
                minHeap.add(new int[] {n2, newCost});
            }
        }
        return visited.size() == n ? delay : -1;
    }

    public int[] shortestPath(int[][] edges, int n, int start) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] time : edges) {
            int s = time[0];
            int d = time[1];
            int w = time[2];
            adj.get(s).add(new int[] {d, w});
            adj.get(d).add(new int[] {s, w});
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] output = new int[n];
        Arrays.fill(output, Integer.MAX_VALUE);
        output[start] = 0;
        minHeap.add(new int[] {0, 0}); // [node, weight]
        Set<Integer> visited = new HashSet<>();

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int node = current[0];
            int cost = current[1];
            if (visited.contains(node)) {
                continue;
            }
            visited.add(node);
            List<int[]> neighbors = adj.get(node);
            for (int[] nei : neighbors) {
                int n2 = nei[0];
                int c2 = nei[1];
                int newCost = cost + c2;
                if (newCost < output[n2]) {
                    // new cost is smaller than current one
                    output[n2] = newCost;
                    minHeap.add(new int[] {n2, newCost});
                }
            }
        }
        for (int i = 0; i < output.length; i++) {
            if (output[i] == Integer.MAX_VALUE) {
                output[i] = -1;
            }
        }
        return output;
    }



}
