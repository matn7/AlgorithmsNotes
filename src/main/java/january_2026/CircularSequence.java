package january_2026;

import java.util.*;

public class CircularSequence {

    public static void main(String[] args) {
        String sentence = "leetcode exercises sound delightful";

//        String sentence = "eetcode";

//        String sentence = "Leetcode is cool";

        CircularSequence circularSequence = new CircularSequence();
        boolean result = circularSequence.isCircularSentence(sentence);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public boolean isCircularSentence(String sentence) {
        String[] split = sentence.split(" ");
        char start = split[0].charAt(0);

        for (int i = 0; i < split.length - 1; i++) {
            String curr = split[i];

            String next = split[i + 1];

            if (curr.charAt(curr.length() - 1) != next.charAt(0)) {
                return false;
            }
        }
        String last = split[split.length - 1];
        return last.charAt(last.length() - 1) == start;
    }

    private boolean cycle(String node, Map<Character, List<String>> adj, Set<String> visiting, Set<String> visited) {
        if (visiting.contains(node)) {
            return true;
        }
        if (visited.contains(node)) {
            return false;
        }
        char next = node.charAt(node.length() - 1);
        if (!adj.containsKey(next)) {
            return false;
        }
        visiting.add(node);
        List<String> neighbors = adj.get(next);
        for (String nei : neighbors) {
            if (cycle(nei, adj, visiting, visited)) {
                return true;
            }
        }
        visiting.remove(node);
        visited.add(node);
        return false;
    }

}
