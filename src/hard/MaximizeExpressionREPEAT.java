package hard;

public class MaximizeExpressionREPEAT {

    public static void main(String[] args) {
        int[] array = {3, 6, 1, -3, 2, 7};

        MaximizeExpressionREPEAT me = new MaximizeExpressionREPEAT();
        me.maximizeExpression(array);
    }

//    // O(n) time | O(n) space
//    // OK - repeated 06/02/2022
//    public int maximizeExpression(int[] array) {
//        if (array.length < 4) {
//            return 0;
//        }
//        // array = [3, 6, 1, -3, 2, 7]
//
//        int[] maxOfA = new int[array.length];
//        maxOfA[0] = array[0];
//        // maxOfA = [3, 0, 0, 0, 0, 0]
//        int[] maxOfAMinusB = new int[array.length];
//        int[] maxOfAMinusBPlusC = new int[array.length];
//        int[] maxOfAMinusBPlusCMinusD = new int[array.length];
//        for (int i = 0; i < array.length; i++) {
//            maxOfAMinusB[i] = Integer.MIN_VALUE;
//            maxOfAMinusBPlusC[i] = Integer.MIN_VALUE;
//            maxOfAMinusBPlusCMinusD[i] = Integer.MIN_VALUE;
//        }
//
//        for (int idx = 1; idx < array.length; idx++) {
//            int currentMax = Math.max(maxOfA[idx - 1], array[idx]); // max(6, 7)
//            maxOfA[idx] = currentMax; // 7
//        }
//
//        for (int idx = 1; idx < array.length; idx++) {
//            int currentMax = Math.max(maxOfAMinusB[idx - 1], maxOfA[idx - 1] - array[idx]); // max(9, 6 - (7))= 9
//            maxOfAMinusB[idx] = currentMax; // 9
//        }
//
//        for (int idx = 2; idx < array.length; idx++) {
//            int currentMax = Math.max(maxOfAMinusBPlusC[idx - 1], maxOfAMinusB[idx - 1] + array[idx]); // max(11, 9 + 7)
//            maxOfAMinusBPlusC[idx] = currentMax; // 16
//        }
//
//        // array =                   [   3,    6,    1,   -3,    2,    7]
//        // maxOfA =                  [   3,    6,    6,    6,    6,    7]
//        // maxOfAMinusB =            [-999,   -3,    5,    9,    9,    9]
//        // maxOfAMinusBPlusC =       [-999, -999,   -2,    2,   11,   16]
//        //                                                            idx
//        // maxOfAMinusBPlusCMinusD = [-999, -999, -999,    1,    1,    4]
//        for (int idx = 3; idx < array.length; idx++) {
//            int currentMax = Math.max(maxOfAMinusBPlusCMinusD[idx - 1], maxOfAMinusBPlusC[idx - 1] - array[idx]);
//            // max(1, 11 - 7)
//            maxOfAMinusBPlusCMinusD[idx] = currentMax;
//        }
//
//
//        return maxOfAMinusBPlusCMinusD[array.length - 1]; // 4
//    }

    // O(n^4) time | O(1) space
    public int maximizeExpression(int[] array) {
        // Write your code here.
        if (array.length < 4) {
            return 0;
        }
        //          a  b  c   d
        // array = [3, 6, 1, -3, 2, 7]
        int maximumValueFound = -99999;

        for (int a = 0; a < array.length; a++) {
            int aValue = array[a]; // 3
            for (int b = a + 1; b < array.length; b++) {
                int bValue = array[b]; // 6
                for (int c = b + 1; c < array.length; c++) {
                    int cValue = array[c]; // 1
                    for (int d = c + 1; d < array.length; d++) {
                        int dValue = array[d]; // -3
                        int expressionValue = evaluateExpression(aValue, bValue, cValue, dValue);
                        maximumValueFound = Math.max(expressionValue, maximumValueFound);
                    }
                }
            }
        }
        return maximumValueFound;
    }

    private int evaluateExpression(int a, int b, int c, int d) {
        return a - b + c - d;
    }

}
