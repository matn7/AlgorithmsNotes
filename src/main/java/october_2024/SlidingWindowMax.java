package october_2024;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMax {

    public static void main(String[] args) {
//        int[] nums = {1,3,-1,-3,5,3,6,7};
//        int[] nums = {1,3,-1};
        //                 [3,3,5,5,6,7]
        int[] nums = {8, 7, 6, 9};
        int k = 2;

        SlidingWindowMax slidingWindowMax = new SlidingWindowMax();
        int[] result = slidingWindowMax.maxSlidingWindow(nums, k);
        System.out.println(result);
    }

    // leetcode 239

    // O(n) time | O(1) space
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        Deque<Integer> deque = new LinkedList<>();
        int[] output = new int[nums.length - k + 1];

        for (int right = 0; right < nums.length; right++) {
            // Remove elements not within the window
            if (!deque.isEmpty() && deque.peekFirst() < right - k + 1) {
                deque.pollFirst();
            }

            // Maintain decreasing order in the deque
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[right]) {
                deque.pollLast();
            }
            deque.offerLast(right);

            // Record the maximum for the current window
            if (right >= k - 1) {
                output[right - k + 1] = nums[deque.peekFirst()];
            }
        }

        return output;
    }


}
