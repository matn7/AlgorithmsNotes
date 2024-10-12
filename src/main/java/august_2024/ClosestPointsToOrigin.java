package august_2024;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ClosestPointsToOrigin {

    public static void main(String[] args) {
        int[][] points = {{1, 1}, {3, 3}, {2, 2}, {4, 4}, {-1, -1}};

        List<int[]> ints = closestPoints(points, 3);

        System.out.println(ints);
    }

    // Onlog(k)) time | O(n) space
    public static List<int[]> closestPoints(int[][] points, int k) {
        List<int[]> result = new ArrayList<>();
        if (k > points.length) {
            return result;
        }
        PriorityQueue<Point> queue = new PriorityQueue<>();

        for (int[] point : points) {
            queue.add(new Point(point[0], point[1]));
        }

        while (k > 0) {
            Point poll = queue.poll();
            result.add(new int[] {poll.x, poll.y});
            k--;
        }

        return result;
    }

    static class Point implements Comparable<Point> {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return (this.x * this.x + this.y * this.y) - (o.x * o.x + o.y * o.y);
        }
    }
}
