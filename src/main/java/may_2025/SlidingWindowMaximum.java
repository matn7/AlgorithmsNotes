package may_2025;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
//        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] nums = {1,3,1,2,0,5};
        int k = 3;

        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        int[] result = slidingWindowMaximum.maxSlidingWindow(nums, k);
        System.out.println(result);
    }

    // O(n) time | O(k) space
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length + 1 - k];
        int idx = 0;
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (!queue.isEmpty() && i - queue.getFirst()[1] == k) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && queue.getLast()[0] <= curr) {
                queue.pollLast();
            }
            queue.addLast(new int[] {curr, i});
            if (i >= k - 1) {
                result[idx] = queue.getFirst()[0];
                idx++;
            }
        }
        return result;
    }

}
