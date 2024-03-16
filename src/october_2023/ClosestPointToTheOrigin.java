package october_2023;

import com.sun.source.tree.BreakTree;

import java.util.*;

public class ClosestPointToTheOrigin {

    public static void main(String[] args) {
        int[][] points = {{1, 1}, {3, 3}, {2, 2}, {4, 4}, {-1, -1}};
        List<int[]> result = new ClosestPointToTheOrigin().closestPoints(points, 3);
        System.out.println(result);
    }

    // O(nlog(n)) time | O(nlog(n)) space
    public List<int[]> closestPoints(int[][] points, int k) {
        Arrays.sort(points, Comparator.comparingInt(this::calcDistance));
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            result.add(points[i]);
        }

        return result;
    }

    private int calcDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }


    // O(klog(n)) time | O(k) space
    public static List<int[]> closestPointsPQ(int[][] points, int k) {
        if (k < 0 || k > points.length) {
            return null;
        }
        PriorityQueue<Point> queue = new PriorityQueue<>();

        for (int[] point : points) {
            queue.add(new Point(point));
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
            return (point[0] * point[0] + point[1] * point[1]) - (o.point[0] * o.point[0] + o.point[1] * o.point[1]);
        }
    }

}
