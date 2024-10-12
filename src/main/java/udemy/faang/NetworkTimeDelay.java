package udemy.faang;

import java.util.*;

public class NetworkTimeDelay {

    public static void main(String[] args) {
        int[][] times = {{1,2,9}, {1,4,2}, {2,5,1}, {4,2,4}, {4,5,6}, {3,2,3}, {3,1,5}, {5,3,7}};
//        int[][] times = {{1,2,9}, {1,4,2}, {2,5,1}, {4,2,4}, {4,5,6}, {3,2,3}, {3,1,5}};
        int n = 5;
        int k = 1;

        NetworkTimeDelay networkTimeDelay = new NetworkTimeDelay();
        networkTimeDelay.networkDelayTime(times, n, k);
    }

    // [2N + E + elog(n)) + nlog(n)] -> O(e * log(n)) time | O(e + n) space - e edges and n nodes (vertex)
    // we can assume they will be much more edges than nodes in our graph
    // O(n + elog(e)) time
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        Map<Integer, List<Integer[]>> adjList = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            adjList.put(i, new ArrayList<>());
        }
        distances[k - 1] = 0;
        // it has to be PQ that does not allow duplicate values
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(k);
        for (int i = 0; i < times.length; i++) {    // E
            int[] currentTime = times[i];
            int source = currentTime[0];
            int target = currentTime[1];
            int weight = currentTime[2];
            adjList.get(source).add(new Integer[] {target, weight});
        }
        while (!heap.isEmpty()) {
            Integer currentVertex = heap.poll();    // e * log(n)
            List<Integer[]> adjacent = adjList.get(currentVertex);
            for (int i = 0; i < adjacent.size(); i++) { // n * log(n) for n nodes perform PQ poll, add
                Integer neighboringVertex = adjacent.get(i)[0];
                Integer weight = adjacent.get(i)[1];
                if (distances[currentVertex - 1] + weight < distances[neighboringVertex - 1]) {
                    distances[neighboringVertex - 1] = distances[currentVertex - 1] + weight;
                    heap.add(neighboringVertex);
                }
            }
        }
        int max = 0;
        for (int dist : distances) {
            if (dist > max) {
                max = dist;
            }
        }
        return max == Integer.MIN_VALUE ? -1 : max;

    }

}
