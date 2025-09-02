package august_2025;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.LongAccumulator;

public class MedianFinder {

    // m - function call
    // n - length of array
    PriorityQueue<Integer> smaller;
    PriorityQueue<Integer> larger;

    public MedianFinder() {
        smaller = new PriorityQueue<>(Comparator.reverseOrder());
        larger = new PriorityQueue<>();
    }

    // O(m * log(n)) time | o(n) space
    public void addNum(int num) {
        if (smaller.isEmpty()) {
            smaller.add(num);
        } else {
            int small = smaller.peek();
            if (num > small) {
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

    // O(m) time | O(n) space
    public double findMedian() {
        if (smaller.size() > larger.size()) {
            return smaller.peek();
        } else if (larger.size() > smaller.size()) {
            return larger.peek();
        } else {
            return 1.0 * (smaller.peek() + larger.element()) / 2;
        }
    }

}
