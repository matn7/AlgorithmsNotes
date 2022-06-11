package medium;

import java.util.*;

public class GroupAnagramsREPEAT {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>(Arrays.asList("yo", "act", "flop", "tac", "cat", "oy", "olfp"));

        groupAnagrams(words);
    }

    // O(w * n*log(n)) time | O(w*n) space
    // OK - repeated 12/02/2022
    public static List<List<String>> groupAnagrams(List<String> words) {
        // Write your code here.
        Map<String, List<String>> wordsMap = new HashMap<>();
        // words = ["yo", "act", "flop", "tac", "cat", "oy", "olfp"]
        for (String word : words) { // olfp
            // sort word and check for key
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars); // "flop"
            if (wordsMap.containsKey(key)) {
                // update map
                List<String> anagrams = wordsMap.get(key);
                anagrams.add(word);
                wordsMap.remove(key);
                wordsMap.put(key, anagrams);
            } else {
                // new map
                List<String> anagrams = new ArrayList<>();
                anagrams.add(word);
                wordsMap.put(key, anagrams);
            }
        }
        // {"oy": ["yo", "oy"], "act": ["act", "tac", "cat"], "flop": ["flop", "olfp"]}
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> element : wordsMap.entrySet()) {
            result.add(element.getValue());
        }
        return result;
    }

}
