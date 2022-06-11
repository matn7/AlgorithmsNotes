package hard;

public class MaximizeExpression {

    public static void main(String[] args) {
        int[] array = {3, 6, 1, -3, 2, 7};

        MaximizeExpression max = new MaximizeExpression();
        max.maximizeExpression(array);
    }

    // O(n) time | O(n) space
    public int maximizeExpression(int[] array) {
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

        for (int idx = 1; idx < array.length; idx++) {
            int currentMax = Math.max(maxOfA[idx - 1], array[idx]);
            maxOfA[idx] = currentMax;
        }

        for (int idx = 1; idx < array.length; idx++) {
            int currentMax = Math.max(maxOfAMinusB[idx - 1], maxOfA[idx - 1] - array[idx]);
            maxOfAMinusB[idx] = currentMax;
        }

        for (int idx = 2; idx < array.length; idx++) {
            int currentMax = Math.max(maxOfAMinusBPlusC[idx - 1], maxOfAMinusB[idx - 1] + array[idx]);
            maxOfAMinusBPlusC[idx] = currentMax;
        }

        for (int idx = 3; idx < array.length; idx++) {
            int currentMax = Math.max(maxOfAMinusBPlusCMinusD[idx - 1], maxOfAMinusBPlusC[idx - 1] - array[idx]);
            maxOfAMinusBPlusCMinusD[idx] = currentMax;
        }

        return maxOfAMinusBPlusCMinusD[array.length - 1];
    }

//    // O(n^4) time | O(1) space
//    public int maximizeExpression(int[] array) {
//        // Write your code here.
//        if (array.length < 4) {
//            return 0;
//        }
//        int maximumValueFound = Integer.MIN_VALUE;
//
//        for (int a = 0; a < array.length; a++) {
//            int aValue = array[a];
//            for (int b = a + 1; b < array.length; b++) {
//                int bValue = array[b];
//                for (int c = b + 1; c < array.length; c++) {
//                    int cValue = array[c];
//                    for (int d = c + 1; d < array.length; d++) {
//                        int dValue = array[d];
//                        int expressionValue = evaluateExpression(aValue, bValue, cValue, dValue);
//                        maximumValueFound = Math.max(expressionValue, maximumValueFound);
//                    }
//                }
//            }
//        }
//        return maximumValueFound;
//    }
//
//    private int evaluateExpression(int a, int b, int c, int d) {
//        return a - b + c - d;
//    }

}
