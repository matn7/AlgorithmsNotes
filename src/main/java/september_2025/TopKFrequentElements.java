package september_2025;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;

        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        int[] result = topKFrequentElements.topKFrequent(nums, k);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int[] topKFrequent(int[] nums, int k) {
        // O(n) time | O(n) space
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < nums.length + 1; i++) {
            buckets.add(new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> elem : freqMap.entrySet()) {
            int idx = elem.getValue();
            buckets.get(idx).add(elem.getKey());
        }
        int idx = 0;
        int[] result = new int[k];
        for (int i = nums.length; i >= 0; i--) {
            List<Integer> bucket = buckets.get(i);
            if (bucket.isEmpty()) {
                continue;
            }
            for (Integer num : bucket) {
                result[idx] = num;
                idx++;
                if (idx == k) {
                    return result;
                }
            }
        }
        return null;
    }

    // O(nlog(n)) time | O(n) space
    public int[] topKFrequent2(int[] nums, int k) {
        // O(n) time | O(n) space
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // {1 : 3, 2 : 2, 1 : 3}

        // PriorityQueue: [[1, 3], [2, 2], [3, 1]] - compare elements by (a, b) -> b[1] - a[1] - max priority queue
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        // O(n * log(n)) time | O(n) space - heapify is O(n) ?
        for (Map.Entry<Integer, Integer> elem : freqMap.entrySet()) {
            maxHeap.add(new int[] {elem.getKey(), elem.getValue()});
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) { // Math.min(maxHeap.size(), k)
            int[] current = maxHeap.poll();
            result[i] = current[0];
        }
        return result;
    }


}
