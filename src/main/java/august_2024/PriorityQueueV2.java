package august_2024;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueV2<T extends Number & Comparable<T>> {

    private final List<T> queue;
    private final Comparator<? super T> comparator;

    public PriorityQueueV2(List<T> arr) {
        this(arr, Comparator.naturalOrder());
    }

    public PriorityQueueV2(List<T> arr, Comparator<? super T> comparator) {
        this.comparator = comparator;
        this.queue = arr;
    }

    private void siftUp(int currentIdx) {
        int parentIdx = (currentIdx - 1) / 2;
        while (comparator.compare(queue.get(currentIdx), queue.get(parentIdx)) < 0) {
            swap(currentIdx, parentIdx);
            currentIdx = parentIdx;
            parentIdx = (currentIdx - 1) / 2;
        }
    }

    private void swap(int i, int j) {
        T temp = queue.get(i);
        queue.set(i, queue.get(j));
        queue.set(j, temp);

    }

}
