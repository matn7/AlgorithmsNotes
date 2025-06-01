package may_2025;

import java.util.PriorityQueue;

public class FindKthLargest2 {


    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;

        FindKthLargest2 findKthLargest = new FindKthLargest2();
        int result = findKthLargest.findKthLargest(nums, k);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

}
