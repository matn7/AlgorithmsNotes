package medium;

import java.util.*;

public class MinimumCharactersForWords {

    public static void main(String[] args) {
        MinimumCharactersForWords min = new MinimumCharactersForWords();
        String[] words = {"this", "that", "did", "deed", "them!", "a"};

        min.minimumCharactersForWords(words);
    }

    public char[] minimumCharactersForWords(String[] words) {
        // Write your code here.
        Map<Character, Integer> countMap = new HashMap<>();
        Map<Character, Integer> tempRemoved = new HashMap<>();
        List<Character> visited = new ArrayList<>();
        for (String word : words) {
            Map<Character, Integer> wordCountMap = new HashMap<>();
            for (Character element : word.toCharArray()) {
                if (wordCountMap.containsKey(element)) {
                    wordCountMap.put(element, wordCountMap.get(element) + 1);
                } else {
                    wordCountMap.put(element, 1);
                }
            }
            if (countMap.isEmpty()) {
                countMap.putAll(wordCountMap);
            } else {
                for (Map.Entry<Character, Integer> element : wordCountMap.entrySet()) {
                    if (countMap.containsKey(element.getKey())) {
                        // use max
                        int count = countMap.get(element.getKey());
                        int current = wordCountMap.get(element.getKey());
                        countMap.put(element.getKey(), Math.max(count, current));
                    } else {
                        countMap.put(element.getKey(), element.getValue());
                    }
                }
            }
        }

        Collection<Integer> values = countMap.values();
        List<Character> resultArray = new ArrayList<>();
        for (Map.Entry<Character, Integer> element : countMap.entrySet()) {
            for (int i = 0; i < countMap.get(element.getKey()); i++) {
                resultArray.add(element.getKey());
            }
        }
        char[] result = new char[resultArray.size()];

        for (int i = 0; i < resultArray.size(); i++) {
            result[i] = resultArray.get(i);
        }

        return result;
    }

}
