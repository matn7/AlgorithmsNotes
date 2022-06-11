package whiteboard;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>(Arrays.asList("yo", "act", "flop", "tac", "foo", "cat", "oy", "flop"));
        groupAnagrams(words);
    }

    // O(w * nlog(n)) time | O(wn) space
    public static List<List<String>> groupAnagrams(List<String> words) {
        // Write your code here.
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> matchMap = new HashMap<>();

        for (String word : words) {
            char[] wordsChars = word.toCharArray();
            Arrays.sort(wordsChars);
            String sortedWord = String.valueOf(wordsChars);

            if (matchMap.containsKey(sortedWord)) {
                List<String> existingList = matchMap.get(sortedWord);
                existingList.add(word);
                matchMap.remove(sortedWord);
                matchMap.put(sortedWord, existingList);
            } else {
                List<String> matchWordList = new ArrayList<>();
                matchWordList.add(word);
                matchMap.put(sortedWord, matchWordList);
            }
        }

        for (Map.Entry<String, List<String>> element : matchMap.entrySet()) {
            result.add(element.getValue());
        }

        return result;
    }

}
