package hard;

public class HeapSortREPEAT {

    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 5, 6, 3};

        heapSort(array);
    }

    // O(n*log(n)) time | O(1) space
    // OK - repeated 30/01/2022
    public static int[] heapSort(int[] array) {
        // Write your code here.
        buildMaxHeap(array);
        // [9, 8, 6, 5, 5, 2, 3]
        for (int endIdx = array.length - 1; endIdx >= 1; endIdx--) {
            swap(0, endIdx, array);
            // [3, 8, 6, 5, 5, 2, 9]
            // [2, 5, 6, 3, 5, 8, 9]
            // [5, 5, 2, 3, 6, 8, 9]
            // [3, 5, 2, 5, 6, 8, 9]
            // [2, 3, 5, 5, 6, 8, 9]
            // [2, 3, 5, 5, 6, 8, 9]
            siftDown(0, endIdx - 1, array);
        }
        return array; // [2, 3, 5, 5, 6, 8, 9]
    }

    private static void buildMaxHeap(int[] array) {
        // firstParentIdx = 3
        //          0  1  2  3  4  5  6
        // array = [8, 5, 2, 9, 5, 6, 3]
        int firstParentIdx = (array.length - 1) / 2;
        // currentIdx = 0
        for (int currentIdx = firstParentIdx + 1; currentIdx >= 0; currentIdx--) {
            siftDown(currentIdx, array.length - 1, array);
        }
    }

    private static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    //                 0  1  2  3  4  5  6
    // siftDown(0, 0, [2, 3, 5, 5, 6, 8, 9])
    private static void siftDown(int currentIdx, int endIdx, int[] heap) {
        int idxToSwap;
        int childOneIdx = currentIdx * 2 + 1; // 1
        while (childOneIdx <= endIdx) {
            int childTwoIdx = currentIdx * 2 + 2; // 3
            if (childTwoIdx > endIdx) {
                childTwoIdx = -1;
            }
            if (childTwoIdx > -1 && heap[childTwoIdx] > heap[childOneIdx]) { // 5 > 5
                idxToSwap = childTwoIdx; // 2
            } else {
                idxToSwap = childOneIdx; // 1
            }
            if (heap[idxToSwap] > heap[currentIdx]) { // 5 > 3
                swap(currentIdx, idxToSwap, heap);
                currentIdx = idxToSwap; // 1
                childOneIdx = currentIdx * 2 + 1; // 7
            } else {
                return;
            }
        }
    }
}
