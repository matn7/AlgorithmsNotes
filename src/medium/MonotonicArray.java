package medium;

public class MonotonicArray {

    public static void main(String[] args) {
        int[] array = {-1, -5, -10, -1100, -1100, -1101, -1102, -9001};
        isMonotonic(array);
    }

//    // O(n) time | O(1) space
//    public static boolean isMonotonic(int[] array) {
//        boolean isNonDecreasing = true;
//        boolean isNonIncreasing = true;
//        // [-1, -5, -10, -1100, -1100, -1101, -1102, -9001]
//        //                                               *
//        for (int i = 1; i < array.length; i++) {
//            if (array[i] < array[i - 1]) {  // -9001 < -1102
//                isNonDecreasing = false; // INCREASING = FALSE
//            }
//            if (array[i] > array[i - 1]) {  // -5 > -1
//                isNonIncreasing = false; // DECREASING = FALSE
//            }
//        }
//        return isNonDecreasing || isNonIncreasing;
//    }

    // O(n) time | O(1) space
    // OK - repeated 14/02/2022
    public static boolean isMonotonic(int[] array) {
        // Write your code here.
        if (array.length <= 2) {
            return true;
        }

        // [-1, -5, -10, -1100, -1100, -1101, -1102, -9001]
        //                                              *
        int direction = array[1] - array[0]; // -5 - (-1) = -4
        for (int i = 2; i < array.length; i++) {
            if (direction == 0) {
                direction = array[i] - array[i - 1];
                continue;
            }
            if (breaksDirection(direction, array[i - 1], array[i])) {
                return false;
            }
        }
        return true;
    }

    private static boolean breaksDirection(int direction, int previousInt, int currentInt) {
        // -4, -1102, -9001
        int difference = currentInt - previousInt; // -1102 - (-1101) = -1
        if (direction > 0) { // -1
            return difference < 0; // the same direction decreasing
        }
        return difference > 0;
    }

}
