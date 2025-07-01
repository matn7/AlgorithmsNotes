package june_2025;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum2 {

    public static void main(String[] args) {
//        int[] nums = {1,3,-1,-3,5,3,6,7};
//        int k = 3;

//        int[] nums = {1};
//        int k = 1;

        int[] nums = {1,3,1,2,0,5};
        int k = 3;

        SlidingWindowMaximum2 slidingWindowMaximum2 = new SlidingWindowMaximum2();
        int[] result = slidingWindowMaximum2.maxSlidingWindow(nums, k);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<int[]> queue = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (!queue.isEmpty() && i - k == queue.getFirst()[1]) {
                queue.removeFirst();
            }

            while (!queue.isEmpty() && queue.getLast()[0] <= num) {
                queue.removeLast();
            }
            queue.addLast(new int[] {num, i});

            if (i >= k - 1) {
                result[idx] = queue.getFirst()[0];
                idx++;
            }
        }
        return result;
    }

}
