package whiteboard;

import java.util.ArrayList;
import java.util.Arrays;

public class SmallestDifference {

    public static void main(String[] args) {
        int[] arrayOne = {-1, 5, 10, 20, 28, 3};
        int[] arrayTwo = {26, 134, 135, 15, 17};

        smallestDifference(arrayOne, arrayTwo);
    }

    // O(nlog(n) + mlog(m)) time | O(1) space
    // rand: 18/07/2022 | 03/08/2022
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        // Write your code here.
        int c1 = 0;
        int c2 = 0;
        int minDiff = Integer.MAX_VALUE;
        int[] result = new int[] {-1, -1};

        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        while (c1 < arrayOne.length && c2 < arrayTwo.length) {
            int first = arrayOne[c1];
            int second = arrayTwo[c2];
            int diff = Math.abs(first - second);
            if (diff < minDiff) {
                minDiff = diff;
                result[0] = first;
                result[1] = second;
            }
            if (first < second) {
                c1++;
            } else {
                c2++;
            }
        }
        return result;
    }

}
