package january_2026;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMedian {

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        slidingWindowMedian.medianSlidingWindow(nums, k);
    }


    public double[] medianSlidingWindow(int[] nums, int k) {

        PriorityQueue<int[]> lower = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0])); // max-heap
        PriorityQueue<int[]> higher = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0])); // min-heap
        double[] result = new double[nums.length - k + 1];
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {
            addElement(nums[i], i, lower, higher);

            if (i >= k) {
                removeOutdated(i - k, lower, higher);
            }

            if (i >= k - 1) {
                result[idx++] = getMedian(lower, higher);
            }
        }

        return result;
    }

    private double getMedian(PriorityQueue<int[]> lower, PriorityQueue<int[]> higher) {
        if (lower.size() > higher.size()) {
            return lower.peek()[0];
        } else if (higher.size() > lower.size()) {
            return higher.peek()[0];
        } else {
            return ((double) lower.peek()[0] + (double) higher.peek()[0]) / 2.0;
        }
    }

    private void addElement(int num, int i, PriorityQueue<int[]> lower, PriorityQueue<int[]> higher) {
        int[] elem = new int[]{num, i};
        if (lower.isEmpty() || num <= lower.peek()[0]) {
            lower.add(elem);
        } else {
            higher.add(elem);
        }
        rebalance(lower, higher);
    }

    private void rebalance(PriorityQueue<int[]> lower, PriorityQueue<int[]> higher) {
        if (lower.size() > higher.size() + 1) {
            higher.add(lower.poll());
        } else if (higher.size() > lower.size() + 1) {
            lower.add(higher.poll());
        }
    }

    private void removeOutdated(int outdatedIndex, PriorityQueue<int[]> lower, PriorityQueue<int[]> higher) {
        lower.removeIf(e -> e[1] == outdatedIndex);
        higher.removeIf(e -> e[1] == outdatedIndex);
        rebalance(lower, higher);
    }

}
