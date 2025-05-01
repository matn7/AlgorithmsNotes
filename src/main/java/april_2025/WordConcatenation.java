package april_2025;

import java.util.*;

public class WordConcatenation {

    public static void main(String[] args) {
        String[] words = {"cats", "cat", "dog", "catsdog"};

        WordConcatenation wordConcatenation = new WordConcatenation();
        List<String> result = wordConcatenation.findAllConcatenatedWordsInADict(words);
        System.out.println(result);
    }

    // O(n*m^2) time | O(m) space
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> wordsDict = new HashSet<>(Arrays.stream(words).toList());
        List<String> result = new ArrayList<>();
        Map<String, Boolean> cache = new HashMap<>();

        for (String word : words) {
            if (canFormCache(word, wordsDict, cache)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean canFormCache(String word, Set<String> wordsDict, Map<String, Boolean> cache) {
        if (cache.containsKey(word)) {
            return cache.get(word);
        }
        for (int index = 1; index < word.length(); index++) {
            String prefix = word.substring(0, index);
            String suffix = word.substring(index);
            if (wordsDict.contains(prefix)) {
                if (wordsDict.contains(suffix) || canFormCache(suffix, wordsDict, cache)) {
                    cache.put(word, true);
                    return true;
                }
            }
        }
        cache.put(word, false);
        return false;
    }

}
