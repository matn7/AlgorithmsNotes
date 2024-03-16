package january_2024;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ClosestPointsToTheOrigin {

    public static void main(String[] args) {
        int[][] points = {{1, 1}, {3, 3}, {2, 2}, {4, 4}, {-1, -1}};
        int[][] result = findClosestPoints(points, 3);
        System.out.println(result);
        int[][] result2 = findClosestPoints2(points, 3);
        System.out.println(result2);
    }

    // O(nlog(n)) time | O(n) space
    public static int[][] findClosestPoints(int[][] points, int k) {
        if (k > points.length) {
            return null;
        }
        Arrays.sort(points, Comparator.comparingInt(p -> (p[0] * p[0] + p[1] * p[1])));

        int[][] result = new int[k][2];
        int counter = 0;

        for (int i = 0; i < k; i++) {
            result[counter] = points[i];
            counter++;
        }

        return result;
    }

    // O(klog(n)) time | O(n) space
    public static int[][] findClosestPoints2(int[][] points, int k) {
        if (k > points.length) {
            return null;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(p -> (p[0] * p[0] + p[1] * p[1])));
        queue.addAll(Arrays.asList(points));
        int[][] result = new int[k][2];
        int counter = 0;
        while (counter < k) {
            int[] point = queue.poll();
            result[counter] = point;
            counter++;
        }
        return result;
    }


}
