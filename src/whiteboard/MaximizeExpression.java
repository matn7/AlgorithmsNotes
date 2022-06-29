package whiteboard;

public class MaximizeExpression {

    // O(n) time | O(n) space
    public int maximizeExpression(int[] array) {
        // Write your code here.
        if (array.length < 4) {
            return 0;
        }
        int[] maxOfA = new int[array.length];
        maxOfA[0] = array[0];
        int[] maxOfAMinusB = new int[array.length];
        int[] maxOfAMinusBPlusC = new int[array.length];
        int[] maxOfAMinusBPlusCMinusD = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            maxOfAMinusB[i] = Integer.MIN_VALUE;
            maxOfAMinusBPlusC[i] = Integer.MIN_VALUE;
            maxOfAMinusBPlusCMinusD[i] = Integer.MIN_VALUE;
        }

        for (int i = 1; i < array.length; i++) {
            int currMax = Math.max(maxOfA[i - 1], array[i]);
            maxOfA[i] = currMax;
        }

        for (int i = 1; i < array.length; i++) {
            int currMax = Math.max(maxOfAMinusB[i - 1], maxOfA[i - 1] - array[i]);
            maxOfAMinusB[i] = currMax;
        }

        for (int i = 2; i < array.length; i++) {
            int currMax = Math.max(maxOfAMinusBPlusC[i - 1], maxOfAMinusB[i - 1] + array[i]);
            maxOfAMinusBPlusC[i] = currMax;
        }

        for (int i = 3; i < array.length; i++) {
            int currMax = Math.max(maxOfAMinusBPlusCMinusD[i - 1], maxOfAMinusBPlusC[i - 1] - array[i]);
            maxOfAMinusBPlusCMinusD[i] = currMax;
        }
        return maxOfAMinusBPlusCMinusD[array.length - 1];
    }


}
