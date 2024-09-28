package september_2024;

import java.util.*;

public class WordConcatenation {

    public static void main(String[] args) {
        String[] strs = { "cat", "dog", "cats", "catsdog" };
        List<String> words = new ArrayList<>(Arrays.asList(strs));

        List<String> result = wordConcatenation(words);
        System.out.println(result);
    }

    // O(n*m^2) time | O(m) space
    public static List<String> wordConcatenation(List<String> words) {
        List<String> result = new ArrayList<>();
        if (words.isEmpty()) {
            return result;
        }
        Set<String> wordsDict = new HashSet<>(words);
        Map<String, Boolean> cache = new HashMap<>();
        for (String word : words) {
            if (canForm(word, wordsDict, cache)) {
                result.add(word);
            }
        }
        return result;
    }

    private static boolean canForm(String word, Set<String> wordsDict, Map<String, Boolean> cache) {
        if (cache.containsKey(word)) {
            return cache.get(word);
        }

        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);
            if (wordsDict.contains(prefix)) {
                if (wordsDict.contains(suffix) || canForm(suffix, wordsDict, cache)) {
                    cache.put(word, Boolean.TRUE);
                    return true;
                }
            }
        }
        return false;
    }

}
