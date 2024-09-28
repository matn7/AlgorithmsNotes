package july_2024;

import java.util.ArrayList;
import java.util.List;

public class MinHeapConstruction {

    public static void main(String[] args) {
        int[] nums = {1, 67, 54, 9, 0, 12, 345, 12, 349, 778, 99, 7, -14, 78};
        List<Integer> array = new ArrayList<>();
        for (int num : nums) {
            array.add(num);
        }
        MinHeapConstruction minHeap = new MinHeapConstruction(array);
        minHeap.add(-28);

        minHeap.poll();

        minHeap.add(-2);
        System.out.println();
    }

    // [1, 67, 54, 9, 0, 12, 345, 12, 349, 778, 99, 7, -14, 78]
    List<Integer> heap;

    public MinHeapConstruction(List<Integer> array) {
        heap = new ArrayList<>(array);
        generateHeap();
    }

    private void generateHeap() {
        //  0  1   2   3  4   5   6   7    8    9  10  11   12  13
        // [1, 67, 54, 9, 0, 12, 345, 12, 349, 778, 99, 7, -14, 78]
        //                        *
        int lastIdx = heap.size() - 1; // 13
        int parentIdx = parentIdx(lastIdx); // 6

        for (int idx = parentIdx; idx >= 0; idx--) {
            siftDown(idx);
        }
    }

    private void siftDown(int idx) {
        int leftIdx = leftChildIdx(idx); // 12
        while (leftIdx < heap.size()) {
            int idxToSwap;
            int rightIdx = rightChildIdx(idx); // 13
            if (rightIdx >= heap.size()) {
                rightIdx = -1;
            }
            if (rightIdx != -1 && heap.get(rightIdx) < heap.get(leftIdx)) {
                idxToSwap = rightIdx;
            } else {
                idxToSwap = leftIdx;
            }
            if (heap.get(idxToSwap) < heap.get(idx)) {
                swap(idxToSwap, idx);
                idx = idxToSwap;
                leftIdx = leftChildIdx(idx);
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // add
    public void add(int value) {
        //   0   1  2  3   4   5   6   7    8    9  10  11  12   13   14
        // [-14, 0, -28, 9, 67, 7, 1, 12, 349, 778, 99, 54, 12, 345, 78]
        //           i             p
        heap.add(value);
        int idx = heap.size() - 1;
        int parentIdx = parentIdx(idx);

        while (parentIdx >= 0) {
            if (heap.get(idx) < heap.get(parentIdx)) { // -28 < 1
                swap(idx, parentIdx);
                idx = parentIdx; // 6
                parentIdx = parentIdx(idx); // 2
            } else {
                break;
            }
        }

    }

    // poll
    public int poll() {
        if (heap.isEmpty()) {
            throw new RuntimeException("Heap is Empty!");
        }
        int toRemove = heap.get(0);
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        siftDown(0);
        return toRemove;
    }
    // peek
    public int peek() {
        if (heap.isEmpty()) {
            throw new RuntimeException("Heap is Empty!");
        }
        return heap.get(0);
    }

    // left child
    private int leftChildIdx(int idx) {
        return 2 * idx + 1;
    }

    // right child
    private int rightChildIdx(int idx) {
        return 2 * idx + 2;
    }

    // parent
    private int parentIdx(int idx) {
        return (idx - 1) / 2;
    }

}
