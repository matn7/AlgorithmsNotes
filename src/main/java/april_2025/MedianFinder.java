package april_2025;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
    }

    PriorityQueue<Integer> smaller;
    PriorityQueue<Integer> larger;

    // O(nlog(n)) time | O(n) space
    public MedianFinder() {
        smaller = new PriorityQueue<>(Comparator.reverseOrder());
        larger = new PriorityQueue<>();
    }

    // O(log(n)) time
    public void addNum(int num) {
        if (smaller.isEmpty()) {
            smaller.add(num);
        } else {
            Integer curr = smaller.peek();
            if (num > curr) {
                larger.add(num);
            } else {
                smaller.add(num);
            }
        }
        rebalance();
    }

    // O(2 * log(n)) time
    private void rebalance() {
        if (smaller.size() - larger.size() > 1) {
            larger.add(smaller.poll());
        } else if (larger.size() - smaller.size() > 1) {
            smaller.add(larger.poll());
        }
    }

    // O(1) time
    public double findMedian() {
        if (smaller.isEmpty() && larger.isEmpty()) {
            throw new RuntimeException("No element in heaps");
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
