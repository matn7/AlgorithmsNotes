package january_2025;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOfTwoSortedArraysMy {

    public static void main(String[] args) {
//        int[] nums1 = {1, 3};
//        int[] nums2 = {2};
//        int[] nums1 = {1, 2};
//        int[] nums2 = {1, 2, 3};
        int[] nums1 = {2, 2, 4, 4};
        int[] nums2 = {2, 2, 2, 4, 4};

        MedianOfTwoSortedArraysMy medianOfTwoSortedArrays = new MedianOfTwoSortedArraysMy();
        double medianSortedArrays = medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder()); // minValues
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // maxValues

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        }
        int i = 0;
        int j = nums2.length - 1;
        while (i < nums1.length && j >= 0) {
            maxHeap.add(nums1[i]);
            minHeap.add(nums2[j]);
            i++;
            j--;
            rebalance();
        }
        while (i < nums1.length) {
            maxHeap.add(nums1[i]);
            i++;
            rebalance();
        }
        while (j >= 0) {
            minHeap.add(nums2[j]);
            j--;
            rebalance();
        }
        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
    }

    private void rebalance() {
        if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.add(minHeap.poll());
        } else if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        }
        if (!minHeap.isEmpty() && !maxHeap.isEmpty()) {
            if (maxHeap.peek() > minHeap.peek()) {
                minHeap.add(maxHeap.poll());
                maxHeap.add(minHeap.poll());
            } else if (minHeap.peek() > maxHeap.peek()) {
                maxHeap.add(minHeap.poll());
                minHeap.add(maxHeap.poll());
            }
        }
    }

}
