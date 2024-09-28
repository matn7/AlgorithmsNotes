package june_2024;

import java.util.Arrays;

public class BellmanFord2 {

    public static void main(String[] args) {
        int n = 5;
        int k = 1;
        int[][] times = {
                {1, 2, 9},
                {1, 4, 2},
                {2, 5, -3},
                {4, 2, -4},
                {4, 5, 6},
                {3, 2, 3},
                {5, 3, 7},
                {3, 1, 5}
        };

    }

    // O(n*e) time | O(n) space
    public static int networkDelay(int[][] times, int n, int k) {
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[k - 1] = 0;
        for (int i = 0; i < times.length; i++) {
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
        int maxDistance = Integer.MIN_VALUE;
        for (int distance : distances) {
            maxDistance = Math.max(maxDistance, distance);
        }
        return maxDistance == Integer.MIN_VALUE ? -1 : maxDistance;
    }

}
