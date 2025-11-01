package october_2025;

import java.util.PriorityQueue;

public class KthLargest {

    // O(n*log(k)) time | O(k) space
    int k;
    PriorityQueue<Integer> queue;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.queue = new PriorityQueue<>();

        for (int num : nums) {
            addElement(num);
        }
    }

    public int add(int val) {
        addElement(val);
        return this.queue.peek();
    }

    private void addElement(int num) {
        if (this.queue.size() < k) {
            this.queue.add(num);
        } else {
            int curr = this.queue.peek();
            if (num > curr) {
                this.queue.poll();
                this.queue.add(num);
            }
        }
    }
}
