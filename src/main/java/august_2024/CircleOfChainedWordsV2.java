package august_2024;

import java.util.*;

public class CircleOfChainedWordsV2 {

    public static void main(String[] args) {
        String[] words = {"eggs", "apple", "snack", "karat", "tuna"};
    }

    public static boolean chainedWords(String[] words) {
        Map<Character, List<String>> symbol = new HashMap<>();

        for (String word : words) {
            if (symbol.containsKey(word.charAt(0))) {
                List<String> currWordList = symbol.get(word.charAt(0));
                currWordList.add(word);
                symbol.put(word.charAt(0), currWordList);
            } else {
                List<String> wordList = new ArrayList<>();
                wordList.add(word);
                symbol.put(word.charAt(0), wordList);
            }
        }

        Set<String> visited = new HashSet<>();
        return isCycleDfs(symbol, words[0], words[0], words.length, visited);
    }

    private static boolean isCycleDfs(Map<Character, List<String>> symbol, String currentWord, String startWord,
                                      int length, Set<String> visited) {
        if (length == 1) {
            return startWord.charAt(0) == currentWord.charAt(currentWord.length() - 1);
        }
        visited.add(currentWord);
        char lastChar = currentWord.charAt(currentWord.length() - 1);
        if (!symbol.containsKey(lastChar)) {
            return false;
        }
        List<String> neighbors = symbol.get(lastChar);
        for (String neighbor : neighbors) {
            if (!visited.contains(neighbor)) {
                return isCycleDfs(symbol, neighbor, startWord, length - 1, visited);
            }
        }
        visited.remove(currentWord);
        return false;
    }

}
