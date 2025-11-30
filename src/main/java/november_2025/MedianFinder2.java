package november_2025;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder2 {

    // O(log(n)) time | O(n) space
    PriorityQueue<Integer> smaller;
    PriorityQueue<Integer> larger;

    public MedianFinder2() {
        smaller = new PriorityQueue<>(Comparator.reverseOrder());
        larger = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (smaller.isEmpty()) {
            smaller.add(num);
        } else {
            int curr = smaller.peek();
            if (num > curr) {
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
        if (smaller.size() > larger.size()) {
            return smaller.peek();
        } else if (larger.size() > smaller.size()) {
            return larger.peek();
        } else {
            return (smaller.peek() + larger.peek()) / 2;
        }
    }

}
