package november_2023;

public class InsertionSort {

    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 5, 6, 3};

        insertionSort(array);
    }

    // O(n^2) time | O(1) space
    public static int[] insertionSort(int[] array) {
        //     i
        // [8, 5, 2, 9, 5, 6, 3]
        //     j
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
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
