package whiteboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumCharactersForWords {

    public static void main(String[] args) {
        String[] words = {"this", "that", "did", "deed", "them!", "a"};
        MinimumCharactersForWords min = new MinimumCharactersForWords();
        min.minimumCharactersForWords(words);
    }

    // O(n*l) time | O(c) space - n num of words, l - length of longest word, c - num of unique chars
    public char[] minimumCharactersForWords(String[] words) {
        // Write your code here.
        Map<Character, Integer> finalMap = new HashMap<>();

        for (String word : words) {
            Map<Character, Integer> currentMap = new HashMap<>();
            updateCurrentMap(word, currentMap);
            updateFinalMap(finalMap, currentMap);
        }

        List<Character> resultList = new ArrayList<>();
        for (Map.Entry<Character, Integer> finalElement : finalMap.entrySet()) {
            int finalValue = finalElement.getValue();
            for (int i = 0; i < finalValue; i++) {
                resultList.add(finalElement.getKey());
            }
        }

        char[] result = new char[resultList.size()];
        int idx = 0;
        for (Character element : resultList) {
            result[idx] = element;
            idx++;
        }

        return result;
    }

    private void updateCurrentMap(String word, Map<Character, Integer> currentMap) {

        for (char element : word.toCharArray()) {
            if (currentMap.containsKey(element)) {
                currentMap.put(element, currentMap.get(element) + 1);
            } else {
                currentMap.put(element, 1);
            }
        }
    }

    private void updateFinalMap(Map<Character, Integer> finalMap, Map<Character, Integer> currentMap) {
        for (Map.Entry<Character, Integer> currElement : currentMap.entrySet()) {
            if (finalMap.containsKey(currElement.getKey())) {
                Integer finalValue = finalMap.get(currElement.getKey());
                Integer currentValue = currElement.getValue();
                finalMap.put(currElement.getKey(), Math.max(finalValue, currentValue));
            } else {
                finalMap.put(currElement.getKey(), currElement.getValue());
            }
        }
    }

}
