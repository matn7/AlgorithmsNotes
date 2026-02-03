package january_2026;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> lowerElements;
    PriorityQueue<Integer> higherElements;

    public MedianFinder() {
        lowerElements = new PriorityQueue<>(Comparator.reverseOrder());
        higherElements = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (lowerElements.isEmpty()) {
            lowerElements.add(num);
        } else {
            int lowerTop = lowerElements.peek();
            if (num > lowerTop) {
                higherElements.add(num);
            } else {
                lowerElements.add(num);
            }
        }
        rebalance();
    }
    private void rebalance() {
        if (lowerElements.size() - higherElements.size() >= 2) {
            higherElements.add(lowerElements.poll());
        } else if (higherElements.size() - lowerElements.size() >= 2) {
            lowerElements.add(higherElements.poll());
        }
    }

    public double findMedian() {
        if (lowerElements.size() > higherElements.size()) {
            return lowerElements.peek();
        } else if (higherElements.size() > lowerElements.size()) {
            return higherElements.peek();
        } else {
            return (lowerElements.peek() + higherElements.peek()) / 2.0;
        }
    }

}
