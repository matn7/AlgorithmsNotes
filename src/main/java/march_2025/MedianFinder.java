package march_2025;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);

        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }

    PriorityQueue<Integer> smaller;
    PriorityQueue<Integer> larger;

    public MedianFinder() {
        smaller = new PriorityQueue<>(Comparator.reverseOrder());
        larger = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (smaller.isEmpty()) {
            smaller.add(num);
        } else {
            Integer maxSmall = smaller.peek();
            if (num < maxSmall) {
                smaller.add(num);
            } else {
                larger.add(num);
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
            return (1.0 * smaller.peek() + 1.0 * larger.peek()) / 2;
        }
    }

}
