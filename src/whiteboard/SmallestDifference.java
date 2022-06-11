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
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        // Write your code here.
        int minDiff = Integer.MAX_VALUE;
        int first = 0;
        int second = 0;

        int res1 = 0;
        int res2 = 0;

        int valOne = 0;
        int valTwo = 0;

        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        while (first < arrayOne.length && second < arrayTwo.length) {
            valOne = arrayOne[first];
            valTwo = arrayTwo[second];
            int diff = 0;
            if (valOne < valTwo) {
                diff = Math.abs(valOne - valTwo);
                first++;
            } else if (valTwo < valOne) {
                diff = Math.abs(valTwo - valOne);
                second++;
            } else {
                return new int[] {valOne, valTwo};
            }

            if (diff < minDiff) {
                minDiff = diff;
                res1 = valOne;
                res2 = valTwo;
            }
        }

        while (first < arrayOne.length) {
            valOne = arrayOne[first];
            int diff = 0;
            if (valOne < valTwo) {
                diff = Math.abs(valOne - valTwo);
            } else if (valTwo < valOne) {
                diff = Math.abs(valTwo - valOne);
            } else {
                return new int[] {valOne, valTwo};
            }
            if (diff < minDiff) {
                minDiff = diff;
                res1 = valOne;
                res2 = valTwo;
            }
            first++;
        }

        while (second < arrayTwo.length) {
            valTwo = arrayTwo[second];
            int diff = 0;
            if (valOne < valTwo) {
                diff = Math.abs(valOne - valTwo);
            } else if (valTwo < valOne) {
                diff = Math.abs(valTwo - valOne);
            } else {
                return new int[] {valOne, valTwo};
            }
            if (diff < minDiff) {
                minDiff = diff;
                res1 = valOne;
                res2 = valTwo;
            }
            second++;
        }

        return new int[] {res1, res2};
    }

}
