package december_2024;

import java.util.PriorityQueue;

public class KthLargest {

    PriorityQueue<Integer> queue;
    int k;
    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            if (queue.size() < k) {
                queue.add(num);
            } else {
                Integer peek = queue.peek();
                if (peek < num) {
                    queue.poll();
                    queue.add(num);
                }
            }
        }
    }

    public int add(int val) {
        if (queue.size() < k) {
            queue.add(val);
        } else {
            Integer peek = queue.peek();
            if (peek < val) {
                queue.poll();
                queue.add(val);
            }
        }
        return queue.peek();
    }

}
