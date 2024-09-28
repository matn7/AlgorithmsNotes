package july_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ClosestPointsToTheOrigin {

    public static void main(String[] args) {
        int[][] points = {{1,1}, {3,3}, {2,2}, {4,4}, {-1,-1}};
        int k = 3;

        List<int[]> closestPoints = findClosestPoints(points, k);
        System.out.println(closestPoints);
    }

    // O(nlog(n)) time | O(nlog(n)) space
    public static List<int[]> findClosestPoints(int[][] points, int k) {
        Arrays.sort(points, Comparator.comparing(p -> calcDistance(p)));
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(points[i]);
        }
        return result;
    }

    private static int calcDistance(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }

}
