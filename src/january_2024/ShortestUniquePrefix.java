package january_2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestUniquePrefix {

    public static void main(String[] args) {
        String[] words = {"jon", "john", "jack", "techlead"};

        ShortestUniquePrefix shortestUniquePrefix = new ShortestUniquePrefix();
        shortestUniquePrefix.shortestUniquePrefix(words);
    }

    // O(n) time | O(n) space
    public List<String> shortestUniquePrefix(String[] words) {
        Trie trie = new Trie();

        for (String word : words) {
            trie.insert(word);
        }

        List<String> uniquePrefixes = new ArrayList<>();
        for (String word : words) {
            uniquePrefixes.add(trie.uniquePrefix(word));
        }
        return uniquePrefixes;
    }

    static class Node {
        int count;
        Map<Character, Node> children = new HashMap<>();
    }

    static class Trie {
        Node root = new Node();

        public void insert(String word) {
            Node curr = root;

            for (char c : word.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new Node());
                }
                curr = curr.children.get(c);
                curr.count += 1;
            }
        }

        public String uniquePrefix(String word) {
            Node curr = root;
            StringBuilder prefix = new StringBuilder();

            for (char c : word.toCharArray()) {
                if (curr.count == 1) {
                    return prefix.toString();
                } else {
                    curr = curr.children.get(c);
                    prefix.append(c);
                }
            }
            return prefix.toString();
        }
    }

}
