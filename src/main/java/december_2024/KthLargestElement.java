package december_2024;

import java.util.PriorityQueue;

public class KthLargestElement {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        KthLargestElement kthLargest = new KthLargestElement();
        int result = kthLargest.findKthLargest(nums, k);
        System.out.println(result);
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
        }
        int kth = nums.length - k;
        for (int i = 0; i < kth; i++) {
            minHeap.poll();
        }
        return minHeap.peek();
    }

//    public int findKthLargest(int[] nums, int k) {
//        int kth = nums.length - k;
//        quickSort(nums, 0, nums.length - 1, kth);
//        return nums[kth];
//    }
//
//    private void quickSort(int[] nums, int s, int e, int kth) {
//        if (s > e) {
//            return;
//        }
//        int pivot = s;
//        int start = s + 1;
//        int end = e;
//        while (start <= end) {
//            if (nums[start] >= nums[pivot] && nums[end] <= nums[pivot]) {
//                swap(nums, start, end);
//            }
//            if (nums[start] <= nums[pivot]) {
//                start++;
//            }
//            if (nums[end] >= nums[pivot]) {
//                end--;
//            }
//        }
//        swap(nums, pivot, end);
//        if (end == kth) {
//            return;
//        }
//
//        // s _______ * ____ e
//        //          end
//        if (end - 1 - s > e - (end + 1)) {
//            quickSort(nums, s, end - 1, kth);
//            quickSort(nums, end + 1, e, kth);
//        } else {
//            quickSort(nums, end + 1, e, kth);
//            quickSort(nums, s, end - 1, kth);
//        }
//    }
//
//    private void swap(int[] nums, int i, int j) {
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }

}
