package march_2025;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};

        MedianOfTwoSortedArrays median = new MedianOfTwoSortedArrays();
        double result = median.findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }

    PriorityQueue<Integer> smaller = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Integer> larger = new PriorityQueue<>();

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0.0;
        }
        addElements(nums1, nums2);
        return getMedian();
    }

    private double getMedian() {
        if (smaller.size() > larger.size()) {
            return smaller.peek();
        } else if (larger.size() > smaller.size()) {
            return larger.poll();
        } else {
            return  (1.0 * smaller.peek() + larger.peek()) / 2;
        }
    }

    private void addElements(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            int curr;
            if (nums1[i] < nums2[j]) {
                curr = nums1[i];
                i++;
            } else {
                curr = nums2[j];
                j++;
            }
            addNumber(curr);
        }
        while (i < nums1.length) {
            int curr = nums1[i];
            i++;
            addNumber(curr);
        }
        while (j < nums2.length) {
            int curr = nums2[j];
            j++;
            addNumber(curr);
        }
    }

    private void addNumber(int curr) {
        if (smaller.isEmpty()) {
            smaller.add(curr);
        } else {
            int peek = smaller.peek();
            if (curr > peek) {
                larger.add(curr);
            } else {
                smaller.add(curr);
            }
            rebalance();
        }
    }

    private void rebalance() {
        if (smaller.size() - larger.size() > 1) {
            larger.add(smaller.poll());
        } else if (larger.size() - smaller.size() > 1) {
            smaller.add(larger.poll());
        }
    }

}
