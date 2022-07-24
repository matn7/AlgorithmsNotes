package whiteboard;

import java.util.HashMap;
import java.util.Map;

public class MinimumAreaRectangle2 {

    // O(n^2) time | O(n) space
    public int minimumAreaRectangle(int[][] points) {
        // Write your code here.
        int minArea = Integer.MAX_VALUE;
        Map<String, Boolean> pointsMap = createPointsMap(points);

        for (int i = 0; i < points.length; i++) {
            int[] currentPoint = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int[] pointToCheck = points[j];
                if (currentPoint[0] == pointToCheck[0] ||  currentPoint[1] == pointToCheck[1]) {
                    continue;
                }

                int[] m1 = {currentPoint[0], pointToCheck[1]};
                int[] m2 = {pointToCheck[0], currentPoint[1]};

                String m1Key = createKey(m1);
                String m2Key = createKey(m2);

                if (pointsMap.containsKey(m1Key) && pointsMap.containsKey(m2Key)) {
                    int height = currentPoint[1] > m1[1] ?
                            Math.abs(currentPoint[1] - m1[1]) : Math.abs(m1[1] - currentPoint[1]);
                    int wight = pointToCheck[0] > m1[0] ?
                            Math.abs(pointToCheck[0] - m1[0]) : Math.abs(m1[0] - pointToCheck[0]);
                    int area = height * wight;
                    if (area < minArea) {
                        minArea = area;
                    }
                }
            }
        }

        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }
    private Map<String, Boolean> createPointsMap(int[][] points) {
        Map<String, Boolean> pointsMap = new HashMap<>();

        for (int[] point : points) {
            String key = createKey(point);
            pointsMap.put(key, Boolean.TRUE);
        }

        return pointsMap;
    }

    private String createKey(int[] point) {
        return point[0] + "-" + point[1];
    }


}
