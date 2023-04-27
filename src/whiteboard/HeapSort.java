package whiteboard;

public class HeapSort {

    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 5, 6, 3};

        heapSort(array);
    }

    // ********
    // * STAR *
    // ********

    // O(nlog(n)) time | O(1) space
    public static int[] heapSort(int[] array) {
        // Write your code here.
        buildMaxHeap(array);

        int idx = 0;
        while (idx != array.length) {
            swap(0, array.length - 1 - idx, array);
            siftDown(array, 0, array.length - 1 - idx);
            idx++;
        }

        return array;
    }

    private static void buildMaxHeap(int[] array) {
        int parentIdx = (array.length - 2) / 2;
        for (int currIdx = parentIdx; currIdx >= 0; currIdx--) {
            siftDown(array, currIdx, array.length);
        }
    }

    private static void siftDown(int[] array, int currIdx, int endIdx) {
        int leftChildIdx = (2 * currIdx + 1);
        while (leftChildIdx < endIdx) {
            int idxToSwap;
            int rightChildIdx = (2 * currIdx + 2);
            if (rightChildIdx < endIdx && array[rightChildIdx] > array[leftChildIdx]) {
                idxToSwap = rightChildIdx;
            } else {
                idxToSwap = leftChildIdx;
            }

            if (array[currIdx] < array[idxToSwap]) {
                swap(currIdx, idxToSwap, array);
                currIdx = idxToSwap;
                leftChildIdx = (2 * currIdx + 1);
            } else {
                break;
            }
        }
    }

    private static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // O(nlog(n)) time | O(1) space
    public static int[] heapSort2(int[] array) {
        // Write your code here.
        buildMaxHeap2(array);
        for (int i = 0; i < array.length; i++) {
            swap2(array, 0, array.length - 1 - i);
            siftDown(array, 0, array.length - 1 - i);
        }
        return array;
    }

    private static void buildMaxHeap2(int[] array) {
        int lastIdx = array.length - 1;
        int parentIdx = (lastIdx - 1) / 2;

        for (int i = parentIdx; i >= 0; i--) {
            siftDown2(array, i, lastIdx);
        }
    }

    private static void siftDown2(int[] array, int start, int end) {
        int leftIdx = 2 * start + 1;
        while (leftIdx < end) {
            int idxToSwap = 0;
            int rightIdx = 2 * start + 2;
            if (rightIdx >= end) {
                rightIdx = -1;
            }
            if (rightIdx == -1 || array[leftIdx] > array[rightIdx]) {
                idxToSwap = leftIdx;
            } else {
                idxToSwap = rightIdx;
            }
            if (array[idxToSwap] > array[start]) {
                swap2(array, start, idxToSwap);
                start = idxToSwap;
                leftIdx = 2 * start + 1;
            } else {
                break;
            }
        }
    }

    private static void swap2(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
