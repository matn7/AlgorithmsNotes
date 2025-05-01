package april_2025;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        int[] result = topKFrequentElements.topKFrequent(nums, k);
        System.out.println(result);
    }

    // O(k * log(n)) + O(n)  time | O(n) space
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        // O(n) t | O(n) s
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // O(n) t | O(k) s
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (Map.Entry<Integer, Integer> elem : freqMap.entrySet()) {
            int[] curr = new int[] {elem.getKey(), elem.getValue()};
            queue.add(curr);
        }

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            int[] current = queue.poll();
            result[i] = current[0];
        }
        return result;
    }

}
