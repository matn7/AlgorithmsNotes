package november_2025;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class SortAKSortedArray {

    public ArrayList<Integer> sort_a_k_sorted_array(ArrayList<Integer> nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int num : nums) {
            if (minHeap.size() + 1 < k) {
                minHeap.add(num);
            } else {
                result.add(minHeap.poll());
                minHeap.add(num);
            }
        }
        while (minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        return result;
    }

}
