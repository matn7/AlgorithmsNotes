package december_2025;

import java.util.HashMap;
import java.util.Map;

public class MaximumCollinearPoints {

    // O(n^2 log(m)) time | O(n) space
    public int maxPoints(int[][] points) {
        int res = 0;
        // Treat each point as a focal point, and determine the maximum number of points
        // that are collinear with each focal point. The largest of these maximums is the
        // answer.
        for (int i = 0; i < points.length; i++) {
            res = Math.max(res, max_points_from_focal_point(i, points));
        }
        return res;
    }

    public int max_points_from_focal_point(int focalPointIndex, int[][] points) {
        Map<String, Integer> slopesMap = new HashMap<>();
        int maxPoints = 0;
        // For the current focal point, calculate the slope between it and every other
        // point. This allows us to group points that share the same slope.
        for (int j = 0; j < points.length; j++) {
            if (j != focalPointIndex) {
                String currSlope = get_slope(points[focalPointIndex], points[j]);
                slopesMap.put(currSlope, slopesMap.getOrDefault(currSlope, 0) + 1);
                // Update the maximum count of collinear points for the current focal
                // point.
                maxPoints = Math.max(maxPoints, slopesMap.get(currSlope));
            }
        }
        // Add 1 to the maximum count to include the focal point itself.
        return maxPoints + 1;
    }

    public String get_slope(int[] p1, int[] p2) {
        int rise = p2[1] - p1[1];
        int run = p2[0] - p1[0];
        // Handle vertical lines separately to avoid dividing by 0.
        if (run == 0) {
            return "1/0";
        }
        // Simplify the slope to its reduced form.
        int gcdVal = gcd(rise, run);
        return (rise / gcdVal) + "/" + (run / gcdVal);
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        }
        return gcd(b, a % b);
    }

}
