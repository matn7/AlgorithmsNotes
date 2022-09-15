package udemy.heaps;

public class FindMaxInMinHeap {

    public static void main(String[] args) throws Heap.HeapFullException {
        MinHeap<Integer> minHeap = new MinHeap<>(Integer.class);
        int[] elements = {5, 8, 6, 9, 12, 11, 7, 15, 10};
        for (int element : elements) {
            minHeap.insert(element);
        }

        int result = findMinElementMy(minHeap);
        int resultMy = findMinElementMy(minHeap);
        System.out.println();
    }

    public static int getMaximum(MinHeap<Integer> minHeap) {
        int lastIndex = minHeap.getCount() - 1;
        int lastParentIndex = minHeap.getParentIndex(lastIndex);

        int firstChildIndex = lastParentIndex + 1;

        int maxElement = minHeap.getElementAtIndex(firstChildIndex);
        for (int i = firstChildIndex; i <= lastIndex; i++) {
            if (maxElement < minHeap.getElementAtIndex(i)) {
                maxElement = minHeap.getElementAtIndex(i);
            }
        }

        return maxElement;
    }

    public static int findMinElementMy(MinHeap<Integer> minHeap) {
        if (minHeap.isEmpty()) {
            return Integer.MIN_VALUE;
        }

        int size = minHeap.getCount() - 1;
        int parentIndex = minHeap.getParentIndex(size);
        int maxElement = Integer.MIN_VALUE;
        for (int i = parentIndex + 1; i < size; i++) {
            int curr = minHeap.getElementAtIndex(i);
            if (curr > maxElement) {
                maxElement = curr;
            }
        }
        return maxElement;
    }

}
