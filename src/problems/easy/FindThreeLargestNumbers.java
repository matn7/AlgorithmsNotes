package problems.easy;

import java.util.Arrays;

public class FindThreeLargestNumbers {

    public static void main(String[] args) {
        int[] array = {141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7};
        findThreeLargestNumbers(array);
    }

    // O(n) time | O(1) space
    public static int[] findThreeLargestNumbers(int[] array) {
        // Write your code here.
        int[] threeLargest = new int[3];
        Arrays.fill(threeLargest, Integer.MIN_VALUE);

        for (int num : array) {
            updateLargest(threeLargest, num);
            System.out.println();
        }
        return threeLargest;
    }

    private static void updateLargest(int[] threeLargest, int num) {
        if (threeLargest[2] == Integer.MIN_VALUE || num > threeLargest[2]) {
            shiftAndUpdate(threeLargest, num, 2);
        } else if (threeLargest[1] == Integer.MIN_VALUE || num > threeLargest[1]) {
            shiftAndUpdate(threeLargest, num, 1);
        } else if (threeLargest[0] == Integer.MIN_VALUE || num > threeLargest[0]) {
            shiftAndUpdate(threeLargest, num, 0);
        }
    }

    private static void shiftAndUpdate(int[] array, int num, int idx) {
        for (int i = 0; i < idx + 1; i++) {
            if (i == idx) {
                array[i] = num;
            } else {
                array[i] = array[i + 1];
            }
        }
    }
}
