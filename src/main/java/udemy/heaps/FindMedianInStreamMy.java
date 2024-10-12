package udemy.heaps;

public class FindMedianInStreamMy {

    private static MaxHeap<Integer> smallerHeap = new MaxHeap<>(Integer.class);
    private static MinHeap<Integer> largerHeap = new MinHeap<>(Integer.class);

    public static void main(String[] args) throws Heap.HeapFullException, Heap.HeapEmptyException {
        int[] stream = {5, 6, 7, 9, 10, 2, 3, 13, 15, 17, 20, 1, 8};
        for (int elem : stream) {
            System.out.println(findMedian(elem));
        }
        System.out.println();
    }

    public static double findMedian(int element) throws Heap.HeapFullException, Heap.HeapEmptyException {
        if (smallerHeap.isEmpty()) {
            smallerHeap.insert(element);
        } else {
            Integer top = smallerHeap.getHighestPriority();
            if (element > top) {
                largerHeap.insert(element);
            } else {
                smallerHeap.insert(element);
            }
        }

        rebalance();

        return getMedian();

    }

    private static double getMedian() throws Heap.HeapEmptyException {
        if (smallerHeap.getCount() > largerHeap.getCount()) {
            return smallerHeap.getHighestPriority();
        } else if (largerHeap.getCount() > smallerHeap.getCount()) {
            return largerHeap.getHighestPriority();
        } else {
            int smaller = smallerHeap.getHighestPriority();
            int larger = largerHeap.getHighestPriority();
            return (smaller + larger) / 2;
        }
    }

    private static void rebalance() throws Heap.HeapEmptyException, Heap.HeapFullException {
        if (smallerHeap.getCount() - largerHeap.getCount() >= 2) {
            largerHeap.insert(smallerHeap.removeHighestPriority());
        } else if (largerHeap.getCount() - smallerHeap.getCount() >= 2) {
            smallerHeap.insert(largerHeap.removeHighestPriority());
        }
    }

}
