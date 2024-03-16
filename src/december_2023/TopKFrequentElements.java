package december_2023;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3, 4, 4, 4, 4, 2, 2, 2, 4, 4, 4, 4, 4};
        int k = 2;

        topKFrequentElements(nums, k);
    }

    // O(klog(n)) time | O(n) space
    public static int[] topKFrequentElements(int[] nums, int k) {
        PriorityQueue<Element> queue = new PriorityQueue<>(Comparator.reverseOrder());

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // O(n) time
        for (int num : nums) {
            if (frequencyMap.containsKey(num)) {
                frequencyMap.put(num, frequencyMap.get(num) + 1);
            } else {
                frequencyMap.put(num, 1);
            }
        }

        // O(n) time
        for (Map.Entry<Integer, Integer> element : frequencyMap.entrySet()) {
            int valueFromMap = element.getKey();
            int countFromMap = element.getValue();
            queue.add(new Element(valueFromMap, countFromMap));
        }
        int[] result = new int[k];
        if (queue.size() < k) {
            return null;
        }

        int index = 0;
        for (int i = 0; i < queue.size(); i++) {
            Element topElement = queue.poll();
            result[index] = topElement.value;
            index++;
        }

        return result;
    }

    static class Element implements Comparable<Element> {
        int value;
        int count;

        public Element(int value, int count) {
            this.value = value;
            this.count = count;
        }

        @Override
        public int compareTo(Element o) {
            return count - o.count;
        }
    }

}
