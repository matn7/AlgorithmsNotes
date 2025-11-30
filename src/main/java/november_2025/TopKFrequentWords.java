package november_2025;

import java.util.*;

public class TopKFrequentWords {

    public static void main(String[] args) {
        String[] words = {"i","love","leetcode","i","love","coding"};
        int k = 2;

        TopKFrequentWords topKFrequentWords = new TopKFrequentWords();
        List<String> strings = topKFrequentWords.topKFrequent(words, k);
        System.out.println(strings);
    }

    // O(nlog(k)) time | O(n) space
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Pair> queue = new PriorityQueue<>();

        for (Map.Entry<String, Integer> elem : freqMap.entrySet()) {
            queue.add(new Pair(elem.getValue(), elem.getKey()));
        }
        List<String> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            Pair current = queue.poll();
            result.add(current.word);
        }
        return result;
    }

    static class Pair implements Comparable<Pair> {
        int count;
        String word;

        public Pair(int count, String word) {
            this.count = count;
            this.word = word;
        }


        @Override
        public int compareTo(Pair o) {
            if (o.count == this.count) {
                return this.word.compareTo(o.word);
            }
            return o.count - this.count;
        }
    }

}
