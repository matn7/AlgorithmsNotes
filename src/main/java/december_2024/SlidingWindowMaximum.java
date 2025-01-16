package december_2024;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

//        int[] nums = {1, 1, 1, 1, 1, 4, 5};
//        int k = 6;


        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        int[] res = slidingWindowMaximum.maxSlidingWindow(nums, k);
        System.out.println(res);
    }

    // ********
    // * STAR *
    // ********

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
