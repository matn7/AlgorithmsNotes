package hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ContinuousMedian {

    static class ContinuousMedianHandler {
        double median = 0;
        PriorityQueue<Integer> lowers = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> greaters = new PriorityQueue<>();

        // O(log(n)) time | O(n) space
        public void insert(int number) {
            // Write your code here.
            if (lowers.isEmpty() || number < lowers.peek()) {
                lowers.add(number);
            } else {
                greaters.add(number);
            }

            rebalanceHeaps();
            updateMedian();
        }

        private void rebalanceHeaps() {
            if (lowers.size() - greaters.size() == 2) {
                greaters.add(lowers.poll());
            } else if (greaters.size() - lowers.size() == 2) {
                lowers.add(greaters.poll());
            }
        }

        private void updateMedian() {
            if (lowers.size() == greaters.size()) {
                median = (lowers.peek() + greaters.peek()) / 2.0;
            } else if (lowers.size() > greaters.size()) {
                median = lowers.peek();
            } else {
                median = greaters.peek();
            }
        }

        public double getMedian() {
            return median;
        }
    }

}
