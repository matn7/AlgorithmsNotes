package february_2024;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MinHeapConstruction {

    public static void main(String[] args) {
        int[] ints = {48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41};
        List<Integer> elements = new ArrayList<>();

        for (int elem : ints) {
            elements.add(elem);
        }

        MinHeapConstruction minHeapConstruction = new MinHeapConstruction(elements);

        minHeapConstruction.add(890);
        minHeapConstruction.add(-98);

        int remove = minHeapConstruction.remove();
        int remove1 = minHeapConstruction.remove();
        int remove2 = minHeapConstruction.remove();

        System.out.println(minHeapConstruction);
    }

    List<Integer> heap = new ArrayList<>();

    public MinHeapConstruction(List<Integer> array) {
        this.heap = buildHeap(array);
    }

    public int peek() {
        if (heap.isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }
        return heap.get(0);
    }

    public int add(int value) {
        heap.add(value);
        siftUp(heap.size() - 1, heap);
        return value;
    }

    public int remove() {
        swap(0, heap.size() - 1, heap);
        Integer removed = heap.remove(heap.size() - 1);
        siftDown(0, heap.size() - 1, heap);
        return removed;
    }

    // O(n) time | O(1) space
    private List<Integer> buildHeap(List<Integer> array) {
        int firstParentIndex = getParentIdx(array.size() - 1);
//        for (int currIdx = firstParentIndex; currIdx >= 0; currIdx--) {
//            siftDown(currIdx, array.size() - 1, array);
//        }
//        IntStream intStream = IntStream.rangeClosed(firstParentIndex, 0).map(i -> -i + firstParentIndex - 1);
//        intStream.forEach(System.out::println);
        IntStream.range(0, firstParentIndex)
                .map(i -> -i + firstParentIndex - 1).forEach(
                currIdx -> {
                    siftDown(currIdx, array.size() - 1, array);
                }
        );
        return array;
    }

    // O(log(n)) time | O(1) space
    private void siftDown(int currIdx, int endIdx, List<Integer> array) {
        int firstChildIdx = getFirstChildIdx(currIdx);
        while (firstChildIdx <= endIdx) {
            int secondChildIdx = getSecondChildIdx(currIdx);
            int idxToSwap;
            if (secondChildIdx <= endIdx && array.get(secondChildIdx) < array.get(firstChildIdx)) {
                idxToSwap = secondChildIdx;
            } else {
                idxToSwap = firstChildIdx;
            }
            if (array.get(idxToSwap) < array.get(currIdx)) {
                swap(idxToSwap, currIdx, array);
                currIdx = idxToSwap;
                firstChildIdx = getFirstChildIdx(currIdx);
            } else {
                break;
            }
        }
    }

    // O(log(n)) time | O(1) space
    private void siftUp(int currIdx, List<Integer> array) {
        int parentIdx = getParentIdx(currIdx);
        while (currIdx > 0 && array.get(parentIdx) > array.get(currIdx)) {
            swap(currIdx, parentIdx, array);
            currIdx = parentIdx;
            parentIdx = (currIdx - 1) / 2;
        }
    }

    private static int getSecondChildIdx(int currIdx) {
        return currIdx * 2 + 2;
    }

    private static int getFirstChildIdx(int currIdx) {
        return currIdx * 2 + 1;
    }

    private static int getParentIdx(int currIdx) {
        return (currIdx - 1) / 2;
    }


    private void swap(int i, int j, List<Integer> array) {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }
}
