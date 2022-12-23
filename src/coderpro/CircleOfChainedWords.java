package coderpro;

import java.util.*;

public class CircleOfChainedWords {

    public static void main(String[] args) {
        String[] words = {"eggs", "apple", "snack", "karat", "tuna"};

        CircleOfChainedWords circleOfChainedWords = new CircleOfChainedWords();
        circleOfChainedWords.chainedWords(words);
    }

    // O(n) time | O(n) space
    public boolean chainedWords(String[] words) {
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
        boolean result = is_cycle_dfs(symbol, words[0], words[0], words.length, visited);
        return result;
    }

    private boolean is_cycle_dfs(Map<Character, List<String>> symbol, String current_word,
                             String start_word, int length, Set<String> visited) {
        if (length == 1) {
            return start_word.charAt(0) == current_word.charAt(current_word.length() - 1);
        }

        visited.add(current_word);
        char lastChar = current_word.charAt(current_word.length() - 1);
        if (!symbol.containsKey(lastChar)) {
            return false;
        }
        List<String> neighbors = symbol.get(lastChar);

        for (String neighbor : neighbors) {
            if (!visited.contains(neighbor)) {
                return is_cycle_dfs(symbol, neighbor, start_word, length - 1, visited);
            }
        }
        visited.remove(current_word);
        return false;
    }


    // O(n) time | O(n) space
    public boolean circle(String[] words) {
        Map<Character, String> wordsMap = new HashMap<>();
        Map<String, WordGraph> wordsGraph = new HashMap<>();

        for (String word : words) {
            wordsMap.put(word.charAt(0), word);
            wordsGraph.put(word, new WordGraph(word));
        }

        for (String word : words) {
            WordGraph currWord = wordsGraph.get(word);
            char neighborChar = currWord.word.charAt(currWord.word.length() - 1);
            String neighborWord = wordsMap.get(neighborChar);
            if (!wordsGraph.containsKey(neighborWord)) {
                return false;
            }
            currWord.addNeighbor(wordsGraph.get(neighborWord));
        }

        findCircle(words[0], wordsGraph);
        boolean isCircle = wordsGraph.get(words[0]).circle;
        return isCircle;
    }

    private void findCircle(String word, Map<String, WordGraph> wordsGraph) {
        if (wordsGraph.get(word).visiting) {
            wordsGraph.get(word).circle = true;
            return;
        }

        WordGraph current = wordsGraph.get(word);
        current.visiting = true;
        List<WordGraph> neighbors = current.neighbors;
        for (WordGraph wordGraph : neighbors) {
            findCircle(wordGraph.word, wordsGraph);
        }

        current.visiting = false;
        current.visited = true;
    }

}

class WordGraph {
    String word;
    boolean visiting;
    boolean visited;
    boolean circle;
    List<WordGraph> neighbors;

    public WordGraph(String word) {
        this.word = word;
        this.visiting = false;
        this.visited = false;
        this.circle = false;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbor(WordGraph neighbor) {
       neighbors.add(neighbor);
    }
}
