package december_2025;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

    // O(log(n)) time | O(n) space
    PriorityQueue<Integer> larger;
    PriorityQueue<Integer> smaller;

    public MedianFinder() {
        larger = new PriorityQueue<>(Comparator.reverseOrder());
        smaller = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (larger.isEmpty()) {
            larger.add(num);
        } else {
            int maximumSmall = larger.peek();
            if (num > maximumSmall) {
                smaller.add(num);
            } else {
                larger.add(num);
            }
        }
        rebalance();
    }

    public double findMedian() {
        if (smaller.size() > larger.size()) {
            return smaller.peek();
        } else if (larger.size() > smaller.size()) {
            return larger.peek();
        } else {
            return (smaller.peek() + larger.peek()) / 2.0;
        }
    }

    private void rebalance() {
        if (smaller.size() > larger.size() + 1) { // 3 > 1 + 1
            larger.add(smaller.poll());
        } else if (larger.size() > smaller.size() + 1) {
            smaller.add(larger.poll());
        }
    }

}
