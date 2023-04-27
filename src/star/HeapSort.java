package star;

public class HeapSort {

    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 5, 6, 3};

        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(array);
    }

    // O(nlog(n)) time | O(1) space
    public int[] heapSort(int[] array) {

        if (array.length <= 1) {
            return array;
        }

        buildMaxHeap(array);
        int idx = 0;
        while (idx != array.length) {
            swap(0, array.length - idx - 1, array);
            siftDown(0, array.length - idx - 1, array);
            idx++;
        }

        return array;
    }

    private void buildMaxHeap(int[] array) {
        int parentIdx = (array.length - 2) / 2;

        for (int currIdx = parentIdx; currIdx >= 0; currIdx--) {
            siftDown(currIdx, array.length, array);
        }
    }

    private void siftDown(int currIdx, int endIdx, int[] array) {
        int leftChildIdx = 2 * currIdx + 1;
        while (leftChildIdx < endIdx) {
            int idxToSwap;
            int rightChildIdx = 2 * currIdx + 2;
            if (rightChildIdx >= endIdx) {
                rightChildIdx = -1;
            }
            if (rightChildIdx != -1 && array[rightChildIdx] > array[leftChildIdx]) {
                idxToSwap = rightChildIdx;
            } else {
                idxToSwap = leftChildIdx;
            }

            if (array[idxToSwap] > array[currIdx]) {
                swap(idxToSwap, currIdx, array);
                currIdx = idxToSwap;
                leftChildIdx = 2 * currIdx + 1;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
