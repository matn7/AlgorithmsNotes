package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeap {

    static List<Integer> heap = new ArrayList<Integer>();

    public static void main(String[] args) {
//        List<Integer> elements = Arrays.asList(13, 8, 6, 9, 12, 11, 7, 15, 10);
//        List<Integer> elements = Arrays.asList(6, 8, 7, 9, 12, 11, 13, 15, 4);
        List<Integer> elements = Arrays.asList(48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41);

        MinHeap minHeap = new MinHeap(elements);
//        minHeap.siftDown(0, elements.size(), heap);
        minHeap.siftUp(elements.size() - 1, heap);
        System.out.println();
        minHeap.remove();
        System.out.println();
        minHeap.remove();
        System.out.println();
        minHeap.insert(3);
        System.out.println();
    }

    public MinHeap(List<Integer> array) {
        heap = buildHeap(array);
    }

    public List<Integer> buildHeap(List<Integer> array) {
        // Write your code here.
        for (Integer element : array) {
            insert(element);
        }
        return heap;
    }

    public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
        // Write your code here.
        int smallerIdx = -1;
        int leftChildIndex = getLeftChild(currentIdx);
        int rightChildIndex = getRightChildIndex(currentIdx);

        if (leftChildIndex != -1 && rightChildIndex != -1) {
            smallerIdx = heap.get(leftChildIndex) <= heap.get(rightChildIndex) ? leftChildIndex : rightChildIndex;
        } else if (leftChildIndex != -1) {
            smallerIdx = leftChildIndex;
        } else if (rightChildIndex != -1) {
            smallerIdx = rightChildIndex;
        }

        if (smallerIdx == -1) {
            return;
        }

        if (heap.get(smallerIdx) < heap.get(currentIdx)) {
            swap(smallerIdx, currentIdx);
            siftDown(smallerIdx, endIdx, heap);
        }
    }

    public void siftUp(int currentIdx, List<Integer> heap) {
        // Write your code here.
        int parentIndex = getParentIndex(currentIdx);
        if (heap.get(currentIdx) < heap.get(parentIndex)) {
            swap(currentIdx, parentIndex);
            siftUp(parentIndex, heap);
        }
    }

    public int peek() {
        // Write your code here.
        if (heap.isEmpty()) {
            return -1;
        }
        return heap.get(0);
    }

    public int remove() {
        // Write your code here.
        int endIndex = heap.size() - 1;
        int removedElement = peek();
        heap.set(0, heap.get(endIndex));
        heap.remove(endIndex);
        siftDown(0, heap.size() - 1, heap);
        return removedElement;
    }

    public void insert(int value) {
        // Write your code here.
        heap.add(value);
        siftUp(heap.size() -1, heap);
    }

    private void swap(int index1, int index2) {
        Integer temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    private int getLeftChild(int currentIndex) {
        int leftChildIndex = 2 * currentIndex + 1;
        if (leftChildIndex < 0 || leftChildIndex >= heap.size()) {
            return -1;
        }
        return leftChildIndex;
    }

    private int getRightChildIndex(int currentIndex) {
        int rightChildIndex = 2 * currentIndex + 2;
        if (rightChildIndex < 0 || rightChildIndex >= heap.size()) {
            return -1;
        }
        return rightChildIndex;
    }

    private int getParentIndex(int currentIndex) {
        int parentIndex = (currentIndex - 1) / 2;
        if (parentIndex < 0 || parentIndex > heap.size()) {
            return -1;
        }
        return parentIndex;
    }

}
