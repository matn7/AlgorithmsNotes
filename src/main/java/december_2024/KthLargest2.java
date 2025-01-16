package december_2024;

import java.util.PriorityQueue;

public class KthLargest2 {

    private PriorityQueue<Integer> queue;
    int k;

    public KthLargest2(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>();

        for (int num : nums) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
    }

    public int add(int val) {
        queue.offer(val);
        if (queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }

}
