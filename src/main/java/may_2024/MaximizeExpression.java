package may_2024;

import java.util.Arrays;

public class MaximizeExpression {

    public static void main(String[] args) {
        int[] arr = {3, 6, 1, -3, 2, 7};

        int result = maximizeExpression(arr);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static int maximizeExpression(int[] arr) {
        if (arr.length < 4) {
            return 0;
        }
        int[] maxA = new int[arr.length];
        Arrays.fill(maxA, Integer.MIN_VALUE);
        maxA[0] = arr[0];
        for (int a = 1; a < arr.length; a++) {
            int currMax = Math.max(maxA[a - 1], arr[a]);
            maxA[a] = currMax;
        }

        int[] maxAmB = new int[arr.length];
        Arrays.fill(maxAmB, Integer.MIN_VALUE);
        for (int b = 1; b < arr.length; b++) {
            int currMax = Math.max(maxAmB[b - 1], maxA[b - 1] - arr[b]);
            maxAmB[b] = currMax;
        }

        int[] maxAmBpC = new int[arr.length];
        Arrays.fill(maxAmBpC, Integer.MIN_VALUE);
        for (int c = 2; c < arr.length; c++) {
            int currMax = Math.max(maxAmBpC[c - 1], maxAmB[c - 1] + arr[c]);
            maxAmBpC[c] = currMax;
        }

        int[] maxAmBpCmD = new int[arr.length];
        Arrays.fill(maxAmBpCmD, Integer.MIN_VALUE);
        for (int d = 3; d < arr.length; d++) {
            int currMax = Math.max(maxAmBpCmD[d - 1], maxAmBpC[d - 1] - arr[d]);
            maxAmBpCmD[d] = currMax;
        }

        return maxAmBpCmD[arr.length - 1];
    }

}
