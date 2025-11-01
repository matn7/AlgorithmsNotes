package october_2025;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int k = 2;

        KClosestPointsToOrigin kClosestPointsToOrigin = new KClosestPointsToOrigin();
        int[][] result = kClosestPointsToOrigin.kClosest(points, k);
        System.out.println(result);
    }

    // O(k * log(n)) time | O(n) space
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> (a[0] * a[0] + a[1] * a[1])));

        for (int[] point : points) {
            minHeap.add(point);
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }
        return result;
    }

}
