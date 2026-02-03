package january_2026;

import java.util.HashMap;
import java.util.Map;

public class ShortestUniquePrefix {

    public static void main(String[] args) {
        String[] words = {"jon", "john", "jack", "techlead"};
        // output: [jon, joh, ja, t]

        ShortestUniquePrefix shortestUniquePrefix = new ShortestUniquePrefix();
        String[] strings = shortestUniquePrefix.uniquePrefixes(words);
        System.out.println(strings);
    }

    TrieNode root;

    public String[] uniquePrefixes(String[] words) {
        root = new TrieNode();
        populateTrie(words);
        String[] result = new String[words.length];

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            TrieNode curr = root;
            StringBuilder builder = new StringBuilder();

            for (char c : word.toCharArray()) {
                builder.append(c);
                if (curr.children.get(c).count == 1) {
                    break;
                }
                curr = curr.children.get(c);
            }

            result[i] = builder.toString();
        }

        return result;
    }


    private void populateTrie(String[] words) {
        for (String word : words) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new TrieNode());
                }
                curr.count++;
                curr = curr.children.get(c);
            }
            curr.word = true;
        }
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean word;
        int count;
    }
}
