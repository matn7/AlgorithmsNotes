package july_2025;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElems {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;

        TopKFrequentElems topKFrequentElems = new TopKFrequentElems();
        int[] result = topKFrequentElems.topKFrequent(nums, k);
        System.out.println(result);
    }

    // O(nlog(n)) time | O(n) space
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (Map.Entry<Integer, Integer> elem : freqMap.entrySet()) {
            queue.add(new int[] {elem.getKey(), elem.getValue()});
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll()[0];
        }
        return result;
    }

}
