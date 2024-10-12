package may_2024;

import java.util.*;

public class WordConcatenation {

    public static void main(String[] args) {
        String[] words = {"cat", "cats", "dog", "catsdog"};

        List<String> wordsArr = new ArrayList<>();
        for (String word : words) {
            wordsArr.add(word);
        }

        List<String> result = wordConcatenation(wordsArr);
        System.out.println(result);
    }

    // O(n*m^2) time | O(m) space
    public static List<String> wordConcatenation(List<String> words) {

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

        for (int index = 1; index < word.length(); index++) {
            String prefix = word.substring(0, index);
            String suffix = word.substring(index);
            if (wordsDict.contains(prefix)) {
                if (wordsDict.contains(suffix) || canFormCache(suffix, wordsDict, cache)) {
                    cache.put(suffix, Boolean.TRUE);
                    return true;
                }
            }
        }
        return false;
    }

    public static String wordConcatenation2(String[] words) {
        Set<String> wordsSet = new HashSet<>(Arrays.asList(words));

        for (int i = 0; i < words.length; i++) {
            String currWord = words[i];
            for (int j = i + 1; j < words.length; j++) {
                String otherWord = words[j];
                String newWord = currWord + otherWord;
                if (wordsSet.contains(newWord)) {
                    return newWord;
                }
            }
        }
        return null;

    }

}
