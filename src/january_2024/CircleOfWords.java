package january_2024;

import java.util.*;

public class CircleOfWords {

    public static void main(String[] args) {
        String[] words = {"apple", "eggs", "snack", "karat", "tunasx"};

        boolean result = circleOfChainedWords(words);
        System.out.println(result);
    }

    public static boolean circleOfChainedWords(String[] words) {
        Map<Character, List<Node>> graph = new HashMap<>();
        for (String word : words) {
            char start = word.charAt(0);
            if (graph.containsKey(start)) {
                List<Node> nodes = graph.get(start);
                nodes.add(new Node(start, word));
                graph.put(start, nodes);
            } else {
                List<Node> nodes = new ArrayList<>();
                nodes.add(new Node(start, word));
                graph.put(start, nodes);
            }
        }
        String startWord = words[0];
        Set<String> seen = new HashSet<>();
        return circleOfChainedWordsHelper(startWord, seen, graph);
    }

    private static boolean circleOfChainedWordsHelper(String word, Set<String> seen, Map<Character, List<Node>> graph) {
        if (seen.contains(word)) {
            return true;
        }
        seen.add(word); // [apple]
        char endChar = word.charAt(word.length() - 1); // e
        if (!graph.containsKey(endChar)) {
            return false;
        }
        List<Node> nodes = graph.get(endChar);
        for (Node node : nodes) {
            boolean result = circleOfChainedWordsHelper(node.word, seen, graph);
            if (result) {
                return true;
            }
        }

        seen.remove(word);
        return false;
    }

    static class Node {
        char start;
        String word;
        List<Node> neighbors;

        public Node(char start, String word) {
            this.start = start;
            this.word = word;
            this.neighbors = new ArrayList<>();
        }

        public void addNeighbor(Node node) {
            this.neighbors.add(node);
        }
    }

}
