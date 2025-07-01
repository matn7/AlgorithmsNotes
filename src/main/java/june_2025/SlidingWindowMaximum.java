package june_2025;

import java.util.ArrayDeque;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
//        int[] nums = {1,3,-1,-3,5,3,6,7};
//        int k = 3;

//        int[] nums = {1};
//        int k = 1;

        int[] nums = {1, -1};
        int k = 2;

        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        int[] result = slidingWindowMaximum.maxSlidingWindow(nums, k);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        int[] res = new int[nums.length + 1 - k];

        int l = 0;
        int r = 0;
        int i = 0;

        while (r < nums.length) {
            while (!deque.isEmpty() && nums[r] > nums[deque.getLast()]) {
                deque.removeLast();
            }
            deque.addLast(r);
            if (l > deque.getFirst()) {
                deque.removeFirst();
            }
            if (r + 1 >= k) {
                res[i] = nums[deque.getFirst()];
                l++;
                i++;
            }
            r++;
        }

        return res;
    }

}
