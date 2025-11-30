package november_2025;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

    // O(nlog(n)) time | O(n) space
    PriorityQueue<Integer> lower;
    PriorityQueue<Integer> higher;

    public MedianFinder() {
        lower = new PriorityQueue<>(Comparator.reverseOrder());
        higher = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (lower.isEmpty()) {
            lower.add(num);
        } else {
            int curr = lower.peek();
            if (num < curr) {
                lower.add(num);
            } else {
                higher.add(num);
            }
        }
        rebalance();
    }

    private void rebalance() {
        if (lower.size() - higher.size() > 1) {
            higher.add(lower.poll());
        } else if (higher.size() - lower.size() > 1) {
            lower.add(higher.poll());
        }
    }

    public double findMedian() {
        if (lower.isEmpty()) {
            throw new RuntimeException("Empty");
        }
        if (lower.size() > higher.size()) {
            return lower.peek();
        } else if (higher.size() > lower.size()) {
            return higher.peek();
        } else {
            return (double) (lower.peek() + higher.peek()) / 2;
        }
    }

}
