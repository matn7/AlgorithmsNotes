package december_2024;

import java.util.PriorityQueue;

public class KClosestPoints {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> minHeap = new PriorityQueue<>();

        for (int[] point : points) {
            minHeap.add(new Point(point[0], point[1]));
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            Point current = minHeap.poll();
            res[i] = new int[] {current.x, current.y};
        }
        return res;
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
            return (x*x + y*y) - (o.x*o.x + o.y*o.y);
        }
    }

}
