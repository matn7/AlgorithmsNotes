package june_2025;

import java.util.PriorityQueue;

public class KthLargest {

    PriorityQueue<Integer> queue;
    int k;

    public KthLargest(int k, int[] nums) {
        this.queue = new PriorityQueue<>();
        this.k = k;

        for (int num : nums) {
            addElem(num);
        }
    }

    public int add(int val) {
        addElem(val);
        return this.queue.peek();
    }

    private void addElem(int num) {
        if (this.queue.size() < k) {
            this.queue.add(num);
        } else {
            int peek = this.queue.peek();
            if (num > peek) {
                this.queue.poll();
                this.queue.add(num);
            }
        }
    }

}
