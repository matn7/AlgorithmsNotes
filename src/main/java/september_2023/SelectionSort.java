package september_2023;

public class SelectionSort {

    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 5, 6, 3};

        selectionSort(array);
    }

    // O(n^2) time | O(1) space
    public static int[] selectionSort(int[] array) {
        // Write your code here.
        //                    j
        // [2, 3, 8, 9, 5, 6, 5]
        //     i
        // minIdx = 6
        // array[minIdx] = 5
        for (int i = 0; i < array.length; i++) {
            int minIdx = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIdx]) { // 3 < 5
                    minIdx = j;
                }
            }
            swap(array, i, minIdx);
        }
        return array;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}