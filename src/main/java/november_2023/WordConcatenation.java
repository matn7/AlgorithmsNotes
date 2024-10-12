package november_2023;

import java.util.*;

public class WordConcatenation {

    public static void main(String[] args) {
        String[] strs = {"cat", "cats", "dog", "catsdog", "dogdog"};
        List<String> words = new ArrayList<>();
        for (String str : strs) {
            words.add(str);
        }

        findAllConcatenatedWords(words);
    }

    // O(n * m^2) time | O(m) space
    public static List<String> findAllConcatenatedWords(List<String> words) {
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
        for (int idx = 1; idx < word.length(); idx++) {
            String prefix = word.substring(0, idx);
            String suffix = word.substring(idx);
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
