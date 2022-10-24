package udemy.faang;

import java.util.Arrays;

public class NetworkTimeDelayBellmanFord {

    public static void main(String[] args) {
        int[][] times = {{1,4,2}, {1,2,9}, {4,2,-4}, {2,5,-3}, {4,5,6}, {5,3,7}, {3,2,3}, {3,1,5}};
//        int[][] times = {{1,2,9}, {1,4,2}, {2,5,1}, {4,2,4}, {4,5,6}, {3,2,3}, {3,1,5}};
        int n = 5;
        int k = 1;

        NetworkTimeDelayBellmanFord networkTimeDelay = new NetworkTimeDelayBellmanFord();
        networkTimeDelay.networkDelayTime(times, n, k);
    }

    // Bellman Ford does not work with negative cycles

    // O(n*e) time | O(n) space
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[k - 1] = 0;

        for (int i = 0; i < n - 1; i++) {
            int count = 0;
            for (int j = 0; j < times.length; j++) {
                int source = times[j][0];
                int target = times[j][1];
                int weight = times[j][2];

                if (distances[source - 1] + weight < distances[target - 1]) {
                    distances[target - 1] = distances[source - 1] + weight;
                    count++;
                }
            }
            if (count == 0) {
                break;
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
