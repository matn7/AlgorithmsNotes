package hard;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 5, 6, 3};

        quickSort(array);
    }

    // O(n*log(n)) time | O(log(n))
    // worst case: pivot divides array of 2 arrays one tiny second large --> O(n^2)
    // best: pivot divides array exactly in half --> O(n*log(n))
    // avg: O(n*log(n))
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
        int leftIdx = startIdx + 1;
        int rightIdx = endIdx;
        while (rightIdx >= leftIdx) {
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
        swap(array, pivotIdx, rightIdx); // pivot in sorted position
        // which subarray smaller, to boost space complexity
        boolean leftSubArraySmaller = rightIdx - 1 - startIdx < endIdx - (rightIdx + 1);
        if (leftSubArraySmaller) {
            quickSortHelper(array, startIdx, rightIdx - 1); // left subarray first
            quickSortHelper(array, rightIdx + 1, endIdx);
        } else {
            quickSortHelper(array, rightIdx + 1, endIdx);
            quickSortHelper(array, startIdx, rightIdx - 1);
        }
    }

    private static void swap(int[] array, int leftIdx, int rightIdx) {
        int temp = array[leftIdx];
        array[leftIdx] = array[rightIdx];
        array[rightIdx] = temp;
    }

}
