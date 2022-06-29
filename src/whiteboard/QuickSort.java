package whiteboard;

public class QuickSort {

    public static void main(String[] args)
    {
        int[] array = {8, 5, 2, 9, 5, 6, 3, 14, 19, 1};

        quickSort(array);

        System.out.println();
    }

    // Best: O(nlog(n)) time | O(log(n)) space
    // Aver: O(nlog(n)) time | O(log(n)) space
    // Wors: O(n^2) time | O(log(n)) space
    // #2: 15/06/2022
    public static int[] quickSort(int[] array) {
        // Write your code here.
        quickSortHelper(array, 0, array.length - 1);
        return array;
    }

    private static void quickSortHelper(int[] array, int startIdx, int endIdx) {
        if (startIdx >= endIdx) {
            return;
        }

        int pivotIdx = startIdx;
        int leftIdx = pivotIdx + 1;
        int rightIdx = endIdx;

        while (leftIdx <= rightIdx) {
            if (array[leftIdx] > array[pivotIdx] && array[rightIdx] < array[pivotIdx]) {
                swap(array, leftIdx, rightIdx);
            }
            if (array[leftIdx] <= array[pivotIdx]) {
                leftIdx++;
            }
            if (array[rightIdx] >= array[pivotIdx]) {
                rightIdx--;
            }
        }
        swap(array, pivotIdx, rightIdx);

        boolean leftSmaller = rightIdx - 1 - startIdx < endIdx - (rightIdx + 1);

        if (leftSmaller) {
            quickSortHelper(array, startIdx, rightIdx - 1);
            quickSortHelper(array, rightIdx + 1, endIdx);
        } else {
            quickSortHelper(array, rightIdx + 1, endIdx);
            quickSortHelper(array, startIdx, rightIdx - 1);
        }
    }

    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }


}
