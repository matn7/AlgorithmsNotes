package november_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersections {

    public static void main(String[] args) {
        int[][] firstInterval = {{0,2},{5,10},{13,23},{24,25}};
        int[][] secondInterval = {{1,5},{8,12},{15,24},{25,26}};

//        int[][] firstInterval = {{1, 3}, {5, 9}};
//        int[][] secondInterval = {};

        IntervalListIntersections intervalListIntersections = new IntervalListIntersections();
        int[][] result = intervalListIntersections.intervalIntersection(firstInterval, secondInterval);
        System.out.println(result);

    }

    // O(n + m) time | O(m + n) space
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
//        Arrays.sort(firstList, (a, b) -> a[0] - b[0]);
//        Arrays.sort(secondList, (a, b) -> a[0] - b[0]);

        List<int[]> overlaps = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < firstList.length && j < secondList.length) {
            int[] A = firstList[i];
            int[] B = secondList[j];

            // Set A to the interval that starts first and B to the other interval
            if (A[0] > B[0]) {
                int[] temp = A;
                A = B;
                B = temp;
            }

            // If there is an overlap, add the overlap
            if (A[1] >= B[0]) {
                overlaps.add(new int[] {B[0], Math.min(A[1], B[1])});
            }

            // Advance the pointer associated with the interval that ends first
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        int[][] result = new int[overlaps.size()][2];
        for (int k = 0; k < overlaps.size(); k++) {
            result[k] = overlaps.get(k);
        }
        return result;
    }

}
