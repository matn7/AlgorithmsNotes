package october_2024;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();

        medianFinder.addNum(2);
        medianFinder.addNum(3);

        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian());
        System.out.println();
    }

    // O(n) space
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    public MedianFinder() {
        min = new PriorityQueue<>(Comparator.reverseOrder());
        max = new PriorityQueue<>();
    }

    // O(log(n)) time | O(1) space
    public void addNum(int num) {

        if (min.isEmpty()) {
            min.add(num);
        } else {
            Integer topMin = min.peek();
            if (num > topMin) {
                max.add(num);
            } else {
                min.add(num);
            }
        }

        rebalance();
    }

    private void rebalance() {
        if (min.size() < max.size() - 1) {
            min.add(max.poll());
        } else if (max.size() < min.size() - 1) {
            max.add(min.poll());
        }
    }

    // O(1) time | O(1) space
    public double findMedian() {
        if (min.isEmpty()) {
            throw new RuntimeException("");
        }
        if (min.size() > max.size()) {
            return min.peek();
        } else if (min.size() < max.size()) {
            return max.peek();
        } else {
            return (min.peek() + max.peek()) / 2.0;
        }
    }

}
