package september_2023;

public class MonotonicArray {

    public static void main(String[] args) {
        int[] array = {-1, -5, -10, -1100, -1100, -1102, -9001};
        isMonotonic(array);
    }

    // O(n) time | O(1) space
    public static boolean isMonotonic(int[] array) {
        // Write your code here.
        if (array.length <= 2) {
            return true;
        }
        boolean isIncreasing = false;
        boolean isDecreasing = false;
        boolean isFlat = false;

        for (int i = 1; i < array.length; i++) {
            int prev = array[i - 1];    // -1
            int curr = array[i];        // -5
            if (curr > prev) { // increasing
                if (isDecreasing) {
                    return false;
                }
                isIncreasing = true;
            } else if (curr < prev) { // decreasing
                if (isIncreasing) {
                    return false;
                }
                isDecreasing = true;
            } else {
                isFlat = true;
            }
        }

        return isIncreasing || isDecreasing || isFlat;
    }

    // O(n) time | O(1) space
    public static boolean isMonotonic2(int[] array) {
        if (array.length <= 2) {
            return true;
        }

        int direction = array[1] - array[0];
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
        int difference = currentInt - previousInt;
        if (direction > 0) {
            return difference < 0;
        }
        return difference > 0;
    }

}
