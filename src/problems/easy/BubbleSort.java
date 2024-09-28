package problems.easy;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 5, 6, 3};
        bubbleSort(array);
    }

    // O(n^2) time | O(1) space
    public static int[] bubbleSortAlgo(int[] array) {
        boolean isSorted = false;
        int counter = 0;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1 - counter; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    isSorted = false;
                }
            }
            counter++;
        }
        return array;
    }

    // O(n^2) time | O(1) space
    public static int[] bubbleSort(int[] array) {
        // Write your code here.
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
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
