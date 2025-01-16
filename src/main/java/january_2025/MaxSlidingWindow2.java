package january_2025;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxSlidingWindow2 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 0, 4, 2, 6};
        int k = 3;

        MaxSlidingWindow2 maxSlidingWindow2 = new MaxSlidingWindow2();
        int[] ints = maxSlidingWindow2.maxSlidingWindow(nums, k);
        System.out.println(ints);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] output = new int[nums.length + 1 - k];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(new int[] {nums[i], i});
            if (i >= k - 1) {
                while (!maxHeap.isEmpty() && maxHeap.peek()[1] <= i - k) {
                    maxHeap.poll();
                }
                output[j] = maxHeap.peek()[0];
                j++;
            }
        }

        return output;
    }

}
