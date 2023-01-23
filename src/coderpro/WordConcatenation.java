package coderpro;

import java.util.*;

public class WordConcatenation {

    public static void main(String[] args) {
        String[] word = {"cat", "cats", "dog", "catsdog"};
        List<String> words = new ArrayList<>(Arrays.asList(word));

        WordConcatenation wordConcatenation = new WordConcatenation();
        wordConcatenation.findAllConcatenatedWords(words);

    }

    // O(n * m^2) time | O(m) space
    public List<String> findAllConcatenatedWordsCache(List<String> words) {
        Set<String> wordsDist = new HashSet<>(words);
        List<String> result = new ArrayList<>();
        Map<String, Boolean> cache = new HashMap<>();
        for (String word : words) {
            if (canFormCache(word, wordsDist, cache)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean canFormCache(String word, Set<String> wordDict, Map<String, Boolean> cache) {
        if (cache.containsKey(word)) {
            return cache.get(word);
        }
        for (int index = 1; index < word.length(); index++) {
            String prefix = word.substring(0, index);
            String suffix = word.substring(index);
            if (wordDict.contains(prefix)) {
                if (wordDict.contains(suffix) || canFormCache(suffix, wordDict, cache)) {
                    cache.put(word, Boolean.TRUE);
                    return true;
                }
            }
        }
        return false;
    }

    // O(n * 2^m) time | O(2^m) space
    public List<String> findAllConcatenatedWords(List<String> words) {
        Set<String> wordsDist = new HashSet<>(words);
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (canForm(word, wordsDist)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean canForm(String word, Set<String> wordDict) {
        for (int index = 1; index < word.length(); index++) {
            String prefix = word.substring(0, index);
            String suffix = word.substring(index);
            if (wordDict.contains(prefix)) {
                if (wordDict.contains(suffix) || canForm(suffix, wordDict)) {
                    return true;
                }
            }
        }
        return false;
    }

}
