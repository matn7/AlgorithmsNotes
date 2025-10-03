package september_2025;

import java.util.ArrayDeque;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,2,3,6,7};
        int k = 1;

        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        int[] result = slidingWindowMaximum.maxSlidingWindow(nums, k);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int idx = 0;
        ArrayDeque<int[]> queue = new ArrayDeque<>(); // <num, idx>

        for (int i = 0; i < nums.length; i++) {
            // add to end of the queue
            while (!queue.isEmpty() && nums[i] > queue.getLast()[0]) {
                queue.removeLast();
            }
            queue.addLast(new int[] {nums[i], i});
            // check whether we need to remove element from front of queue
            int firstIdx = queue.getFirst()[1];
            if (i - k == firstIdx) {
                queue.removeFirst();
            }
            if (i >= k - 1) {
                int[] first = queue.getFirst();
                res[idx] = first[0];
                idx++;
            }
        }
        for (int i = idx; i < res.length; i++) {
            res[i] = queue.getFirst()[0];
        }
        return res;
    }

}
