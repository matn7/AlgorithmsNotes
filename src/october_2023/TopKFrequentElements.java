package october_2023;

import com.sun.jdi.IntegerType;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3, 8, 8, 8, 2, 1, 8, 8, 3};

        List<Integer> result = topKFrequentElements(nums, 3);
        System.out.println(result);
    }

    // O(n + klog(n)) time | O(n) space
    public static List<Integer> topKFrequentElements(int[] nums, int k) {

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            if (frequencyMap.containsKey(num)) {
                frequencyMap.put(num, frequencyMap.get(num) + 1);
            } else {
                frequencyMap.put(num, 1);
            }
        }

        PriorityQueue<Integer[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> -a[1]));
        for (Map.Entry<Integer, Integer> element : frequencyMap.entrySet()) {
            queue.add(new Integer[]{element.getKey(), element.getValue()});
        }

        if (queue.size() < k) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(queue.poll()[0]);
        }
        return result;
    }

}
