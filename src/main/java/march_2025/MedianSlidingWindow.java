package march_2025;

import org.mockito.InOrder;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class MedianSlidingWindow {

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        MedianSlidingWindow medianSlidingWindow = new MedianSlidingWindow();
        double[] doubles = medianSlidingWindow.medianSlidingWindow(nums, k);
        System.out.println(doubles);
    }
    PriorityQueue<int[]> smaller;
    PriorityQueue<int[]> larger;
    HashMap<Integer, Integer> delayed;

    public double[] medianSlidingWindow(int[] nums, int k) {
        smaller = new PriorityQueue<>((a, b) -> b[0] - a[0]);  // Max-heap
        larger = new PriorityQueue<>((a, b) -> a[0] - b[0]);   // Min-heap
        delayed = new HashMap<>();  // To track elements out of the window

        double[] result = new double[nums.length - k + 1];
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {
            // Add the current element into the correct heap
            if (smaller.isEmpty() || nums[i] <= smaller.peek()[0]) {
                smaller.add(new int[] {nums[i], i});
            } else {
                larger.add(new int[] {nums[i], i});
            }

            // Rebalance heaps to maintain the size property
            rebalance();

            // Remove elements outside the window from the heaps
            if (i >= k) {
                remove(nums[i - k], i - k);
            }

            // Store the median for the current window
            if (i >= k - 1) {
                result[idx++] = getMedian();
            }
        }

        return result;
    }

    // Rebalance the heaps if their sizes differ too much
    private void rebalance() {
        if (smaller.size() > larger.size() + 1) {
            larger.add(smaller.poll());
        } else if (larger.size() > smaller.size()) {
            smaller.add(larger.poll());
        }
    }

    // Get the current median from the heaps
    private double getMedian() {
        if (smaller.size() > larger.size()) {
            return smaller.peek()[0];
        } else {
            return (smaller.peek()[0] + larger.peek()[0]) / 2.0;
        }
    }

    // Remove elements that are out of the current window
    private void remove(int num, int index) {
        delayed.put(index, delayed.getOrDefault(index, 0) + 1);

        // Keep removing elements from the top of the heaps if they are delayed
        while (!smaller.isEmpty() && delayed.containsKey(smaller.peek()[1])) {
            delayed.put(smaller.peek()[1], delayed.get(smaller.peek()[1]) - 1);
            if (delayed.get(smaller.peek()[1]) == 0) {
                delayed.remove(smaller.peek()[1]);
            }
            smaller.poll();
        }
        while (!larger.isEmpty() && delayed.containsKey(larger.peek()[1])) {
            delayed.put(larger.peek()[1], delayed.get(larger.peek()[1]) - 1);
            if (delayed.get(larger.peek()[1]) == 0) {
                delayed.remove(larger.peek()[1]);
            }
            larger.poll();
        }
    }

}
