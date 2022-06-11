package easy;

public class InsertionSortREPEAT {

    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 5, 6, 3};

        insertionSort(array);
    }

    // OK - repeated 04/03/2022
    // rec([8, 5, 2, 9, 5, 6, 3])
    // O(n^2) time | O(1) space
    public static int[] insertionSort(int[] array) {
        // Write your code here.

        //                    i
        // [2, 3, 5, 5, 6, 8, 9]
        //     j
        for (int i = 1; i < array.length; i++) {
            int j = i;
            while (j > 0 && array[j] < array[j - 1]) { // 3 < 5
                swap(j, j - 1, array);
                j--;
            }
        }
        return array; // [2, 3, 5, 5, 6, 8, 9]
    }

    private static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
