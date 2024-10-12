package udemy.faang.datastructuresalgorithms;

public class SelectionSort {

    public static void main(String[] args) {
        int[] array = {8, 19, 7, 1 ,22, 891, 0, 14, 78};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.selectionSort(array);
    }

    // O(n^2) time | O(1) space
    public int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minElemIdx = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minElemIdx]) {
                    minElemIdx = j;
                }
            }
            swap(array, i, minElemIdx);
        }
        return array;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
