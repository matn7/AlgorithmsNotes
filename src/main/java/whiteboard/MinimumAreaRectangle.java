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
    // rand: 28/07/2022
    public int minimumAreaRectangle(int[][] points) {
        // Write your code here.
        Map<String, Boolean> pointsMap = generatePointsMap(points);

        int minArea = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int[] currPoint = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int[] otherPoint = points[j];
                String key1 = otherPoint[0] + "-" + currPoint[1];
                String key2 = currPoint[0] + "-" + otherPoint[1];
                if (currPoint[0] == otherPoint[0] || currPoint[1] == otherPoint[1]) {
                    continue;
                }

                if (pointsMap.containsKey(key1) && pointsMap.containsKey(key2)) {
                    int height = Math.abs(currPoint[1] - otherPoint[1]);
                    int width = Math.abs(otherPoint[0] - currPoint[0]);
                    int area = height * width;
                    if (area < minArea) {
                        minArea = area;
                    }
                }
            }
        }

        return minArea != Integer.MAX_VALUE ? minArea : 0;
    }

    private Map<String, Boolean> generatePointsMap(int[][] points) {
        Map<String, Boolean> pointsMap = new HashMap<>();
        for (int[] point : points) {
            String key = generateKey(point);
            pointsMap.put(key, Boolean.TRUE);
        }
        return pointsMap;
    }

    private String generateKey(int[] point) {
        return point[0] + "-" + point[1];
    }

}
