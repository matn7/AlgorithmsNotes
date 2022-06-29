package whiteboard;

public class MonotonicArray {

    // O(n) time | O(1) space
    // #2: 21/06/2022
    public static boolean isMonotonic(int[] array) {
        // Write your code here.
        boolean isIncreasing = true;
        boolean isDecreasing = true;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i-1]) {
                isIncreasing = false;
            }
            if (array[i] > array[i-1]) {
                isDecreasing = false;
            }
        }

        return isIncreasing || isDecreasing;
    }

}
