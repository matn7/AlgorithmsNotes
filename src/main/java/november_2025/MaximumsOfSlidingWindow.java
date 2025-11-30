package november_2025;

import java.util.ArrayDeque;

public class MaximumsOfSlidingWindow {

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        MaximumsOfSlidingWindow maximumsOfSlidingWindow = new MaximumsOfSlidingWindow();
        int[] res = maximumsOfSlidingWindow.maxSlidingWindow(nums, k);
        System.out.println(res);
    }

    // O(n) time | O(n) space
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // remove overflow
            if (!queue.isEmpty() && queue.getFirst()[1] == i - k) {
                queue.removeFirst();
            }

            // add to back
            while (!queue.isEmpty() && queue.getLast()[0] <= num) {
                queue.removeLast();
            }
            queue.addLast(new int[] {num, i});
            if (i >= k - 1) {
                res[idx] = queue.getFirst()[0];
                idx++;
            }
        }
        return res;
    }

}
