package august_2025;

import java.util.PriorityQueue;

public class KthLargest {

    // O(m * log(k)) time | O(k) space
    PriorityQueue<Integer> queue;
    int k;

    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (queue.size() < k) {
            queue.add(val);
        } else {
            int curr = queue.peek();
            if (val > curr) {
                queue.poll();
                queue.add(val);
            }
        }
        return queue.peek();
    }


}
