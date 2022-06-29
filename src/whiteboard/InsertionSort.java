package whiteboard;

public class InsertionSort {

    // O(n^2) time | O(1) space
    // #2: 24/06/2022
    public static int[] insertionSort(int[] array) {
        // Write your code here.
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j - 1] > array[j]) {
                    swap(array, j - 1, j);
                }
            }
        }
        return array;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
