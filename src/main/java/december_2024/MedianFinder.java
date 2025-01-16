package december_2024;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        medianFinder.addNum(4);

        double median = medianFinder.findMedian();
        System.out.println(median);
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
            Integer maxSmaller = smaller.peek();
            if (num > maxSmaller) {
                larger.add(num);
            } else {
                smaller.add(num);
            }
        }

        rebalance();
    }

    private void rebalance() {
        if (smaller.size() - 1 > larger.size()) {
            larger.add(smaller.poll());
        } else if (larger.size() - 1 > smaller.size()) {
            smaller.add(larger.poll());
        }
    }

    public double findMedian() {
        if (smaller.size() > larger.size()) {
            return (double) smaller.peek();
        } else if (larger.size() > smaller.size()) {
            return (double) larger.peek();
        } else {
            return (smaller.peek() + larger.peek()) / 2.0;
        }
    }

}
