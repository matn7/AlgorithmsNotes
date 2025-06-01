package may_2025;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosest {

    public static void main(String[] args) {
        int[][] points = {{3,3}, {5,-1}, {-2,4}};
        int k = 2;
        KClosest kClosest = new KClosest();
        int[][] ints = kClosest.kClosest(points, k);
        System.out.println(ints);
    }

    // O(k*log(n)) time | O(k) space
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                Comparator.comparingInt(a -> (a[0] * a[0] + a[1] * a[1]))
        );

        for (int[] point : points) {
            queue.add(point);
        }

        int min = Math.min(k, queue.size());
        int[][] res = new int[min][2];
        int idx = 0;
        while (min > 0) {
            int[] poll = queue.poll();
            res[idx] = poll;
            idx++;
            min--;
        }
        return res;
    }

}
