package january_2026;

import java.util.HashMap;
import java.util.Map;

public class MaxCollinearPoints {

    // O(n^2 log(m)) time | O(n) space
    public int maxPoints(int[][] points) {
        int res = 0;

        for (int i = 0; i < points.length; i++) {
            res = Math.max(res, maxPointsFromFocalPoint(i, points));
        }
        return res;
    }

    private int maxPointsFromFocalPoint(int focalPointIndex, int[][] points) {
        Map<String, Integer> slopesMap = new HashMap<>();
        int maxPoints = 0;
        for (int j = 0; j < points.length; j++) {
            if (j != focalPointIndex) {
                String currSlope = getSlope(points[focalPointIndex], points[j]);
                slopesMap.put(currSlope, slopesMap.getOrDefault(currSlope, 0) + 1);
                maxPoints = Math.max(maxPoints, slopesMap.get(currSlope));
            }
        }
        return maxPoints + 1;
    }

    private String getSlope(int[] p1, int[] p2) {
        int rise = p2[1] - p1[1];
        int run = p2[0] - p1[0];
        if (run == 0) {
            return "1/0";
        }
        int gcdVal = gcd(rise, run);
        return (rise / gcdVal) + "/" + (run / gcdVal);
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        }
        return gcd(b, a % b);
    }

}
