package whiteboard;

public class FindKthLargestElement {

    public static void main(String[] args) {
//        int[] array = {5, 3, 1, 6, 4, 2};
        int[] array = {4, 4, 1, 1, 1, 3, 5, 2, 4, 6, 8, 1, 3};
        FindKthLargestElement findKthLargestElement = new FindKthLargestElement();
        findKthLargestElement.findKthLargestElement(array, 3);
    }

    // Aver: O(nlog(n)) time | O(log(n)) space
    public int findKthLargestElement(int[] array, int k) {
        if (array.length == 0) {
            return -1;
        }
        int kth = array.length - k;
        quickSort(array, 0, array.length - 1, kth);
        return array[kth];
    }

    private void quickSort(int[] array, int start, int end, int kth) {
        if (start >= end) {
            return;
        }
        System.out.println("=================");
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
        if (right == kth) {
            return;
        }

        if (right - 1 - start > end - (right + 1)) {
            quickSort(array, start, right - 1, kth);
            quickSort(array, right + 1, end, kth);
        } else {
            quickSort(array, right + 1, end, kth);
            quickSort(array, start, right - 1, kth);
        }

    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
