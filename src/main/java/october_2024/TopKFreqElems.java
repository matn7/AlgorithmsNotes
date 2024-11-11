package october_2024;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFreqElems {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        TopKFreqElems topKFreqElems = new TopKFreqElems();
        int[] result = topKFreqElems.topKFrequent(nums, k);
        System.out.println(result);
    }

    // O(nlog(n)) time | O(n) space
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Element> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (Map.Entry<Integer, Integer> element : freqMap.entrySet()) {
            queue.add(new Element(element.getKey(), element.getValue()));
        }
        int[] result = new int[k];
        int index = 0;
        for (int i = 0; i < k; i++) {
            Element poll = queue.poll();
            result[index] = poll.value;
            index++;
        }
        return result;
    }

    static class Element implements Comparable<Element> {
        int value;
        int freq;

        public Element(int value, int freq) {
            this.value = value;
            this.freq = freq;
        }

        @Override
        public int compareTo(Element o) {
            return freq - o.freq;
        }
    }

}
