package may_2024;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = {6, 5, 3, 1, 8, 7, 2, 4};

        int[] result = quickSort(array);
        System.out.println();
    }

    // O(nlog(n)) time | O(log(n)) space
    public static int[] quickSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        quickSortHelper(array, 0, array.length - 1);
        return array;
    }

    private static void quickSortHelper(int[] array, int left, int right) {
        if (left > right) {
            return;
        }
        int pivot = left;
        int s = left + 1;
        int e = right;

        while (s <= e) {
            if (array[s] >= array[pivot] && array[e] <= array[pivot]) {
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

        if (e - 1 - left > right - (e + 1)) {
            quickSortHelper(array, left, e - 1);
            quickSortHelper(array, e + 1, right);
        } else {
            quickSortHelper(array, e + 1, right);
            quickSortHelper(array, left, e - 1);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
