package october_2023;

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

        MinimumAreaRectangle minimumAreaRectangle = new MinimumAreaRectangle();
        minimumAreaRectangle.minimumAreaRectangle(points);
    }

    // O(n^2) time | O(n) space
    public int minimumAreaRectangle(int[][] points) {
        // Write your code here.
        Map<String, Boolean> pointsMap = generatePointsMap(points);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int[] current = points[i]; // [1, 5]
            for (int j = i + 1; j < points.length; j++) {
                int[] other = points[j]; // [5, 1]
                if (current[0] == other[0] || current[1] == other[1]) {
                    continue;
                }
                int[] p3 = new int[] {other[0], current[1]};
                int[] p4 = new int[] {current[0], other[1]};
                String key3 = p3[0] + ":" + p3[1];
                String key4 = p4[0] + ":" + p4[1];
                if (pointsMap.containsKey(key3) && pointsMap.containsKey(key4)) {
                    int currentArea = Math.abs(current[1] - other[1]) * Math.abs(other[0] - current[0]);
                    min = Math.min(currentArea, min);
                }

            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private Map<String, Boolean> generatePointsMap(int[][] points) {
        Map<String, Boolean> pointsMap = new HashMap<>();
        for (int[] point : points) {
            String key = point[0] + ":" + point[1];
            pointsMap.put(key, Boolean.TRUE);
        }
        return pointsMap;
    }

}
