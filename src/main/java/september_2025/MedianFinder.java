package september_2025;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> lower;
    PriorityQueue<Integer> higher;

    public MedianFinder() {
        lower = new PriorityQueue<>(Comparator.reverseOrder());
        higher = new PriorityQueue<>();
    }

    // O(m * log(n)) time | O(n) space
    // m - num of function calls
    // n - len of array
    public void addNum(int num) {
        if (lower.isEmpty()) {
            lower.add(num);
        } else {
            int curr = lower.peek();
            if (num > curr) {
                higher.add(num);
            } else {
                lower.add(num);
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

    // O(m) time
    public double findMedian() {
        if (lower.isEmpty()) {
            throw new RuntimeException("Empty queues");
        }
        if (lower.size() > higher.size()) {
            return lower.peek();
        } else if (higher.size() > lower.size()) {
            return higher.peek();
        } else {
            return (lower.peek() + higher.peek()) / 2.0;
        }
    }

}
