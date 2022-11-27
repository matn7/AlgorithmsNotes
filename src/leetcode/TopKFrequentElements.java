package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 2, 3, 1, 1, 1, 3, 3, 3, 3, 3, 3};

        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();

        int[] ints = topKFrequentElements.topKFrequent(nums, 2);
        System.out.println();
    }

    public int[] topKFrequent(int[] nums, int k) {
        if (k <= 0 || nums.length == 0) {
            return new int[] {};
        }

        PriorityQueue<Element> queue = new PriorityQueue<Element>(); // min PQ

        Map<Integer, Element> numsFreqMap = new HashMap<>();

        for (int num : nums) {
            if (numsFreqMap.containsKey(num)) {
                Element element = numsFreqMap.get(num);
                element.freq++;
            } else {
                Element element = new Element(num, 1);
                numsFreqMap.put(num, element);
            }
        }

        for (Map.Entry<Integer, Element> element : numsFreqMap.entrySet()) {
            if (queue.size() < k) {
                queue.add(element.getValue());
            } else {
                Element topElement = queue.peek();
                Element currentElement = element.getValue();
                if (currentElement.freq > topElement.freq) {
                    queue.poll();
                    queue.add(currentElement);
                }
            }
        }

        if (queue.size() < k) {
            return new int[] {};
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll().num;
        }

        return result;
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

}
