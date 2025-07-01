package june_2025;

import java.util.PriorityQueue;

public class KthClosest {

    public static void main(String[] args) {
        int[][] points = {{3,3}, {5,-1}, {-2, 4}};
        int k = 2;
        KthClosest kthClosest = new KthClosest();
        int[][] ints = kthClosest.kClosest(points, k);
        System.out.println(ints);
    }

    // O(n log(k)) time | O(n) space
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]);
        });

        for (int[] point : points) {
            queue.add(point);
        }

        int[][] res = new int[k][2];

        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

}
