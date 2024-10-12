package whiteboard;

import java.util.HashMap;
import java.util.Map;

public class LineThroughPoints {

    public static void main(String[] args) {
        int[][] points = {{1, 1}, {2, 2}, {3, 3}, {0, 4}, {-2, 6}, {4, 0}, {2, 1}};

        LineThroughPoints lineThroughPoints = new LineThroughPoints();
        lineThroughPoints.lineThroughPoints(points);
    }

    // O(n^2) time | O(n) space
    public int lineThroughPoints(int[][] points) {
        // Write your code here.
        if (points.length <= 2) {
            return points.length;
        }
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            int[] currentPoint = points[i];
            int currentMax = 0;
            Map<String, Integer> slopesCount = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int[] otherPoint = points[j];
                int rise = otherPoint[1] - currentPoint[1];
                int run = otherPoint[0] - currentPoint[0];
                double slope = (rise * 1.0) / run;
                String key = String.valueOf(slope);
                if (slopesCount.containsKey(key)) {
                    slopesCount.put(key, slopesCount.get(key) + 1);
                } else {
                    slopesCount.put(key, 1);
                }
                currentMax = Math.max(currentMax, slopesCount.get(key));
            }
            max = Math.max(max, currentMax + 1);
        }
        return max;
    }

}
