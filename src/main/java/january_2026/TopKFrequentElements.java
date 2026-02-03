package january_2026;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = {1,2,1,2,1,2,3,1,3,2};
        int k = 2;

//        int[] nums = {4,1,-1,2,-1,2,3};
//        int k = 2;

        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();

        int[] result = topKFrequentElements.topKFrequent(nums, k);
        System.out.println(result);
    }

    // O(nlog(k)) time | O(n) space
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (Map.Entry<Integer, Integer> element : frequencyMap.entrySet()) {
            if (maxHeap.size() < k) {
                maxHeap.add(new int[] {element.getKey(), element.getValue()});
            } else {
                int[] currMax = maxHeap.peek();
                if (element.getValue() > currMax[1]) {
                    maxHeap.poll();
                    maxHeap.add(new int[] {element.getKey(), element.getValue()});
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        int size = maxHeap.size();
        for (int i = 0; i < Math.min(size, k); i++) {
            result.add(maxHeap.poll()[0]);
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }


}
