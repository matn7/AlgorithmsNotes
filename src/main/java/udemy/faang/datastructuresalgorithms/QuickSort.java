package udemy.faang.datastructuresalgorithms;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = {8, 19, 7, 1 ,22, 891, 0, 14, 78};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(array);

    }

    // O(n log(n)) time | O(log(n)) space
    public int[] quickSort(int[] array) {
        if (array.length == 0) {
            return array;
        }

        sort(array, 0, array.length - 1);
        return array;
    }

    private void sort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = start;
        int left = start + 1;
        int right = end;

        while (left <= right) {
            if (array[left] >= array[pivot] && array[right] <= array[pivot]) {
                swap(array, left, right);
            }
            if (array[left] <= array[pivot]) {
                left++;
            }
            if (array[right] >= array[pivot]) {
                right--;
            }
        }
        swap(array, pivot, right);
        if (right - 1 - start > end - (right + 1)) {
            sort(array, start, right - 1);
            sort(array, right + 1, end);
        } else {
            sort(array, right + 1, end);
            sort(array, start, right - 1);
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
