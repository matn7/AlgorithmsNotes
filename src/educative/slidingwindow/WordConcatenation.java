package educative.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordConcatenation {

    public static void main(String[] args) {
        List<Integer> result = WordConcatenation.findWordConcatenation("catfoxcat", new String[] { "cat", "fox" });
        System.out.println(result);
        result = WordConcatenation.findWordConcatenation("catcatfoxfox", new String[] { "cat", "fox" });
        System.out.println(result);
    }

    // O(n * m * len) time (n - num of chars in string, m - num of words, len - len of word) | O(m + n) space
    public static List<Integer> findWordConcatenation(String str, String[] words) {
        Map<String, Integer> wordFreqMap = new HashMap<>();
        for (String word : words) {
            wordFreqMap.put(word, wordFreqMap.getOrDefault(word, 0) + 1);
        }

        List<Integer> resultIndices = new ArrayList<>();
        int wordCount = words.length;
        int wordLength = words[0].length();

        for (int i = 0; i <= str.length() - wordCount * wordLength; i++) {
            Map<String, Integer> wordsSeen = new HashMap<>();
            for (int j = 0; j < wordCount; j++) {
                int nextWordIndex = i + j * wordLength;

                String word = str.substring(nextWordIndex, nextWordIndex + wordLength);
                if (!wordFreqMap.containsKey(word)) {
                    break;
                }

                wordsSeen.put(word, wordsSeen.getOrDefault(word, 0) + 1);

                if (wordsSeen.get(word) > wordFreqMap.getOrDefault(word, 0)) {
                    break;
                }

                if (j + 1 == wordCount) {
                    resultIndices.add(i);
                }
            }
        }
        return resultIndices;
    }

}
