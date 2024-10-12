package june_2024;

import java.util.Arrays;

public class BellmanFord {

    public static void main(String[] args) {
        int n = 5;
        int[][] times = {{1, 2, 9}, {1, 4, 2}, {2, 5, -3}, {4, 2, -4}, {4, 5, 6},
                {3, 2, 3}, {5, 3, 7}, {3, 1, 5}};

        int result = networkDelayTime(times, n, 1);
        System.out.println(result);
    }

    // ********
    // * STAR - G *
    // ********

    // O(n * e) time | O(n) space
    public static int networkDelayTime(int[][] times, int n, int k) {
        int[] distances = new int[n];
        Arrays.fill(distances, 9999);
        distances[k - 1] = 0;
        for (int i = 0; i < n - 1; i++) {
            int count = 0;
            for (int[] time : times) {
                int source = time[0];
                int target = time[1];
                int weight = time[2];
                if (distances[source - 1] + weight < distances[target - 1]) {
                    distances[target - 1] = distances[source - 1] + weight;
                    count++;
                }
            }
            if (count == 0) {
                break;
            }
        }
        int maxDistance = Integer.MIN_VALUE;
        for (int distance : distances) {
            maxDistance = Math.max(maxDistance, distance);
        }
        return maxDistance == Integer.MIN_VALUE ? -1 : maxDistance;
    }


}
