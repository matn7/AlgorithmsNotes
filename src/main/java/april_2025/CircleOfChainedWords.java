package april_2025;

import java.util.*;

public class CircleOfChainedWords {

    public static void main(String[] args) {
//        String[] words = {"eggs", "apple", "snack", "karat", "tuna"};
//        String[] words = {"eggs", "applx", "apply", "apple", "applz", "snack", "karat", "tuna"};

//        String[] words =  {"abc", "cde", "efg", "gha", "hij"};
        String[] words = {"abc", "cde", "efg", "ghh", "hij", "jaa"};

        CircleOfChainedWords circleOfChainedWords = new CircleOfChainedWords();

        boolean result = circleOfChainedWords.chainedWords(words);
        System.out.println(result);
    }

    // O(n^2) time | O(n) space
    public boolean chainedWords(String[] words) {
        Map<Character, List<String>> adj = new HashMap<>();

        for (String word : words) {
            adj.put(word.charAt(0), new ArrayList<>());
        }
        for (String word : words) {
            char start = word.charAt(0);
            adj.get(start).add(word);
        }

        String startWord = words[0];
        Set<String> seen = new HashSet<>();

        return cycle(startWord, seen, words.length, adj);
    }

    private boolean cycle(String word, Set<String> seen, int size, Map<Character, List<String>> adj) {
        if (seen.contains(word)) {
            return false;
        }
        seen.add(word);
        if (seen.size() == size) {
            return true;
        }
        char endChar = word.charAt(word.length() - 1);
        List<String> neighbors = adj.getOrDefault(endChar, Collections.emptyList());
        for (String neighbor : neighbors) {
            if (!seen.contains(neighbor)) {
                if (cycle(neighbor, seen, size, adj)) {
                    return true;
                }
            }
        }
        seen.remove(word);
        return false;
    }

}
