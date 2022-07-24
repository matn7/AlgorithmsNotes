package whiteboard;

public class HeapSort2 {

    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 5, 6, 3};

        heapSort(array);
    }

    // O(nlog(n)) time | O(1) space
    public static int[] heapSort(int[] array) {
        // Write your code here.
        buildMaxHeap(array);
        for (int i = 0; i < array.length; i++) {
            swap(array, 0, array.length - 1 - i);
            siftDown(array, 0, array.length - 1 - i);
            System.out.println();
        }
        return array;
    }

    private static void buildMaxHeap(int[] array) {
        int parentIdx = (array.length - 1 - 1) / 2;
        for (int currentIdx = parentIdx; currentIdx >= 0; currentIdx--) {
            siftDown(array, currentIdx, array.length);
        }
    }

    private static void siftDown(int[] array, int currentIdx, int endIdx) {
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
