package july_2025;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMax {

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        SlidingWindowMax slidingWindowMax = new SlidingWindowMax();
        int[] result = slidingWindowMax.maxSlidingWindow(nums, k);
        System.out.println(result);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<int[]> dequeue = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!dequeue.isEmpty() && dequeue.getFirst()[1] == i - k) {
                dequeue.removeFirst();
            }
            int num = nums[i];
            while (!dequeue.isEmpty() && dequeue.getLast()[0] < num) {
                dequeue.removeLast();
            }
            dequeue.addLast(new int[] {num, i});
            if (i >= k - 1) {
                res[idx] = dequeue.getFirst()[0];
                idx++;
            }
        }
        return res;
    }


}
