package july_2025;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int k = 2;

        KClosestPointsToOrigin kClosestPointsToOrigin = new KClosestPointsToOrigin();
        int[][] ints = kClosestPointsToOrigin.kClosest(points, k);
        System.out.println(ints);
    }

    // O(n log(n)) time | O(n) space
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            return (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]);
        });

        for (int[] point : points) {
            minHeap.add(point);
        }
        k = Math.min(k, minHeap.size());
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] poll = minHeap.poll();
            result[i] = poll;
        }
        return result;
    }

}
