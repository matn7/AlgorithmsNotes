package august_2024;

import java.util.*;

public class WordConcatenation {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("cat");
        words.add("cats");
        words.add("dog");
        words.add("catsdog");

        List<String> strings = wordConcatenation(words);
        System.out.println(strings);
    }

    // O(n*m^2) time | O(m) space
    public static List<String> wordConcatenation(List<String> words) {
        Set<String> wordsDict = new HashSet<>(words);
        List<String> result = new ArrayList<>();
        Map<String, Boolean> cache = new HashMap<>();

        for (String word : words) {
            if (canFormCache(word, wordsDict, cache)) {
                result.add(word);
            }
        }
        return result;
    }

    private static boolean canFormCache(String word, Set<String> wordsDict, Map<String, Boolean> cache) {
        if (cache.containsKey(word)) {
            return cache.get(word);
        }
        for (int index = 1; index < word.length(); index++) {
            String prefix = word.substring(0, index);
            String suffix = word.substring(index);
            if (wordsDict.contains(prefix)) {
                if (wordsDict.contains(suffix) || canFormCache(suffix, wordsDict, cache)) {
                    cache.put(word, Boolean.TRUE);
                    return true;
                }
            }
        }
        return false;
    }

}
