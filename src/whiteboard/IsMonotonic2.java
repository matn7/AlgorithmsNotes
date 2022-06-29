package whiteboard;

public class IsMonotonic2 {

    public static boolean isMonotonic(int[] array) {
        // Write your code here.
        boolean isDecreasing = true;
        boolean isIncreasing = true;

        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                isDecreasing = false;
            }
            if (array[i] < array[i - 1]) {
                isIncreasing = false;
            }
        }
        return isIncreasing || isDecreasing;
    }

}
