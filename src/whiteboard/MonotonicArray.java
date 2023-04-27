package whiteboard;

public class MonotonicArray {

    // O(n) time | O(1) space
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

    // O(n) time | O(1) space
    public static boolean isMonotonic2(int[] array) {
        // Write your code here.
        if (array.length <= 1) {
            return true;
        }
        boolean increasing = false;
        boolean decreasing = false;
        boolean flat = false;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                if (increasing) {
                    return false;
                }
                decreasing = true;
            } else if (array[i] > array[i - 1]) {
                if (decreasing) {
                    return false;
                }
                increasing = true;
            } else {
                flat = true;
            }
        }
        return increasing || decreasing || flat;
    }

}
