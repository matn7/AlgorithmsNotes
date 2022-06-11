package medium;

import java.util.HashMap;
import java.util.Map;

public class FirstDuplicateValueREPEAT {

    public static void main(String[] args) {
        int[] array = {2, 1, 5, 3, 3, 2, 4};
        FirstDuplicateValueREPEAT firstDuplicateValueREPEAT = new FirstDuplicateValueREPEAT();
        firstDuplicateValueREPEAT.firstDuplicateValue(array);
    }

    // OK - repeated 18/02/2022
    // O(n) time | O(1) space
    public int firstDuplicateValue(int[] array) {
        //                i
        //   0   1   2  3  4  5  6
        // [-2, -1, -5, 3, -3, 2, 4]
        for (int value : array) { // 3
            int absValue = Math.abs(value); // 3
            if (array[absValue - 1] < 0) {
                return absValue; // 3
            }
            array[absValue - 1] *= -1;
        }
        return -1;
    }

//    // O(n) time | O(n) space
//    public int firstDuplicateValue(int[] array) {
//        Map<Integer, Boolean> seen = new HashMap<>();
//        // seen = {2, TRUE, 1: TRUE, 5: TRUE, 3: TRUE}
//        //              *
//        // [2, 1, 5, 3, 3, 2, 4]
//        for (int value : array) {
//            if (seen.containsKey(value)) {
//                return value; // 3
//            } else {
//                seen.put(value, Boolean.TRUE);
//            }
//        }
//        return -1;
//    }

//    // O(n^2) time | O(1) space
//    public int firstDuplicateValue(int[] array) {
//        // Write your code here.
//        //  0  1  2  3  4  5  6
//        //                    i
//        // [2, 1, 5, 3, 3, 2, 4]
//        //                       j
//        //              m
//        int minimumSecondIndex = array.length; // 7
//        for (int i = 0; i < array.length; i++) {
//            int value = array[i]; // 2
//            for (int j = i + 1; j < array.length; j++) {
//                int valueToCompare = array[j]; // 4
//                if (value == valueToCompare) { // 2 == 4
//                    minimumSecondIndex = Math.min(minimumSecondIndex, j); // min(5,4) = 4
//                }
//            }
//        }
//        if (minimumSecondIndex == array.length) {
//            return -1;
//        }
//        return array[minimumSecondIndex]; // 3
//    }

}
