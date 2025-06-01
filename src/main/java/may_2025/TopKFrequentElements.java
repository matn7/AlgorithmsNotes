package may_2025;

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

    // O(k * log(n)) + O(n) time | O(n) space
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];

        // O(n) time
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1); // { [num, freq] }
        }

        // { [freq : num] }
        // O(k * log(n)) time
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (Map.Entry<Integer, Integer> elem : freqMap.entrySet()) {
            queue.add(new int[] {elem.getValue(), elem.getKey()});
        }

        int idx = 0;
        while (!queue.isEmpty() && k > 0) {
            int[] current = queue.poll();
            result[idx] = current[1];
            idx++;
            k--;
        }

        return result;
    }

}
