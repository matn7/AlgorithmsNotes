package coderpro;

import java.util.*;

public class ClosestPointsToTheOrigin {

    public static void main(String[] args) {
        int[][] points = {{1, 1}, {3, 3}, {2, 2}, {4, 4}, {-1, -1}};
        ClosestPointsToTheOrigin closestPointsToTheOrigin = new ClosestPointsToTheOrigin();
        List<int[]> result = closestPointsToTheOrigin.findClosestPoints(points, 3);
        System.out.println();
    }

    // O(klog(n)) time | O(n) space
    public List<int[]> findClosestPoints(int[][] points, int k) {
        PriorityQueue<Point> queue = new PriorityQueue<>();
        for (int[] p : points) {
            System.out.println(p[0] + ":" + p[1] + " ---> " + calcDistance(p));
            queue.add(new Point(p));
        }
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(queue.poll().point);
        }
        return result;
    }


    // O(nlog(n)) time | O(nlog(n)) space
    public List<int[]> findClosestPoints2(int[][] points, int k) {
        Arrays.sort(points, Comparator.comparing(this::calcDistance));
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(points[i]);
        }
        return result;
    }

    private int calcDistance(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }
}

class Point implements Comparable<Point> {
    int[] point;

    public Point(int[] point) {
        this.point = point;
    }

    @Override
    public int compareTo(Point o) {
        return (this.point[0] * this.point[0] + this.point[1] * this.point[1]) - (o.point[0] * o.point[0] + o.point[1] * o.point[1]);
    }
}
