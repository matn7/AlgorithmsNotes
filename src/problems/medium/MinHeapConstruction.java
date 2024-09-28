package problems.medium;

import java.util.ArrayList;
import java.util.List;

public class MinHeapConstruction {

    public static void main(String[] args) {
//        List<Integer> elements = Arrays.asList(13, 8, 6, 9, 12, 11, 7, 15, 10);
//        List<Integer> elements = Arrays.asList(6, 8, 7, 9, 12, 11, 13, 15, 4);
        int[] ints = {48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41};
        List<Integer> elements = new ArrayList<>();

        for (int elem : ints) {
            elements.add(elem);
        }

        MinHeap minHeap = new MinHeap(elements);

        System.out.println();
    }

    static class MinHeap {
        List<Integer> heap = new ArrayList<Integer>();

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        // O(n) time (when run in siftDown) | O(1) space
        // OK - repeated 08/02/2022
        //   0   1   2  3  4   5   6    7   8   9 10 11 12  13
        // [48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41]
        public List<Integer> buildHeap(List<Integer> array) {
            // Write your code here.
            int firstParentIdx = (array.size() - 2) / 2; // (14 - 2) / 2 = 6
            for (int currentIdx = firstParentIdx; currentIdx >= 0; currentIdx--) {
                // siftDown(6, 13, [48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41])
                // siftDown(5, 13, [48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41])
                // siftDown(4, 13, [48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41])
                // siftDown(3, 13, [48, 12, 24, 7, 2, -5, 24, 391, 24, 56, 8, 6, 8, 41])
                // siftDown(2, 13, [48, 12, 24, 7, 2, -5, 24, 391, 24, 56, 8, 6, 8, 41])
                // siftDown(1, 13, [48, 12, -5, 7, 2,  6, 24, 391, 24, 56, 8, 24, 8, 41])
                // siftDown(0, 13, [48,  2, -5, 7,  8,  6, 24, 391, 24, 56, 12, 24, 8, 41])
                siftDown(currentIdx, array.size() - 1, array);
            }
            System.out.println();
            //  [-5,  2,  6, 7,  8, 8, 24, 391, 24, 56, 12, 24, 48, 41]
            return array;
        }

        // O(log(n)) time | O(1) space
        public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
            // Write your code here.
            //                   0   1   2   3   4   5   6    7   8   9  10  11  12  13
            // siftDown(6, 13, [48, 12, 24,  7,  8, -5, 24, 391, 24, 56,  2,  6,  8, 41])
            // siftDown(5, 13, [48, 12, 24,  7,  8, -5, 24, 391, 24, 56,  2,  6,  8, 41])
            // siftDown(4, 13, [48, 12, 24,  7,  2, -5, 24, 391, 24, 56,  8,  6,  8, 41])
            // siftDown(3, 13, [48, 12, 24,  7,  2, -5, 24, 391, 24, 56,  8,  6,  8, 41])
            // siftDown(2, 13, [48, 12, -5,  7,  2,  6, 24, 391, 24, 56,  8, 24,  8, 41])
            // siftDown(1, 13, [48,  2, -5,  7,  8,  6, 24, 391, 24, 56, 12, 24,  8, 41])
            // siftDown(0, 13, [-5,  2,  6,  7,  8,  8, 24, 391, 24, 56, 12, 24, 48, 41])
            //                                                           *
            // siftDown(0, 12, [ 2,  7,  6, 24,  8,  8, 24, 391, 41, 56, 12, 24, 48])
            //                                                    *
            int childOneIdx = currentIdx * 2 + 1; // 0 * 2 + 1 = 1
            int childTwoIdx;
            int idxToSwap;
            while (childOneIdx <= endIdx) { // 11 <= 13
                if (currentIdx * 2 + 2 <= endIdx) { // 5 * 2 + 2 = 12 <= 13
                    childTwoIdx = currentIdx * 2 + 2; // 12
                } else {
                    childTwoIdx = -1;
                }
                if (childTwoIdx != -1 && heap.get(childTwoIdx) < heap.get(childOneIdx)) { // 24 < 8
                    idxToSwap = childTwoIdx;
                } else {
                    idxToSwap = childOneIdx; // 10
                }
                if (heap.get(idxToSwap) < heap.get(currentIdx)) { // 8 < 48
                    swap(currentIdx, idxToSwap, heap);
                    currentIdx = idxToSwap; // 10
                    childOneIdx = currentIdx * 2 + 1; // 10 * 2 + 1 = 21
                } else {
                    // node in correct position
                    break;
                }
            }
        }

        // O(log(n)) time | O(1) space
        public void siftUp(int currentIdx, List<Integer> heap) {
            // Write your code here.
            //              0   1   2   3   4   5   6    7   8   9  10  11  12  13
            //            [-5,  2,  6,  7,  8,  8, 24, 391, 24, 56, 12, 24, 48, 41]
            // siftUp(13, [ 2,  7,  6, 24,  8,  8, 15, 391, 41, 56, 12, 24, 48, 24])
            //                      p               *
            int parentIdx = (currentIdx - 1) / 2; // (13 - 1) / 2 = 6
            while (currentIdx > 0 && heap.get(currentIdx) < heap.get(parentIdx)) { // 15 < 6
                swap(currentIdx, parentIdx, heap);
                currentIdx = parentIdx;
                parentIdx = (currentIdx - 1) / 2; // (6 - 1) / 2 = 2
            }
        }

        public int peek() {
            // Write your code here.
            return heap.get(0);
        }

        public int remove() {
            // Write your code here.
            //   0   1   2  3   4   5   6    7   8   9  10  11  12  13
            // [41,  2,  6, 7,  8,  8, 24, 391, 24, 56, 12, 24, 48, -5]
            swap(0, heap.size() - 1, heap);
            int valueToRemove = heap.remove(heap.size() - 1);
            //   0   1   2  3   4   5   6    7   8   9  10  11  12  13
            // siftDown(0, 12, [41,  2,  6, 7,  8,  8, 24, 391, 24, 56, 12, 24, 48])
            // [ 2,  7,  6, 24,  8,  8, 24, 391, 41, 56, 12, 24, 48]
            siftDown(0, heap.size() - 1, heap);
            return valueToRemove;
        }

        public void insert(int value) {
            // Write your code here.
            heap.add(value); // 15
            // [ 2,  7,  6, 24,  8,  8, 24, 391, 41, 56, 12, 24, 48, 15]
            // [ 2,  7,  6, 24,  8,  8, 15, 391, 41, 56, 12, 24, 48, 24]
            siftUp(heap.size() - 1, heap);
        }

        private void swap(int i, int j, List<Integer> array) {
            int temp = array.get(i);
            array.set(i, array.get(j));
            array.set(j, temp);
            System.out.println();
        }
    }

}
