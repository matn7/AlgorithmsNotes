package whiteboard;

public class SelectionSort2 {

    // O(n^2) time | O(1) space
    public static int[] selectionSort(int[] array) {
        // Write your code here.
        for (int i = 0; i < array.length; i++) {
            int smallestIdx = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[smallestIdx]) {
                    smallestIdx = j;
                }
            }
            swap(array, i, smallestIdx);
        }
        return array;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
