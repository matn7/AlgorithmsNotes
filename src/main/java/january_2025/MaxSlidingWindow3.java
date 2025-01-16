package january_2025;

import java.util.ArrayDeque;

public class MaxSlidingWindow3 {

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        MaxSlidingWindow3 maxSlidingWindow3 = new MaxSlidingWindow3();
        maxSlidingWindow3.maxSlidingWindow(nums, k);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] output = new int[nums.length + 1 - k];
        int j = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {

            while (!queue.isEmpty() && nums[queue.getLast()] <= nums[i]) {
                queue.removeLast();
            }
            queue.addLast(i);

            if (queue.getFirst() - i > k) {
                queue.removeFirst();
            }

            if (i + 1 >= k) {
                output[j] = nums[queue.getFirst()];
                j++;
            }

        }

        return output;

    }


}
