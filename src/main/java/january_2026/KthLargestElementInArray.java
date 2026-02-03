package january_2026;

import java.util.PriorityQueue;

public class KthLargestElementInArray {

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;

        KthLargestElementInArray kthLargestElementInArray = new KthLargestElementInArray();
        int result = kthLargestElementInArray.findKthLargest(nums, k);
        System.out.println(result);
    }

    // O(nlog(k)) time | O(k) space
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < Math.min(nums.length, k); i++) {
            minHeap.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            Integer curMin = minHeap.peek();
            int num = nums[i];
            if (num > curMin) {
                minHeap.poll();
                minHeap.add(num);
            }
        }
        return minHeap.peek();
    }

    // O(nlog(n)) time | O(n) space
    public int findKthLargest2(int[] nums, int k) {
        int kth = nums.length - k;
        sort(nums, kth);
        return nums[kth];
    }

    private void sort(int[] nums, int kth) {
        quickSelect(nums, 0, nums.length - 1, kth);
    }

    private void quickSelect(int[] nums, int start, int end, int kth) {
        if (start > end) {
            return;
        }
        int pivot = start;
        int s = start + 1;
        int e = end;

        while (s <= e) {
            if (nums[s] >= nums[pivot] && nums[e] <= nums[pivot]) {
                swap(nums, s, e);
            }
            if (nums[s] <= nums[pivot]) {
                s++;
            }
            if (nums[e] >= nums[pivot]) {
                e--;
            }
        }
        swap(nums, pivot, e);
        if (e == kth) {
            return;
        }

        //               (e - 1) p (e + 1)
        // +---------------------*----------+
        // start                           end

        if (e + 1 - start > end - (e + 1)) {
            quickSelect(nums, start, e - 1, kth);
            quickSelect(nums, e + 1, end, kth);
        } else {
            quickSelect(nums, e + 1, end, kth);
            quickSelect(nums, start, e - 1, kth);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }



}
