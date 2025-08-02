package july_2025;

import java.util.PriorityQueue;

public class KthLargest {

    PriorityQueue<Integer> queue;
    int k;

    public KthLargest(int k, int[] nums) {
        this.queue = new PriorityQueue<>();
        this.k = k;

        for (int num : nums) {
            if (queue.size() < k) {
                queue.add(num);
            } else {
                int curr = queue.peek();
                if (curr < num) {
                    queue.poll();
                    queue.add(num);
                }
            }
        }

    }

    public int add(int val) {
        if (queue.size() < this.k) {
            queue.add(val);
        } else {
            int curr = queue.peek();
            if (curr < val) {
                queue.poll();
                queue.add(val);
            }
        }
        return queue.peek();
    }

}
