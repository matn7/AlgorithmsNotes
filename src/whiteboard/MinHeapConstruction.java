package whiteboard;

import java.util.ArrayList;
import java.util.List;

public class MinHeapConstruction {

    public static void main(String[] args) {
        MinHeapConstruction minHeapConstruction = new MinHeapConstruction();
//        int[] elements = {48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41};
        int[] elements = {2, 3, 1};
        List<Integer> array = new ArrayList<>();
        for (int element : elements) {
            array.add(element);
        }

        MinHeap minHeap = new MinHeap(array);

        List<Integer> heap = minHeap.getHeap();
        System.out.println();
    }

    static class MinHeap {
        List<Integer> heap = new ArrayList<Integer>();

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        // O(n) time | O(1) space
        public List<Integer> buildHeap(List<Integer> array) {
            // Write your code here.
            int parentIdx = (array.size() - 2) / 2;
            for (int idx = parentIdx; idx >= 0; idx--) {
                siftDown(idx, array.size() - 1, array);
            }
            return array;
        }

        private void swap(int i, int j, List<Integer> array) {
            int temp = array.get(i);
            array.set(i, array.get(j));
            array.set(j, temp);
        }

        // O(log(n)) time | O(1) space
        public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
            // Write your code here.
            int left = 2 * currentIdx + 1;
            while (left <= endIdx) {
                int right = 2 * currentIdx + 2;
                int idxToSwap;
                if (right < heap.size() && heap.get(right) < heap.get(left)) {
                    idxToSwap = right;
                } else {
                    idxToSwap = left;
                }
                if (heap.get(currentIdx) > heap.get(idxToSwap)) {
                    swap(currentIdx, idxToSwap, heap);
                    currentIdx = idxToSwap;
                    left = 2 * currentIdx + 1;
                } else {
                    break;
                }
            }
        }

        // O(log(n)) time | O(1) space
        public void siftUp(int currentIdx, List<Integer> heap) {
            // Write your code here.
            int value = heap.get(heap.size() - 1);
            int parentIdx = (currentIdx - 1) / 2;
            while (parentIdx >= 0) {
                int element = heap.get(parentIdx);
                if (element > value) {
                    swap(parentIdx, currentIdx, heap);
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
            swap(0, heap.size() - 1, heap);
            Integer removed = heap.remove(heap.size() - 1);

            siftDown(0, 1, heap);

            return removed;
        }

        // O(log(n)) time | O(1) space
        public void insert(int value) {
            // Write your code here.
            heap.add(value);
            int idxToSwap = heap.size() - 1;
            siftUp(idxToSwap, heap);
        }

        public List<Integer> getHeap() {
            return heap;
        }
    }

}
