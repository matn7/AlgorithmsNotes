package october_2023;

public class MaximizeExpression {

    public static void main(String[] args) {
        int[] array = {3, 6, 1, -3, 2, 7};

        maximizeExpression(array);
    }

    // O(n) time | O(n) space
    public static int maximizeExpression(int[] array) {
        if (array.length < 4) {
            return 0;
        }
        int[] maxOfA = new int[array.length];
        int currMax = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            currMax = Math.max(currMax, array[i]);
            maxOfA[i] = currMax;
        }

        // [3,  6, 6, 6, 6, 7]
        // [0, -3, 5, 9, 9, 9]
        int[] maxOfAMinusB = new int[array.length];
        currMax = Integer.MIN_VALUE;
        for (int i = 1; i < array.length; i++) {
            int a = maxOfA[i - 1];
            int b = array[i];
            currMax = Math.max(currMax, a - b);
            maxOfAMinusB[i] = currMax;
        }

        int[] maxOfAMinusBPlusC = new int[array.length];
        currMax = Integer.MIN_VALUE;
        for (int i = 2; i < array.length; i++) {
            int ab = maxOfAMinusB[i - 1];
            int c = array[i];
            currMax = Math.max(currMax, ab + c);
            maxOfAMinusBPlusC[i] = currMax;
        }

        int[] maxOfAMinusBPlusCMinusD = new int[array.length];
        currMax = Integer.MIN_VALUE;
        for (int i = 3; i < array.length; i++) {
            int abc = maxOfAMinusBPlusC[i - 1];
            int d = array[i];
            currMax = Math.max(currMax, abc - d);
            maxOfAMinusBPlusCMinusD[i] = currMax;
        }

        return maxOfAMinusBPlusCMinusD[array.length - 1];
    }

}
