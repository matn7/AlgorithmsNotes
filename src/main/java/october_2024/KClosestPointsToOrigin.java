package october_2024;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        // points = [[3,3],[5,-1],[-2,4]], k = 2
//        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
//        int k = 2;

        // [1,3],[-2,2]
        int[][] points = {{1,3}, {-2, 2}};
        int k = 1;

        KClosestPointsToOrigin closestPointsToOrigin = new KClosestPointsToOrigin();
        closestPointsToOrigin.kClosest(points, k);
    }

    // O(nlog(n)) + klog(n)) time | O(n) space
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Element> queue = new PriorityQueue<>();

        for (int[] point : points) {
            queue.add(new Element(point[0], point[1]));
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            Element poll = queue.poll();
            result[i] = new int[] {poll.x, poll.y};
        }
        return result;
    }

    static class Element implements Comparable<Element> {
        int x;
        int y;

        public Element(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Element o) {
            return (x * x + y * y) - (o.x * o.x + o.y * o.y);
        }
    }

}
