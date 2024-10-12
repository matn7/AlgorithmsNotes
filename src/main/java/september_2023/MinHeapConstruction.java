package september_2023;

import java.util.ArrayList;
import java.util.List;

public class MinHeapConstruction {

    public static void main(String[] args) {
        int[] arr = {48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41};
        List<Integer> array = new ArrayList<>();
        for (int a : arr) {
            array.add(a);
        }

        MinHeap minHeap = new MinHeap(array);
        minHeap.insert(76);
        minHeap.insert(-28);
        minHeap.peek();
        minHeap.remove();
        //  0    1   2  3  4   5   6    7   8   9  10  11  12  13
        // [48, 12, 24, 7, 8, -5, 24, 391, 24, 56,  2,  6,  8, 41, 76]
        //                         *                            l
        // parentIdx = 6
    }

    static class MinHeap {
        List<Integer> heap = new ArrayList<Integer>();

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        public List<Integer> buildHeap(List<Integer> array) {
            // Write your code here.
            int parentIdx = (array.size() - 1) / 2;
            while (parentIdx >= 0) {
                int currIdx = parentIdx;
                siftDown(currIdx, array.size() - 1, array);
                parentIdx--;
            }
            return array;
        }

        private void swap(int i, int j, List<Integer> array) {
            int temp = array.get(i);
            array.set(i, array.get(j));
            array.set(j, temp);
        }

        public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
            // Write your code here.
            int leftIdx = 2 * currentIdx + 1;
            while (leftIdx <= endIdx) {
                int idxToSwap;
                int rightIdx = 2 * currentIdx + 2;
                if (rightIdx > heap.size() - 1) {
                    rightIdx = -1;
                }
                if (rightIdx != -1 && heap.get(rightIdx) < heap.get(leftIdx)) {
                    idxToSwap = rightIdx;
                } else {
                    idxToSwap = leftIdx;
                }
                if (heap.get(currentIdx) > heap.get(idxToSwap)) {
                    swap(currentIdx, idxToSwap, heap);
                    currentIdx = idxToSwap;
                    leftIdx = 2 * currentIdx + 1;
                } else {
                    break;
                }
            }
        }

        public void siftUp(int currentIdx, List<Integer> heap) { // 6
            // Write your code here.
            int parentIdx = (currentIdx - 1) / 2; //
            while (currentIdx > 0 && heap.get(currentIdx) < heap.get(parentIdx)) { // 15 < 6
                swap(currentIdx, parentIdx, heap);
                currentIdx = parentIdx;
                parentIdx = (currentIdx - 1) / 2; // (6 - 1) / 2 = 2
            }
        }

        public int peek() {
            // Write your code here.
            if (heap.isEmpty()) {
                throw new RuntimeException("Heap is empty!");
            }
            return heap.get(0);
        }

        public int remove() {
            // Write your code here.
            //   0    1   2  3  4   5   6    7   8   9  10  11  12  13  14  15
            // [ 76, -5,  2,  6, 7, 8,  8, 24, 391, 24, 56, 12, 24, 48, 41]
            //                         *                            l   r
            swap(0, heap.size() - 1, heap);
            Integer removed = heap.remove(heap.size() - 1);
            siftDown(0, heap.size() - 1, heap);
            return removed;
        }

        public void insert(int value) {
            // Write your code here.
            //  0    1   2  3  4   5   6    7   8   9  10  11  12  13  14
            // [-5,  2,  6, 7, 8,  8, 24, 391, 24, 56, 12, 24, 48, 41, 76]
            //                         *                            l   r
            // parentIdx = 6
            heap.add(value);
            siftUp(heap.size() - 1, heap);
        }
    }

}
