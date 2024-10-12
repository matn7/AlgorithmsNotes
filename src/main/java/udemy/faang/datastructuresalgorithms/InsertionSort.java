package udemy.faang.datastructuresalgorithms;

public class InsertionSort {

    public static void main(String[] args) {
        int[] array = {8, 19, 7, 1 ,22, 891, 0, 14, 78};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.insertionSort(array);
    }

    // O(n^2) time | O(1) space
    public int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {  // 22 < 1
                    swap(array, j, j - 1);
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
