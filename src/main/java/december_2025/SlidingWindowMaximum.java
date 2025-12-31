package december_2025;

import java.util.ArrayDeque;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        int[] result = slidingWindowMaximum.maxSlidingWindow(nums, k);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!queue.isEmpty() && queue.getFirst()[1] == i - k) {
                queue.removeFirst();
            }

            while (!queue.isEmpty() && queue.getLast()[0] <= nums[i]) {
                queue.removeLast();
            }
            queue.addLast(new int[] {nums[i], i});
            if (i >= k - 1) {
                result[idx] = queue.getFirst()[0];
                idx++;
            }
        }
        return result;
    }

}
