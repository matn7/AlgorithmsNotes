package october_2023;

import java.util.*;

public class CircleOfChainedWords {

    public static void main(String[] args) {
        String[] words = {"eggs", "elephant", "energy", "apple", "snack", "karat", "tuna"};

        circleOfChainedWords(words);
    }

    // O(n) time | O(n) space
    public static boolean circleOfChainedWords(String[] words) {
        Map<Character, List<String>> graphMap = prepareGraphMap(words);
        Set<String> visited = new HashSet<>();
        String startWord = words[0];

        boolean dfs = dfs(startWord, graphMap, visited);
        return dfs;
    }

    private static boolean dfs(String currWord, Map<Character, List<String>> graphMap, Set<String> visited) {
        if (visited.contains(currWord)) {
            return false;
        }
        visited.add(currWord);
        char lastChar = currWord.charAt(currWord.length() - 1);
        if (!graphMap.containsKey(lastChar)) {
            return false;
        }

        List<String> neighbors = graphMap.get(lastChar);
        for (String neighbor : neighbors) {
            if (visited.contains(neighbor)) {
                return true;
            }
            boolean cycle = dfs(neighbor, graphMap, visited);
            if (cycle) {
                return true;
            }
        }

        visited.remove(currWord);
        return false;
    }

    private static  Map<Character, List<String>> prepareGraphMap(String[] words) {
        Map<Character, List<String>> graphMap = new HashMap<>();

        for (String word : words) {
            char c = word.charAt(0);
            if (graphMap.containsKey(c)) {
                List<String> arr = graphMap.get(c);
                arr.add(word);
                graphMap.put(c, arr);
            } else {
                List<String> arr = new ArrayList<>();
                arr.add(word);
                graphMap.put(c, arr);
            }
        }
        return graphMap;
    }

}
