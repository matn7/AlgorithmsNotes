package whiteboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumCharactersForWords2 {

    // O(n * l) time (n n um of words, l - longest word) | O(c) space (c num unique chars)
    public char[] minimumCharactersForWords(String[] words) {
        // Write your code here.
        Map<Character, Integer> finalMap = new HashMap<>();

        for (String word : words) {
            Map<Character, Integer> wordMap = new HashMap<>();
            updateWordMap(wordMap, word);
            updateFinalMap(finalMap, wordMap);
        }

        List<Character> resArr = new ArrayList<>();
        for (Map.Entry<Character, Integer> element : finalMap.entrySet()) {
            Character currChar = element.getKey();
            Integer charFreq = element.getValue();
            for (int i = 0; i < charFreq; i++) {
                resArr.add(currChar);
            }
        }
        char[] result = new char[resArr.size()];
        for (int i = 0; i < resArr.size(); i++) {
            result[i] = resArr.get(i);
        }

        return result;
    }

    private void updateWordMap(Map<Character, Integer> wordMap, String word) {
        for (char c : word.toCharArray()) {
            if (wordMap.containsKey(c)) {
                wordMap.put(c, wordMap.get(c) + 1);
            }  else {
                wordMap.put(c, 1);
            }
        }
    }

    private void updateFinalMap(Map<Character, Integer> finalMap, Map<Character, Integer> wordMap) {
        for (Map.Entry<Character, Integer> element : wordMap.entrySet()) {
            char currChar = element.getKey();
            Integer charFreq = element.getValue();
            if (finalMap.containsKey(currChar)) {
                finalMap.put(currChar, Math.max(charFreq, finalMap.get(currChar)));
            } else {
                finalMap.put(currChar, charFreq);
            }
        }
    }

}
