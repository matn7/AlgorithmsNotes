package coderpro;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        List<Integer> input = new ArrayList<>();
        for (int num : nums) {
            input.add(num);
        }

        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        topKFrequentElements.topKFrequent(input, k);
    }

    // O(n + klog(n)) time | O(n) space
    public List<Integer> topKFrequent(List<Integer> nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            if (count.containsKey(num)) {
                count.put(num, count.get(num) + 1);
            } else {
                count.put(num, 1);
            }
        }

        PriorityQueue<Integer[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> -a[1]));
        for (Map.Entry<Integer, Integer> element : count.entrySet()) {
            int num = element.getKey();
            int c = element.getValue();
            Integer[] elem = {num, c};
            heap.add(elem);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(heap.poll()[0]);
        }

        return result;
    }

    // O(n + klog(n)) time | O(n) space
    public List<Integer> topKFrequent2(List<Integer> nums, int k) {
        PriorityQueue<Element> queue = new PriorityQueue<>(Comparator.reverseOrder());
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            if (freqMap.containsKey(num)) {
                freqMap.put(num, freqMap.get(num) + 1);
            } else {
                freqMap.put(num, 1);
            }
        }

        for (Map.Entry<Integer, Integer> element : freqMap.entrySet()) {
            Integer num = element.getKey();
            Integer freq = element.getValue();
            Element oneElement = new Element(num, freq);
            queue.add(oneElement);
        }

        List<Integer> result = new ArrayList<>();
        int counter = 0;
        while (counter < k) {
            result.add(queue.poll().num);
            counter++;
        }

       return result;

    }



}

class Element implements Comparable<Element> {
    int num;
    int freq;

    public Element(int num, int freq) {
        this.num = num;
        this.freq = freq;
    }

    @Override
    public int compareTo(Element o) {
        return this.freq - o.freq;
    }
}