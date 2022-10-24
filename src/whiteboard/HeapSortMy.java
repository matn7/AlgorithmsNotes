package whiteboard;

public class HeapSortMy {

    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 5, 6, 3};
        heapSort(array);
    }

    // O(nlog(n)) time | O(1) space
    public static int[] heapSort(int[] array) {
        // Write your code here.
        if (array.length == 0) {
            return new int[] {};
        }
        int endIdx = array.length - 1;
        buildMaxHeap(array, endIdx);

        for (int i = 0; i <= endIdx; i++) {
            swap(array, 0, endIdx - i);
            siftDown(array, 0, endIdx - i - 1);
        }

        return array;
    }

    private static void buildMaxHeap(int[] array, int endIdx) {
        int parentIdx = (endIdx - 1) / 2;
        for (int i = parentIdx; i >= 0; i--) {
            siftDown(array, i, endIdx);
        }
    }

    private static void siftDown(int[] array, int idx, int endIdx) {
        int leftChildIdx = 2 * idx + 1;
        while (leftChildIdx <= endIdx) {
            int rightChildIdx = 2 * idx + 2;
            int idxToSwap;
            if (rightChildIdx > endIdx) {
                rightChildIdx = -1;
            }
            if (rightChildIdx != -1 && array[rightChildIdx] > array[leftChildIdx]) {
                idxToSwap = rightChildIdx;
            } else {
                idxToSwap = leftChildIdx;
            }

            if (array[idxToSwap] > array[idx]) {
                swap(array, idxToSwap, idx);
                idx = idxToSwap;
                leftChildIdx = 2 * idx + 1;
            } else {
                break;
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
