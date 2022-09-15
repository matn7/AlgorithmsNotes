package udemy.heaps;

public class FindKLargestElements {

    private static int[] randomNumberArray = {5, 8, 6, 12, 9, 1, 13, 15, 2, 4, 80, 11, 3};

    public static void main(String[] args) throws Heap.HeapFullException, Heap.HeapEmptyException {
        int[] stream = {5, 8, 6, 12, 9, 1, 13, 15, 2, 4, 80, 11, 3};
        int k = 5;

        MinHeap<Integer> kLargestElements = findKLargestElementsMy(stream, k);
        printMaximumKElements(k);
    }

    public static void printMaximumKElements(int k) throws Heap.HeapFullException, Heap.HeapEmptyException {
        MinHeap<Integer> minHeap = new MinHeap<>(Integer.class, k);

        for (int number : randomNumberArray) {
            if (minHeap.isEmpty()) {
                minHeap.insert(number);
            } else if (!minHeap.isFull() || minHeap.getHighestPriority() < number) {
                if (minHeap.isFull()) {
                    minHeap.removeHighestPriority();
                }
                minHeap.insert(number);
            }
        }
        minHeap.printHeapArray();
    }

    public static MinHeap<Integer> findKLargestElementsMy(int[] stream, int k) throws Heap.HeapFullException, Heap.HeapEmptyException {
        MinHeap<Integer> heap = new MinHeap<>(Integer.class, k);

        for (int element : stream) {
            if (heap.getCount() < k) {
                heap.insert(element);
            } else {
                Integer topElement = heap.getHighestPriority();
                if (topElement < element) {
                    heap.removeHighestPriority();
                    heap.insert(element);
                }
            }
        }

        return heap;
    }

}
