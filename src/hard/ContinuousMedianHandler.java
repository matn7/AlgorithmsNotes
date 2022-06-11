package hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ContinuousMedianHandler {

    public static void main(String[] args) {
        ContinuousMedianHandler medianHandler = new ContinuousMedianHandler();

        medianHandler.insert(5);
        medianHandler.insert(10);
        medianHandler.insert(100);
        medianHandler.insert(50);
        medianHandler.insert(7);

        System.out.println(medianHandler.getMedian());
    }

    double median = 0;
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public void insert(int number) {

        if (maxHeap.isEmpty()) {
            maxHeap.add(number);
        } else {
            Integer currentMax = maxHeap.peek();
            if (number > currentMax) {
                minHeap.add(number);
            } else {
                maxHeap.add(number);
            }
        }

        // rebalance if either maxHeap or minHeap is 2 elements larger ex. (|maxHeap| = 1, |minHeap|=3)
        if (minHeap.size() >= maxHeap.size() + 2) {
            maxHeap.add(minHeap.poll());
        }

        if (maxHeap.size() >= minHeap.size() + 2) {
            minHeap.add(maxHeap.poll());
        }
    }

    public double getMedian() {
        if (maxHeap.size() > minHeap.size()) {
            median = maxHeap.peek();
        } else if (minHeap.size() > maxHeap.size()) {
            median = minHeap.peek();
        } else {
            median = (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        return median;
    }

}
