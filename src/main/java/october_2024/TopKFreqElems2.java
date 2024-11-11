package october_2024;

import java.util.*;

public class TopKFreqElems2 {

    public static void main(String[] args) {
//        int[] nums = {1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 100};
//        int[] nums = {1,1,1,2,2,3};
        int[] nums = {100};
        TopKFreqElems2 topKFreqElems2 = new TopKFreqElems2();
        int[] result = topKFreqElems2.topKFrequent(nums, 1);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<List<Integer>> counts = new ArrayList<>();
        counts.add(new ArrayList<>());
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            counts.add(new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> element : freqMap.entrySet()) {
            Integer key = element.getKey(); // 100
            Integer value = element.getValue(); // 1
            counts.get(value).add(key);
        }

        int[] result = new int[k];
        int index = 0;
        for (int i = counts.size() - 1; i >= 0; i--) {
            if (counts.get(i).size() > 0) {
                int c = 0;
                while (index < k && c < counts.get(i).size()) {
                    result[index] = counts.get(i).get(c);
                    index++;
                    c++;
                }
            }
        }

        return result;
    }
}
