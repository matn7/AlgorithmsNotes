package august_2025;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosest {

    public static void main(String[] args) {
        int[][] points = {{1, 3}, {-2, 2}};
        int k = 1;
        KClosest kClosest = new KClosest();
        int[][] result = kClosest.kClosest(points, k);
        System.out.println(result);
    }

    // O(k * log(n)) time | O(k) space
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> queue = new PriorityQueue<>(
                Comparator.comparingInt(a -> (a[0] * a[0] + a[1] * a[1])));

        for (int[] point : points) {
            queue.add(point);
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] current = queue.poll();
            result[i] = current;
        }
        return result;
    }

}
