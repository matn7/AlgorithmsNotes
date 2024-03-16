package november_2023;

import java.util.ArrayList;
import java.util.List;

public class MinHeapConstruction {

    List<Integer> minHeap;

    public static void main(String[] args) {
        int[] arr = {48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41};

        MinHeapConstruction minHeapConstruction = new MinHeapConstruction(arr);
        minHeapConstruction.add(76);
        System.out.println(minHeapConstruction.peek());
        minHeapConstruction.remove();
        System.out.println(minHeapConstruction.peek());
        minHeapConstruction.remove();
        System.out.println(minHeapConstruction.peek());
        minHeapConstruction.add(87);
        System.out.println();

    }

    public MinHeapConstruction(int[] array) {
        minHeap = new ArrayList<>();
        for (int num : array) {
            minHeap.add(num);
        }
        buildMinHeap();
    }

    // O(n) time | O(1) space
    private void buildMinHeap() {
        //   0   1   2  3  4   5   6    7   8   9  10  11  12  13
        // [48, 12, 24, 7, 8, -5, 24, 391, 24, 56,  2,  6,  8, 41]
        int parentIdx = (minHeap.size() - 1 - 1) / 2;
        while (parentIdx >= 0) {
            siftDown(parentIdx);
            parentIdx--;
        }
    }

    // O(log(n)) time | O(1) space
    private void siftDown(int parentIdx) {
        int idx = parentIdx;
        int leftIdx = calcLeftIdx(idx);
        while (leftIdx < minHeap.size() - 1) {
            int idxToSwap;
            int rightIdx = calcRightIdx(idx);
            if (rightIdx > minHeap.size() - 1) {
                rightIdx = -1;
            }
            if (rightIdx != -1 && minHeap.get(leftIdx) < minHeap.get(rightIdx)) {
                idxToSwap = leftIdx;
            } else {
                idxToSwap = rightIdx;
            }
            if (minHeap.get(idx) > minHeap.get(idxToSwap)) {
                swap(idx, idxToSwap);
                idx = idxToSwap;
                leftIdx = calcLeftIdx(idx);
            } else {
                break;
            }
        }
    }

    // O(log(n)) time | O(1) space
    public void add(int value) {
        minHeap.add(value);
        int idx = minHeap.size() - 1;
        shiftUp(idx, value);
    }

    // O(log(n)) time | O(1) space
    private void shiftUp(int idx, int value) {
        while (idx > 0) {
            int parentIdx = calcParentIdx(idx);
            //siftDown(parentIdx);
            Integer parentValue = minHeap.get(parentIdx);
            if (parentValue > value) {
                swap(idx, parentIdx);
            } else {
                break;
            }
            idx = parentIdx;
        }
    }

    // O(log(n)) time | O(1) space
    public int remove() {
        if (minHeap.isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }
        int toRemove = minHeap.get(0);
        swap(0, minHeap.size() - 1);
        minHeap.remove(minHeap.size() - 1);
        siftDown(0);
        return toRemove;
    }

    // O(1) time | O(1) space
    public int peek() {
        if (minHeap.isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }
        return minHeap.get(0);
    }

    public List<Integer> getMinHeap() {
        return minHeap;
    }

    private int calcLeftIdx(int idx) {
        return 2 * idx + 1;
    }

    private int calcRightIdx(int idx) {
        return 2 * idx + 2;
    }

    private int calcParentIdx(int idx) {
        return (idx - 1) / 2;
    }

    private void swap(int i, int j) {
        int temp = minHeap.get(i);
        minHeap.set(i, minHeap.get(j));
        minHeap.set(j, temp);
    }


}
