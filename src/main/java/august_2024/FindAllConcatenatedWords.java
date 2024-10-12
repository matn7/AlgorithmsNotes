package august_2024;

import java.util.*;

public class FindAllConcatenatedWords {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("cat");
        words.add("cats");
        words.add("dog");
        words.add("catsdog");

        List<String> result = findAllConcatenatedWords(words);
        System.out.println(result);
    }

    // O(n*m^2) time | O(m) space
    public static List<String> findAllConcatenatedWords(List<String> words) {
        Set<String> wordsDict = new HashSet<>(words);
        Map<String, Boolean> cache = new HashMap<>();
        List<String> result = new ArrayList<>();
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
        for (int i = 0; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);
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
