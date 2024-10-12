package november_2023;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordConcatenationV2 {

    public static void main(String[] args) {
        String[] words = {"cat", "cats", "dog", "catsdog"};
    }

    // O(n*2^m) time | O(2^m) space
    public static List<String> findAllConcatenatedWords(List<String> words) {
        Set<String> wordDict = new HashSet<>(words);
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (canForm(word, wordDict)) {
                result.add(word);
            }
        }
        return result;
    }

    private static boolean canForm(String word, Set<String> wordDict) {
        for (int idx = 1; idx < word.length(); idx++) {
            String prefix = word.substring(0, idx);
            String suffix = word.substring(idx);
            if (wordDict.contains(prefix)) {
                if (wordDict.contains(suffix) || canForm(suffix, wordDict)) {
                    return true;
                }
            }
        }
        return false;
    }

}
