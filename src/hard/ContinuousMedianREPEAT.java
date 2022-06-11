package hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ContinuousMedianREPEAT {

    public static void main(String[] args) {
        // lower half: max heap
        // greater half: min heap
        ContinuousMedianHandler continuousMedianHandler = new ContinuousMedianHandler();

        continuousMedianHandler.insert(5);
        continuousMedianHandler.insert(10);
        continuousMedianHandler.insert(50);
        continuousMedianHandler.insert(100);
        continuousMedianHandler.insert(110);

        double result = continuousMedianHandler.getMedian();
        System.out.println(result);
    }

    static class ContinuousMedianHandler {
        double median = 0;
        PriorityQueue<Integer> lowers = new PriorityQueue<>(Comparator.reverseOrder()); // lower half
        PriorityQueue<Integer> greaters = new PriorityQueue<>(); // greater half

        // LOWER                GREATER
        //   10                    50
        //  /                     /  \
        // 5                    100  110
        // O(log(n)) time | O(n) space
        // OK - repeated 26/01/2022
        public void insert(int number) {
            // Write your code here.
            if (lowers.isEmpty()) {
                lowers.add(number); // 5
            } else {
                Integer lowerHalfMax = lowers.peek();
                if (number > lowerHalfMax) {
                    greaters.add(number);
                } else {
                    lowers.add(number);
                }
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

        // O(1) time | O(1) space
        public double getMedian() {
            return median;
        }
    }
}
