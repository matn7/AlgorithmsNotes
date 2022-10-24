package udemy.faang;

public class
KthLargestElement {

    public static void main(String[] args) {
        int[] array = {5, 3, 1, 6, 4, 2};

        findKthLargestElement(array, 2);
    }

    // O(nlog(n)) time | O(log(n)) space
    public static int findKthLargestElement(int[] array, int k) {
        quickSort(array, 0, array.length - 1);
        int kth = array.length - k;
        return array[kth];
    }

    private static void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = start;
        int left = start + 1;
        int right = end;

        while (left <= right) {
            if (array[left] > array[pivot] && array[right] < array[pivot]) {
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
            quickSort(array, start, right - 1);
            quickSort(array, right + 1, end);
        } else {
            quickSort(array, right + 1, end);
            quickSort(array, start, right - 1);
        }

    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
