package whiteboard;

public class HeapSort {

    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 5, 6, 3};

        heapSort(array);
    }

    // O(nlog(n)) time | O(1) space
    // #2: 10/07/2022
    // rand: 25/09/2022
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

    // ==================================================================
    // O(nlog(n)) time | O(1) space
    public static int[] heapSort2(int[] array) {
        // Write your code here.
        buildMaxHeap2(array);
        for (int i = 0; i < array.length; i++) {
            swap(array, 0, array.length - 1 - i);
            siftDown2(array, 0, array.length - 1 - i);
            System.out.println();
        }
        return array;
    }

    private static void buildMaxHeap2(int[] array) {
        int parentIdx = (array.length - 1 - 1) / 2;
        for (int currentIdx = parentIdx; currentIdx >= 0; currentIdx--) {
            siftDown2(array, currentIdx, array.length);
        }
    }

    private static void siftDown2(int[] array, int currentIdx, int endIdx) {
        int leftIdx = 2 * currentIdx + 1;
        int idxToSwap;
        while (leftIdx < endIdx) {
            int rightIdx = 2 * currentIdx + 2;
            if (rightIdx >= endIdx) {
                rightIdx = -1;
            }
            if (rightIdx != -1 && array[rightIdx] > array[leftIdx]) {
                idxToSwap = rightIdx;
            } else {
                idxToSwap = leftIdx;
            }
            if (array[currentIdx] < array[idxToSwap]) {
                swap(array, currentIdx, idxToSwap);
                currentIdx = idxToSwap;
                leftIdx = 2 * currentIdx + 1;
            } else {
                break;
            }
        }
    }

    private static void swap(int[] array, int currentIdx, int idxToSwap) {
        int temp = array[currentIdx];
        array[currentIdx] = array[idxToSwap];
        array[idxToSwap] = temp;
    }

}
