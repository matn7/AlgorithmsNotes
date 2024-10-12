package udemy.faang.datastructuresalgorithms;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {8, 19, 7, 1 ,22, 891, 0, 14, 78};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(array);
        bubbleSort.bubbleSort2(array);
    }

    // O(n^2) time | O(1) space
    public int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean swapped = false;
            for (int j = 1; j < array.length - i; j++) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return array;
    }

    public int[] bubbleSort2(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
        return array;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
