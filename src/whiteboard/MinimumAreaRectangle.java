package whiteboard;

import java.util.HashMap;
import java.util.Map;

public class MinimumAreaRectangle {

    public static void main(String[] args) {
        int[][] points = {
                {1, 5},
                {5, 1},
                {4, 2},
                {2, 4},
                {2, 2},
                {1, 2},
                {4, 5},
                {2, 5},
                {-1, -2}
        };

        MinimumAreaRectangle minArea = new MinimumAreaRectangle();
        minArea.minimumAreaRectangle(points);
    }

    // O(n^2) time | O(n) space
    public int minimumAreaRectangle(int[][] points) {
        // Write your code here.
        int minArea = Integer.MAX_VALUE;

        Map<String, Point> pointsMap = createPointsMap(points);

        for (int i = 0; i < points.length; i++) {
            int[] current = points[i];
            int currentX = current[0];
            int currentY = current[1];
            for (int j = 0; j < points.length; j++) {
                int[] prev = points[j];
                int prevX = prev[0];
                int prevY = prev[1];
                if (currentX == prevX || currentY == prevY) {
                    continue;
                }
                String coordKey1 = currentX + "-" + prevY;
                String coordKey2 = prevX + "-" + currentY;

                if (pointsMap.containsKey(coordKey1) && pointsMap.containsKey(coordKey2)) {
                    Point point1 = pointsMap.get(coordKey1);
                    Point point2 = pointsMap.get(coordKey2);

                    int height = currentY < point1.y ? Math.abs(currentY - point1.y) : Math.abs(point1.y - currentY);
                    int width = currentX < point2.x ? Math.abs(currentX - point2.x) : Math.abs(point2.x - currentX);

                    minArea = Math.min(minArea, height * width);
                }
            }
        }

        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }

    private Map<String, Point> createPointsMap(int[][] points) {
        Map<String, Point> pointsMap = new HashMap<>();
        for (int[] point : points) {
            String key = point[0] + "-" + point[1];
            pointsMap.put(key, new Point(point[0], point[1]));
        }
        return pointsMap;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
