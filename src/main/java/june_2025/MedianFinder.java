package june_2025;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> larger;
    PriorityQueue<Integer> smaller;

    public MedianFinder() {
        smaller = new PriorityQueue<>(Comparator.reverseOrder());
        larger = new PriorityQueue<>();
    }

    // O(m log(n)) time | O(n) space
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
        if (smaller.size() > larger.size() + 1) {
            larger.add(smaller.poll());
        } else if (larger.size() > smaller.size() + 1) {
            smaller.add(larger.poll());
        }
    }

    // O(m) time | O(1) space
    public double findMedian() {
        if (smaller.size() > larger.size()) {
            return smaller.peek();
        } else if (larger.size() > smaller.size()) {
            return larger.peek();
        } else {
            return (smaller.peek() + larger.peek()) / 2.0;
        }
    }

}
