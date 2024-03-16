package september_2023;

import java.util.HashSet;
import java.util.Set;

public class CountSquares {

    public static void main(String[] args) {
        int[][] points = {
                {1, 1},
                {0, 0},
                {-4, 2},
                {-2, -1},
                {0, 1},
                {1, 0},
                {-1, 4}
        };

        CountSquares countSquares = new CountSquares();
        countSquares.countSquares(points);
    }

    // O(n^2) time | O(n) space
    public int countSquares(int[][] points) {
        // Write your code here.
        Set<String> pointsSet = new HashSet<>();
        for (int[] point : points) {
            pointsSet.add(pointToString(point));
        }
        int count = 0;
        for (int[] pointA : points) {
            for (int[] pointB : points) {
                if (pointA == pointB) {
                    continue;
                }
                double midPointX = (pointA[0] + pointB[0]) / 2.0;
                double midPointY = (pointA[1] + pointB[1]) / 2.0;

                double xDistanceFromMid = pointA[0] - midPointX;
                double yDistanceFromMid = pointA[1] - midPointY;

                double pointCX = (midPointX + yDistanceFromMid);
                double pointCY = (midPointY - xDistanceFromMid);
                double pointDX = (midPointX - yDistanceFromMid);
                double pointDY = (midPointY + xDistanceFromMid);
                double[] pointC = {pointCX, pointCY};
                double[] pointD = {pointDX, pointDY};

                if (pointsSet.contains(sbPointToString(pointC)) && pointsSet.contains(sbPointToString(pointD))) {
                    count++;
                }
            }
        }
        return count / 4;
    }

    private String pointToString(int[] point) {
        return point[0] + "," + point[1];
    }

    private String sbPointToString(double[] point) {
        if (point[0] % 1 == 0 && point[1] % 1 == 0) {
            return (int) point[0] + "," + (int) point[1];
        }
        return point[0] + "," + point[1];
    }
}
