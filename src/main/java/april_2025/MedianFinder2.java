package april_2025;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder2 {

    PriorityQueue<Integer> smaller;
    PriorityQueue<Integer> larger;

    // O(nlog(n)) time | O(n) space
    public MedianFinder2() {
        smaller = new PriorityQueue<>(Comparator.reverseOrder());
        larger = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (smaller.isEmpty()) {
            smaller.add(num);
        } else {
            int peek = smaller.peek();
            if (num > peek) {
                larger.add(num);
            } else {
                smaller.add(num);
            }
        }
        rebalance();
    }

    private void rebalance() {
        if (smaller.size() - larger.size() > 1) {
            larger.add(smaller.poll());
        } else if (larger.size() - smaller.size() > 1) {
            smaller.add(larger.poll());
        }
    }

    public double findMedian() {
        if (smaller.isEmpty() && larger.isEmpty()) {
            throw new RuntimeException("Queue empty");
        }
        if (smaller.size() > larger.size()) {
            return smaller.peek();
        } else if (larger.size() > smaller.size()) {
            return larger.peek();
        } else {
            return 1.0 * (smaller.peek() + larger.peek()) / 2;
        }
    }
}
