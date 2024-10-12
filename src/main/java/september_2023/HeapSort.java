package september_2023;

public class HeapSort {

    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 5, 6, 3};

        heapSort(array);
    }

    // O(nlog(n)) time | O(1) space
    public static int[] heapSort(int[] array) {
        // Write your code here.
        // [8, 5, 2, 9, 5, 6, 3]
        if (array.length <= 1) {
            return array;
        }
        buildMapHeap(array);
        for (int i = 0; i < array.length - 1; i++) {
            swap(array, 0, array.length - 1 - i);
            siftDown(array, 0, array.length - 1 - i);
        }
        return array;
    }

    private static void buildMapHeap(int[] array) {
        //   0  1  2  3  4  5  6
         // [9, 8, 2, 5, 5, 6, 3]
        //   *
        //      c
        int parentIdx = (array.length - 2) / 2; // 9
        while (parentIdx >= 0) {
            siftDown(array, parentIdx, array.length);
            parentIdx--;
        }
    }

    private static void siftDown(int[] array, int currentIdx, int endIdx) {
        int leftIdx = (2 * currentIdx + 1);
        int idxToSwap;
        while (leftIdx < endIdx) {
            int rightIdx = (2 * currentIdx + 2);
            if (rightIdx >= endIdx) {
                rightIdx = -1;
            }
            if (rightIdx != -1 && array[rightIdx] > array[leftIdx]) {
                idxToSwap = rightIdx;
            } else {
                idxToSwap = leftIdx;
            }
            if (array[idxToSwap] > array[currentIdx]) {
                swap(array, currentIdx, idxToSwap);
                currentIdx = idxToSwap;
                leftIdx = (2 * currentIdx + 1);
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
