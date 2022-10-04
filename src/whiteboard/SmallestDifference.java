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

    // O(nlog(n) + mlog(m)) time | O(1) space
    public static int[] smallestDifferenceMy(int[] arrayOne, int[] arrayTwo) {
        // Write your code here.
        if (arrayOne.length == 0 || arrayTwo.length == 0) {
            return new int[0];
        }
        int[] res = new int[] {-1,-1};
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int p1 = 0;
        int p2 = 0;
        int currMin = Integer.MAX_VALUE;
        while (p1 < arrayOne.length && p2 < arrayTwo.length) {
            int val1 = arrayOne[p1];
            int val2 = arrayTwo[p2];
            int diff;
            if (val1 < val2) {
                diff = Math.abs(val2 - val1);
                p1++;
            } else {
                diff = Math.abs(val1 - val2);
                p2++;
            }
            if (diff < currMin) {
                currMin = diff;
                res[0] = val1;
                res[1] = val2;
                if (diff == 0) {
                    break;
                }
            }
        }
        return res;
    }

}
