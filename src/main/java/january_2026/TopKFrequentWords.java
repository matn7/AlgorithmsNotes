package january_2026;

import java.util.*;

public class TopKFrequentWords {

    public static void main(String[] args) {
        String[] words = {"i","love","leetcode","i","love","coding"};
        int k = 2;

//        String[] words = {"the","day","is","sunny","the","the","the","sunny","is","is"};
//        int k = 4;

        TopKFrequentWords topKFrequentWords = new TopKFrequentWords();
        List<String> strings = topKFrequentWords.topKFrequent(words, k);
        System.out.println(strings);
    }

    // O(nlog(k)) time | O(n) space
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freqWord = new HashMap<>();
        for (String word : words) {
            freqWord.put(word, freqWord.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Element> maxHeap = new PriorityQueue<>();
        for (Map.Entry<String, Integer> element : freqWord.entrySet()) {
            maxHeap.add(new Element(element.getKey(), element.getValue()));
        }
        List<String> res = new ArrayList<>();
        int size = maxHeap.size();
        for (int i = 0; i < Math.min(size, k); i++) {
            res.add(maxHeap.poll().val);
        }
        return res;
    }

    static class Element implements Comparable<Element> {
        String val;
        int freq;

        public Element(String val, int freq) {
            this.val = val;
            this.freq = freq;
        }

        @Override
        public int compareTo(Element o) {
            if (o.freq == this.freq) {
                return this.val.compareTo(o.val);
            }
            return o.freq - this.freq;
        }
    }

}
