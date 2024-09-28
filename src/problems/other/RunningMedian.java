package problems.other;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RunningMedian {

    public static void main(String[] args) {
        int[] input = {2, 1, 4, 7, 2, 0, 5};

        RunningMedian runningMedian = new RunningMedian();
        runningMedian.running_median(input);
    }

    // O(nlog(n)) time | O(n) space
    public double[] running_median(int[] stream) {
        PriorityQueue<Integer> min_heap = new PriorityQueue<>();
        PriorityQueue<Integer> max_heap = new PriorityQueue<>(Comparator.reverseOrder());
        double[] result = new double[stream.length];
        int counter = 0;
        for (int num : stream) {
            add(num, min_heap, max_heap);
            rebalance(min_heap, max_heap);
            double median = get_median(min_heap, max_heap);
            result[counter] = median;
            counter++;
        }
        return result;
    }

    private void add(int num, PriorityQueue<Integer> min_heap, PriorityQueue<Integer> max_heap) {
        if (min_heap.size() + max_heap.size() <= 1) {
            max_heap.add(num);
            return;
        }

        double median = get_median(min_heap, max_heap);
        if (num > median) {
            min_heap.add(num);
        } else {
            max_heap.add(num);
        }

    }

    private void rebalance(PriorityQueue<Integer> min_heap, PriorityQueue<Integer> max_heap) {
        if (min_heap.size() > max_heap.size() + 1) {
            Integer root = min_heap.poll();
            max_heap.add(root);
        } else if (max_heap.size() > min_heap.size() + 1) {
            Integer root = max_heap.poll();
            min_heap.add(root);
        }
    }

    private double get_median(PriorityQueue<Integer> min_heap, PriorityQueue<Integer> max_heap) {
        if (min_heap.size() > max_heap.size()) {
            return min_heap.peek();
        } else if (min_heap.size() < max_heap.size()) {
            return max_heap.peek();
        } else {
            return (min_heap.peek() + max_heap.peek()) / 2.0;
        }
    }

    // O(nlog(n)) time | O(n) space
    public double[] runningMedian(int[] input) {
        PriorityQueue<Integer> lowerHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> greaterHeap = new PriorityQueue<>();
        // { 2, 0, 0, 0, 0, 0, 0}
        double[] output = new double[input.length];
        int counter = 0;

        //    lower                greater
        //      1                     2

        for (int i = 0; i < input.length; i++) {
            int num = input[i];
            if (lowerHeap.isEmpty()) {
                lowerHeap.add(num);
                output[counter] = num;
            } else {
                Integer peek = lowerHeap.peek(); // 2
                if (peek > num) { // 2 > 1
                    lowerHeap.add(num); // O(log(n))
                } else {
                    greaterHeap.add(num);
                }
                rebalance2(lowerHeap, greaterHeap);  // O(2 * log(n))

                double median = getMedian2(lowerHeap, greaterHeap); // O(1)
                output[counter] = median;

            }
            counter++;
        }
        return output;
    }

    private void rebalance2(PriorityQueue<Integer> lowerHeap, PriorityQueue<Integer> greaterHeap) {
        if (lowerHeap.size() - greaterHeap.size() >= 2) {
            greaterHeap.add(lowerHeap.poll());
        }
        if (greaterHeap.size() - lowerHeap.size() >= 2) {
            lowerHeap.add(greaterHeap.poll());
        }
    }

    private double getMedian2(PriorityQueue<Integer> lowerHeap, PriorityQueue<Integer> greaterHeap) {
        if (lowerHeap.size() > greaterHeap.size()) {
            return lowerHeap.peek();
        } else if (greaterHeap.size() > lowerHeap.size()) {
            return greaterHeap.peek();
        } else {
            return (lowerHeap.peek() + greaterHeap.peek()) / 2.0;
        }
    }

}
