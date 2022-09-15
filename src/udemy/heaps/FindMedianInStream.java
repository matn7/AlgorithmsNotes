package udemy.heaps;

public class FindMedianInStream {

    private static MinHeap<Integer> minHeap = new MinHeap<>(Integer.class);
    private static MaxHeap<Integer> maxHeap = new MaxHeap<>(Integer.class);

    public static void main(String[] args) throws Heap.HeapFullException, Heap.HeapEmptyException {
        int[] stream = {5, 6, 7, 9, 10, 2, 3, 13, 15, 17, 20, 1, 8};
        for (int elem : stream) {
            System.out.println(getStreamingMedian(elem));
        }
        System.out.println();
    }

    public static double getStreamingMedian(int number) throws Heap.HeapFullException, Heap.HeapEmptyException {
        if (!maxHeap.isEmpty() && number > maxHeap.getHighestPriority()) {
            minHeap.insert(number);
        } else {
            maxHeap.insert(number);
        }

        if (maxHeap.getCount() > minHeap.getCount() + 1) {
            minHeap.insert(maxHeap.removeHighestPriority());
        } else if (minHeap.getCount() > maxHeap.getCount() + 1) {
            maxHeap.insert(minHeap.removeHighestPriority());
        }

        if (maxHeap.getCount() == minHeap.getCount()) {
            return 0.5 * (maxHeap.getHighestPriority() + minHeap.getHighestPriority());
        }

        return minHeap.getCount() > maxHeap.getCount()
                ? minHeap.getHighestPriority() : maxHeap.getHighestPriority();
    }

}
