package september_2025;

import java.util.PriorityQueue;

public class KthLargest {

    public static void main(String[] args) {
        int[] nums = {4, 5, 8, 2};
        int k = 3;
        KthLargest kthLargest = new KthLargest(k, nums);

        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));

    }

    // O(nlog(k)) time | O(k) space
    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.add(val);
        } else {
            Integer curr = minHeap.peek();
            if (val > curr) {
                minHeap.poll();
                minHeap.add(val);
            }
        }
        return minHeap.peek();
    }

}
