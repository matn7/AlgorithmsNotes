package january_2026;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder2 {

    // O(log(n)) time | O(n) space
    PriorityQueue<Integer> lower;
    PriorityQueue<Integer> higher;

    public MedianFinder2() {
        lower = new PriorityQueue<>(Comparator.reverseOrder());
        higher = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (lower.isEmpty()) {
            lower.add(num);
        } else {
            int peek = lower.peek();
            if (num > peek) {
                higher.add(num);
            } else {
                lower.add(num);
            }
        }

        rebalance();
    }

    private void rebalance() {
        if (lower.size() - higher.size() >= 2) {
            higher.add(lower.poll());
        } else if (higher.size() - lower.size() >= 2) {
            lower.add(higher.poll());
        }
    }

    public double findMedian() {
        if (lower.size() > higher.size()) {
            return lower.peek();
        } else if (higher.size() > lower.size()) {
            return higher.peek();
        } else {
            return (lower.peek() + higher.peek()) / 2.0;
        }
    }

}
