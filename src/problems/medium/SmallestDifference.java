package problems.medium;

import java.util.Arrays;

public class SmallestDifference {

    public static void main(String[] args) {
        int[] arrayOne = {-1, 5, 10, 20, 28, 3};
        int[] arrayTwo = {26, 134, 135, 15, 17};

        smallestDifference(arrayOne, arrayTwo);
    }

    // O(nlog(n) + mlog(m)) time | O(1) space
    // OK - repeated 10/02/2022
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        // Write your code here.
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        //                                   o
        // arrayOne = [-1, 3, 5, 10, 20, 28]
        // arrayTwo = [15, 17, 26, 134, 135]
        //                           t
        int idxOne = 0;
        int idxTwo = 0;
        int smallest = Integer.MAX_VALUE;
        int current;
        int[] smallestPair = new int[2]; // [0, 0]
        while (idxOne < arrayOne.length && idxTwo < arrayTwo.length) {
            int firstNum = arrayOne[idxOne]; // 28
            int secondNum = arrayTwo[idxTwo]; // 134
            if (firstNum < secondNum) { // 28 < 134
                current = secondNum - firstNum; // 134 - 28 = 106
                idxOne++; // 5
            } else if (secondNum < firstNum) { // 26 < 28
                current = firstNum - secondNum; // 28 - 26 = 2
                idxTwo++; // 3
            } else {
                smallestPair[0] = firstNum;
                smallestPair[1] = secondNum;
                return smallestPair;
            }
            if (current < smallest) { // 106 < 2
                smallest = current; // 2
                smallestPair[0] = firstNum; // 28
                smallestPair[1] = secondNum; // 26
            }
        }
        return smallestPair; // [28, 26]
    }

}
