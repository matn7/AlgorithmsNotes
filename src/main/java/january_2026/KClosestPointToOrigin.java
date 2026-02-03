package january_2026;

import java.util.PriorityQueue;

public class KClosestPointToOrigin {

    public static void main(String[] args) {
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int k = 2;

        KClosestPointToOrigin kClosestPointToOrigin = new KClosestPointToOrigin();
        int[][] result = kClosestPointToOrigin.kClosest(points, k);
        System.out.println(result);
    }

    // O(nlog(k)) time | O(k) space
    public int[][] kClosest(int[][] points, int k) {
//        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[2] - a[2]);

        for (int[] point : points) {
            int distance = (point[0] * point[0] + point[1] * point[1]);
            if (maxHeap.size() < k) {
                maxHeap.add(new int[] {point[0], point[1], distance});
            } else {
                int[] peek = maxHeap.peek();
                if (peek[2] > distance) {
                    maxHeap.poll();
                    maxHeap.add(new int[] {point[0], point[1], distance});
                }
            }
        }

        int size = maxHeap.size();
        int min = Math.min(k, size);
        int[][] result = new int[min][2];

        int idx = min - 1;
        for (int i = 0; i < min; i++) {
            int[] current = maxHeap.poll();
            result[idx] = new int[] {current[0], current[1]};
            idx--;
        }
        return result;
    }



}
