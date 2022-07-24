package whiteboard;

public class SelectionSort {

    // O(n^2) time | O(1) space
    // #2: 24/06/2022
    // rand: 20/07/2022
    public static int[] selectionSort(int[] array) {
        // Write your code here.
        for (int i = 0; i < array.length; i++) {
            int currMinIdx = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[currMinIdx]) {
                    currMinIdx = j;
                }
            }
            swap(array, currMinIdx, i);
        }
        return array;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
