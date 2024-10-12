package whiteboard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ContinuousMedian {

    public static void main(String[] args) {
        ContinuousMedianHandler continuousMedianHandler = new ContinuousMedianHandler();
        int[] elements = {5, 10, 100, 200, 6};
        for (int element : elements) {
            continuousMedianHandler.insert(element);
        }
        continuousMedianHandler.getMedian();
    }

    // O(nlog(n)) time | O(n) space
    // #2: 14/06/2022
    static class ContinuousMedianHandler {
        double median = 0;

        PriorityQueue<Integer> smallerHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> greaterHeap = new PriorityQueue<>();

        public void insert(int number) {
            // Write your code here.
            if (smallerHeap.isEmpty()) {
                smallerHeap.add(number);
            } else {
                Integer heapValue = smallerHeap.peek();
                if (heapValue < number) {
                    greaterHeap.add(number);
                } else {
                    smallerHeap.add(number);
                }
            }

            rebalanceHeaps();
        }

        private void rebalanceHeaps() {
            if (smallerHeap.size() - 2 == greaterHeap.size()) {
                greaterHeap.add(smallerHeap.poll());
            }
            if (greaterHeap.size() - 2 == smallerHeap.size()) {
                smallerHeap.add(greaterHeap.poll());
            }
        }

        public double getMedian() {
            if (smallerHeap.size() == greaterHeap.size()) {
                median = (smallerHeap.peek() + greaterHeap.peek()) / 2.0;
            } else if (smallerHeap.size() > greaterHeap.size()) {
                median = smallerHeap.peek();
            } else {
                median = greaterHeap.peek();
            }
            return median;
        }
    }

}
