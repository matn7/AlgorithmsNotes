package january_2025;

import java.util.ArrayDeque;

public class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        int[] output = maxSlidingWindow.maxSlidingWindow(nums, k);
        System.out.println(output);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] output = new int[nums.length - k + 1];
        int i = 0;
        int l = 0;
        int r = 0;

        ArrayDeque<Integer> q = new ArrayDeque<>(); // index

        while (r < nums.length) {
            while (!q.isEmpty() && nums[q.getLast()] < nums[r]) {
                q.removeLast();
            }
            q.addLast(r);

            // remove left val from window
            if (l > q.getFirst()) {
                q.removeFirst();
            }
            if (r + 1 >= k) {
                output[i] = nums[q.getFirst()];
                l++;
                i++;
            }
            r++;
        }
        return output;
    }

}
