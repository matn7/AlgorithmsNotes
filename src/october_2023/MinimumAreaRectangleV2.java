package october_2023;

import java.util.HashMap;
import java.util.Map;

public class MinimumAreaRectangleV2 {

    public static void main(String[] args) {
        int[][] points = {{1,5}, {5,1}, {4,2}, {2,4}, {2,2}, {1,2}, {4,5}, {2,5}, {-1,-2}};
        minimumAreaRectangle(points);
    }

    // O(n^2) time | O(n) space
    public static int minimumAreaRectangle(int[][] points) {
        Map<String, Boolean> pointsMap = generatePointsMap(points);
        int minArea = Integer.MAX_VALUE;

        for (int i = 0; i < points.length; i++) {
            int[] point1 = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int[] point2 = points[j];
                if (point1[0] == point2[0] || point1[1] == point2[1]) {
                    continue;
                }
                String key3 = point2[0] + ":" + point1[1];
                String key4 = point1[0] + ":" + point2[1];
                if (pointsMap.containsKey(key3) && pointsMap.containsKey(key4)) {
                    int area = Math.abs(point1[1] - point2[1]) * Math.abs(point2[0] - point1[0]);
                    minArea = Math.min(minArea, area);
                }
            }
        }

        return minArea;
    }

    private static Map<String, Boolean> generatePointsMap(int[][] points) {
        Map<String, Boolean> pointsMap = new HashMap<>();
        for (int[] point : points) {
            pointsMap.put(point[0] + ":" + point[1], Boolean.TRUE);
        }
        return pointsMap;
    }

}
