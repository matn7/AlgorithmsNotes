package veryhard;

import java.util.HashMap;
import java.util.Map;

public class LineThroughPointsREPEAT {

    public static void main(String[] args) {
        int[][] points = {{1,1}, {2,2}, {3,3}, {0,4}, {-2,6}, {4,0}, {2,1}};
        LineThroughPointsREPEAT lineThroughPointsREPEAT = new LineThroughPointsREPEAT();
        lineThroughPointsREPEAT.lineThroughPoints(points);
    }

    //    P1     P2     P3     P4      P5     P6     P7
    // [[1,1], [2,2], [3,3], [0,4], [-2,6], [4,0], [2,1]]
    //
    //         *        *
    //         |
    //         +     *
    //         |
    //         +  *
    //         |
    // --+--+--+--+--+--+--+--+--+
    //         |
    //         +
    //         |
    //         +

    // OK - repeated 27/02/2022
    // O(n^2) time | O(n) space
    public int lineThroughPoints(int[][] points) {
        // Write your code here.
        int maxNumberOfPointsOnLine = 1;

        //                                       idx2
        // [[1,1], [2,2], [3,3], [0,4], [-2,6], [4,0], [2,1]]
        //   idx1
        for (int idx1 = 0; idx1 < points.length; idx1++) {
            int[] p1 = points[idx1]; // [1,1]
            Map<String, Integer> slopes = new HashMap<>();
            // slopes = {"1:1": 2, "2:2": 2, "-3:1": 2, "-5:3": 2}
            for (int idx2 = idx1 + 1; idx2 < points.length; idx2++) {
                int[] p2 = points[idx2]; // [-2,6]
                // rec([1,1], [-2,6])
                SlopeInfo slopeInfo = getSlopeOfLineBetweenPoints(p1, p2);
                // slopeInfo = [-5,3]
                String slopeKey = createHashableKeyForRational(slopeInfo.rise, slopeInfo.run);
                // slopeKey = "-3:1"
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

    private String createHashableKeyForRational(int numerator, int denominator) {

        return numerator + ":" + denominator;

    }

    // rec([1,1], [-2,6])
    private SlopeInfo getSlopeOfLineBetweenPoints(int[] p1, int[] p2) {
        int p1x = p1[0]; // 1
        int p1y = p1[1]; // 1
        int p2x = p2[0]; // -2
        int p2y = p2[1]; // 6

        int[] slope = {1, 0};

        if (p1x != p2x) {
            int xDiff = p1x - p2x; // 3
            int yDiff = p1y - p2y; // -5
            int gcd = getGreatestCommonDivisor(Math.abs(xDiff), Math.abs(yDiff)); // rec(1,3)
            xDiff = xDiff / gcd;
            yDiff = yDiff / gcd;
            if (xDiff < 0) {
                xDiff *= -1;
                yDiff *= -1;
            }
            slope[0] = yDiff;
            slope[1] = xDiff;
            System.out.println();
        }

        return new SlopeInfo(slope[0], slope[1]);
    }

    // rec(1,3)
    private int getGreatestCommonDivisor(int num1, int num2) {
        int a = num1; // 1
        int b = num2; // 3
        while (true) {
            if (a == 0) {
                return b;
            }
            if (b == 0) {
                return a;
            }
            int temp = a; // 3
            a = b; // 3
            b = temp % b; // 3 % 3 = 0
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
