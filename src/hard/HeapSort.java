package hard;

public class HeapSort {

    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 5, 6, 3};
        heapSort(array);
    }

    // O(n*log(n)) time | O(1) space
    public static int[] heapSort(int[] array) {
        // Write your code here.
        buildMaxHeap(array);
        for (int endIdx = array.length - 1; endIdx >= 1; endIdx--) {
            swap(0, endIdx, array);
            siftDown(0, endIdx - 1, array);
        }
        return array;
    }

    private static void buildMaxHeap(int[] array) {
        int firstParentIdx = (array.length - 1) / 2;
        for (int currentIdx = firstParentIdx + 1; currentIdx >= 0; currentIdx--) {
            siftDown(currentIdx, array.length - 1, array);
        }
    }

    private static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void siftDown(int currentIdx, int endIdx, int[] heap) {
        int idxToSwap;
        int childOneIdx = currentIdx * 2 + 1;
        while (childOneIdx <= endIdx) {
            int childTwoIdx = currentIdx * 2 + 2;
            if (childTwoIdx > endIdx) {
                childTwoIdx = -1;
            }
            if (childTwoIdx > -1 && heap[childTwoIdx] > heap[childOneIdx]) {
                idxToSwap = childTwoIdx;
            } else {
                idxToSwap = childOneIdx;
            }
            if (heap[idxToSwap] > heap[currentIdx]) {
                swap(currentIdx, idxToSwap, heap);
                currentIdx = idxToSwap;
                childOneIdx = currentIdx * 2 + 1;
            } else {
                return;
            }
        }
    }
}
