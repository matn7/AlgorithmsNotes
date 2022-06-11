package easy;

import java.util.Arrays;

public class FindThreeLargestNumbersREPEAT {

    public static void main(String[] args) {
        int[] array = {141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7};
        findThreeLargestNumbers(array);
    }

    // OK - repeated 04/03/2022
    //                                               *
    // rec([141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7])
    // O(n) time | O(1) space
    public static int[] findThreeLargestNumbers(int[] array) {
        // Write your code here.
        int[] threeLargest = new int[3];
        Arrays.fill(threeLargest, Integer.MIN_VALUE);
        // threeLargest = [18, 141, 541]

        for (int num : array) {
            updateLargest(threeLargest, num);
            System.out.println();
        }
        return threeLargest;
    }

    // rec([  18,  141,  541],   8)
    // rec([  17,   18,  141], 541)
    // rec([   1,   17,  141],  18)
    // rec([   1,   17,  141], -27)
    // rec([   1,   17,  141], -17)
    // rec([   1,   17,  141],  -7)
    // rec([-999,    1,  141],  17)
    // rec([-999, -999,  141],   1)
    // rec([-999, -999, -999], 141)
    private static void updateLargest(int[] threeLargest, int num) {
        if (threeLargest[2] == Integer.MIN_VALUE || num > threeLargest[2]) { // 7 > 541
            shiftAndUpdate(threeLargest, num, 2);
        } else if (threeLargest[1] == Integer.MIN_VALUE || num > threeLargest[1]) { // 7 > 141
            shiftAndUpdate(threeLargest, num, 1);
        } else if (threeLargest[0] == Integer.MIN_VALUE || num > threeLargest[0]) { // 7 > 18
            shiftAndUpdate(threeLargest, num, 0);
        }
        System.out.println();
    }

    // rec([  17,   18,  141], 541, 2)
    // rec([   1,   17,  141],  18, 1)
    // rec([-999,    1,  141],  17, 1)
    // rec([-999, -999,  141],   1, 1)
    // rec([-999, -999, -999], 141, 2)
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
