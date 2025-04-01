package january_2025;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

//        int[] nums = {1};
//        int k = 1;

        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        int[] result = slidingWindowMaximum.maxSlidingWindow(nums, k);
        System.out.println(result);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];

        Deque<int[]> queue = new ArrayDeque<>();
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (!queue.isEmpty() && i - queue.getFirst()[1] == k) {
                queue.removeFirst();
            }
            while (!queue.isEmpty() && curr >= queue.getLast()[0]) {
                queue.removeLast();
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
