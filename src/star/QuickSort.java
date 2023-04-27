package star;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 5, 6, 3, 14, 19, 1};

        QuickSort quickSort = new QuickSort();
        int[] result = quickSort.quickSort(array);
        System.out.println();

    }

    // O(nlog(n)) time | O(n) space
    public int[] quickSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        quickSortHelper(array, 0, array.length - 1);
        return array;
    }

    private void quickSortHelper(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = start;
        int s = start + 1;
        int e = end;
        while (s <= e) {
            if (array[s] > array[pivot] && array[e] < array[pivot]) {
                swap(array, s, e);
            }
            if (array[s] <= array[pivot]) {
                s++;
            }
            if (array[e] >= array[pivot]) {
                e--;
            }
        }
        swap(array, pivot, e);

        if (e - 1 - start > end - (e + 1)) {
            quickSortHelper(array, start, e - 1);
            quickSortHelper(array, e + 1, end);
        } else {
            quickSortHelper(array, e + 1, end);
            quickSortHelper(array, start, e - 1);
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
