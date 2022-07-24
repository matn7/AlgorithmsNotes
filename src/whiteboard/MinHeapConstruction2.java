package whiteboard;

import java.util.ArrayList;
import java.util.List;

public class MinHeapConstruction2 {

    public static void main(String[] args) {
        int[] arr = {48, 12, 24, 7, 8, -5, 24, 391, 24, 46, 2, 6, 8, 41};
        List<Integer> heap = new ArrayList<>();
        for (int element : arr) {
            heap.add(element);
        }
        MinHeap minHeap = new MinHeap(heap);
        minHeap.remove();
        minHeap.insert(4);
    }

    static class MinHeap {
        List<Integer> heap = new ArrayList<Integer>();

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        // O(n) time | O(1) space
        public List<Integer> buildHeap(List<Integer> array) {
            // Write your code here.
            int lastIdx = array.size() - 1;
            int parentIdx = (array.size() - 2) / 2;
            for (int currentIdx = parentIdx; currentIdx >= 0; currentIdx--) {
                siftDown(currentIdx, lastIdx, array);
            }
            return array;
        }

        private void swap(List<Integer> array, int currentIdx, int idxToSwap) {
            int temp = array.get(currentIdx);
            array.set(currentIdx, array.get(idxToSwap));
            array.set(idxToSwap, temp);
        }

        // O(log(n)) time | O(1) space
        public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
            // Write your code here.
            int leftIdx = 2 * currentIdx + 1;
            while (leftIdx <= endIdx) {
                int rightIdx = 2 * currentIdx + 2;
                int idxToSwap;
                if (rightIdx >= heap.size()) {
                    rightIdx = -1;
                }
                if (rightIdx != -1 && heap.get(rightIdx) < heap.get(leftIdx)) {
                    idxToSwap = rightIdx;
                } else {
                    idxToSwap = leftIdx;
                }
                if (heap.get(currentIdx) > heap.get(idxToSwap)) {
                    swap(heap, currentIdx, idxToSwap);
                    currentIdx = idxToSwap;
                    leftIdx = 2 * currentIdx + 1;
                } else {
                    break;
                }
            }
        }

        // O(log(n)) time | O(1) space
        public void siftUp(int currentIdx, List<Integer> heap) {
            // Write your code here.
            int parentIdx = (currentIdx - 2) / 2;
            while (parentIdx >= 0) {
                if (heap.get(parentIdx) > heap.get(currentIdx)) {
                    swap(heap, parentIdx, currentIdx);
                    currentIdx = parentIdx;
                    parentIdx = (currentIdx - 1) / 2;
                } else {
                    break;
                }
            }
        }

        // O(1) time | O(1) space
        public int peek() {
            // Write your code here.
            if (!heap.isEmpty()) {
                return heap.get(0);
            }
            return -1;
        }

        // O(log(n)) time | O(1) space
        public int remove() {
            // Write your code here.
            int currentIdx = 0;
            int lastIdx = heap.size() - 1;
            swap(heap, currentIdx, lastIdx);
            int value = heap.remove(lastIdx);
            lastIdx = heap.size() - 1;
            siftDown(currentIdx, lastIdx, heap);
            return value;
        }

        // O(log(n)) time | O(1) space
        public void insert(int value) {
            // Write your code here.
            heap.add(value);
            int currentIdx = heap.size() - 1;
            siftUp(currentIdx, heap);
            System.out.println();
        }
    }

}
