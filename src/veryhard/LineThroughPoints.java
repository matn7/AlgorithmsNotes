package veryhard;

import java.util.HashMap;
import java.util.Map;

public class LineThroughPoints {

    public static void main(String[] args) {
        int[][] points = {{1, 1}, {2, 2}, {3, 3}, {0, 4}, {-2, 6}, {4, 0}, {2, 1}};

        LineThroughPoints lineThroughPoints = new LineThroughPoints();
        int result = lineThroughPoints.lineThroughPoints(points);

        System.out.println(result);
    }

    // O(n^2) time | O(n) space
    public int lineThroughPoints(int[][] points) {
        // Write your code here.
        int maxNumberOfPointsOnLine = 1;

        for (int idx1 = 0; idx1 < points.length; idx1++) {
            Map<String, Integer> slopes = new HashMap<>();
            int[] p1 = points[idx1];
            for (int idx2 = idx1 + 1; idx2 < points.length; idx2++) {
                int[] p2 = points[idx2];
                SlopeInfo slopeInfo = getSlopeOfLineBetweenPoints(p1, p2);
                String slopeKey = createHashableKeyForRational(slopeInfo);
                if (!slopes.containsKey(slopeKey)) {
                    slopes.put(slopeKey, 1);
                }
                Integer elems = slopes.get(slopeKey);
                slopes.remove(slopeKey);
                slopes.put(slopeKey, elems + 1);
            }
            int currentSlopeMax = -99999;
            if (slopes.isEmpty()) {
                currentSlopeMax = 0;
            } else {
                for (Map.Entry<String, Integer> element : slopes.entrySet()) {
                    if (element.getValue() > currentSlopeMax) {
                        currentSlopeMax = element.getValue();
                    }
                }
            }
            maxNumberOfPointsOnLine = Math.max(maxNumberOfPointsOnLine, currentSlopeMax);
        }

        return maxNumberOfPointsOnLine;
    }

    private String createHashableKeyForRational(SlopeInfo slopeInfo) {
        return slopeInfo.rise + ":" + slopeInfo.run;
    }

    private SlopeInfo getSlopeOfLineBetweenPoints(int[] p1, int[] p2) {
        int p1x = p1[0];
        int p1y = p1[1];
        int p2x = p2[0];
        int p2y = p2[1];

        int[] slope = {1, 0};

        if (p1x != p2x) {
            int xDiff = p1x - p2x;
            int yDiff = p1y - p2y;
            int gcd = getGreatestCommonDivisor(Math.abs(xDiff), Math.abs(yDiff));
            xDiff = xDiff / gcd;
            yDiff = yDiff / gcd;
            if (xDiff < 0) {
                xDiff *= -1;
                yDiff *= -1;
            }
            slope[0] = yDiff;
            slope[1] = xDiff;
        }

        return new SlopeInfo(slope[0], slope[1]);
    }
//
//    private int getGreatestCommonDivisor(int num1, int num2) {
//        if (num2 == 0) {
//            return num1;
//        }
//        return getGreatestCommonDivisor(num2, num1 % num2);
//    }

    private int getGreatestCommonDivisor(int num1, int num2) {
        int a = num1;
        int b = num2;

        while (true) {
            if (a == 0) {
                return b;
            }
            if (b == 0) {
                return a;
            }
            int temp = a;
            a = b;
            b = temp % b;
        }
    }

    static class SlopeInfo {
        int rise;
        int run;

        public SlopeInfo(int rise, int run) {
            this.rise = rise;
            this.run = run;
        }
    }

}
