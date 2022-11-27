package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {1,2,3,4};

        FindMedianSortedArrays findMedianSortedArrays = new FindMedianSortedArrays();
        findMedianSortedArrays.findMedianSortedArrays(nums1, nums2);
    }

    // REPEAT Question 4
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0.0;
        }

        PriorityQueue<Integer> smaller = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> larger = new PriorityQueue<>();

        if (nums1.length > 0) {
            for (int i = 0; i <= nums1.length / 2; i++) {
                int value = nums1[i];
                populateQueues(value, smaller, larger);
                rebalance(smaller, larger);
            }
        }

        if (nums2.length > 0) {
            for (int i = 0; i <= nums2.length / 2; i++) {
                int value = nums2[i];
                populateQueues(value, smaller, larger);
                rebalance(smaller, larger);
            }
        }

        if (larger.isEmpty()) {
            return smaller.isEmpty() ? 0.0 : smaller.peek();
        }
        double median = getMedian(smaller, larger);
        return median;
    }

    private double getMedian(PriorityQueue<Integer> smaller, PriorityQueue<Integer> larger) {
        if (larger.isEmpty()) {
            return smaller.peek();
        }
        int small = smaller.peek();
        int large = larger.peek();
        return (small + large) / 2.0;
    }

    private void populateQueues(int value, PriorityQueue<Integer> smaller, PriorityQueue<Integer> larger) {
        if (smaller.isEmpty()) {
            smaller.add(value);
        } else {
            Integer currMax = smaller.peek();
            if (value > currMax) {
                larger.add(value);
            } else {
                smaller.add(value);
            }
        }
    }

    private void rebalance(PriorityQueue<Integer> smaller, PriorityQueue<Integer> larger) {
        if (smaller.size() - 2 == larger.size()) {
            larger.add(smaller.poll());
        } else if (larger.size() - 2 == smaller.size()) {
            smaller.add(larger.poll());
        }
    }

}
