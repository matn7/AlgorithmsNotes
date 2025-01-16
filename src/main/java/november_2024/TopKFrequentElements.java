package november_2024;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,3,3};
        int k = 2;

        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        int[] ints = topKFrequentElements.topKFrequent(nums, k);
        System.out.println();
    }

    public int[] topKFrequent(int[] nums, int k) {
        List<List<Integer>> counts = new ArrayList<>(nums.length);
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            counts.add(new ArrayList<>());
        }
        for (Map.Entry<Integer, Integer> elem : freqMap.entrySet()) {
            Integer index = elem.getValue() - 1;
            List<Integer> integers = counts.get(index);
            integers.add(elem.getKey());
        }
        int[] res = new int[k];
        int idx = 0;
        for (int i = counts.size() - 1; i >= 0; i--) {
            if (counts.get(i).size() > 0) {
                List<Integer> integers = counts.get(i);
                for (Integer num : integers) {
                    res[idx] = num;
                    idx++;
                }
                if (idx == k) {
                    return res;
                }
            }
        }
        return null;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        for (Map.Entry<Integer, Integer> elem : freqMap.entrySet()) {
            if (queue.size() < k) {
                queue.add(new int[]{elem.getKey(), elem.getValue()});
            } else {
                int[] peek = queue.peek();
                if (elem.getValue() > peek[1]) {
                    queue.poll();
                    queue.add(new int[] {elem.getKey(), elem.getValue()});
                }
            }
        }
        int[] res = new int[k];
        int idx = 0;
        while (!queue.isEmpty()) {
            res[idx] = queue.poll()[0];
            idx++;
        }
        return res;
    }

}
