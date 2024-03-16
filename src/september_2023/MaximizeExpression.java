package september_2023;

public class MaximizeExpression {

    public static void main(String[] args) {
        int[] array = {3, 6, 1, -3, 2, 7};

        MaximizeExpression maximizeExpression = new MaximizeExpression();
        maximizeExpression.maximizeExpression(array);
    }

    // O(n) time | O(n) space
    public int maximizeExpression(int[] array) {
        // Write your code here.
        // [3, 6, 1, -3, 2, 7]
        if (array.length < 4) {
            return 0;
        }
        int[] maxOfA = new int[array.length];
        maxOfA[0] = array[0];
        int[] arrAmB = new int[array.length];
        int[] arrAmBpC = new int[array.length];
        int[] arrAmBpCmD = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            arrAmB[i] = Integer.MIN_VALUE;
            arrAmBpC[i] = Integer.MIN_VALUE;
            arrAmBpCmD[i] = Integer.MIN_VALUE;
        }

        for (int i = 1; i < array.length; i++) {
            int currentMax = Math.max(array[i], maxOfA[i - 1]);
            maxOfA[i] = currentMax;
        }

        for (int i = 1; i < array.length; i++) {
            int currentMax = Math.max(arrAmB[i - 1], maxOfA[i - 1] - array[i]);
            arrAmB[i] = currentMax;
        }

        for (int i = 2; i < array.length; i++) {
            int currentMax = Math.max(arrAmBpC[i - 1], arrAmB[i - 1] + array[i]);
            arrAmBpC[i] = currentMax;
        }

        for (int i = 3; i < array.length; i++) {
            int currentMax = Math.max(arrAmBpCmD[i - 1], arrAmBpC[i - 1] - array[i]);
            arrAmBpCmD[i] = currentMax;
        }
        return arrAmBpCmD[array.length - 1];
    }

}
