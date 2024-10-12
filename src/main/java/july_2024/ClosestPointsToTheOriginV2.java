package july_2024;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ClosestPointsToTheOriginV2 {

    public static void main(String[] args) {
        int[][] points = {{1,1}, {3,3}, {2,2}, {4,4}, {-1,-1}};
        int k = 3;

        List<int[]> closestPoints = findClosestPoints(points, k);
        System.out.println(closestPoints);
    }

    // O(nlog(n)) + klog(n)) time | O(n) space
    public static List<int[]> findClosestPoints(int[][] points, int k) {
        PriorityQueue<Point> queue = new PriorityQueue<>();
        for (int[] p : points) {
            queue.add(new Point(p));
        }
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(queue.poll().point);
        }
        return result;
    }

    static class Point implements Comparable<Point> {
        int[] point;

        public Point(int[] point) {
            this.point = point;
        }

        @Override
        public int compareTo(Point o) {
            return (this.point[0] * this.point[0] + this.point[1] * this.point[1]) -
                    (o.point[0] * o.point[0] + o.point[1] * o.point[1]);
        }
    }

}
