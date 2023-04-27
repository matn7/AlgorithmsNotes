package star;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestUniquePrefix {

    public static void main(String[] args) {
        String[] words = { "jon", "john", "jack", "techlead" };

        ShortestUniquePrefix shortestUniquePrefix = new ShortestUniquePrefix();
        shortestUniquePrefix.shortestUniquePrefix(words);
    }

    // O(n) time | O(n) space
    public List<String> shortestUniquePrefix(String[] words) {
        Trie trie = new Trie(words);
        List<String> result = new ArrayList<>();
        for (String word : words) {
            String uniquePrefix = trie.getUniquePrefix(word);
            result.add(uniquePrefix);
        }
        return result;
    }

    static class Trie {
        TrieNode node = new TrieNode();

        public Trie(String[] words) {
            for (String w : words) {
                insert(w);
            }
        }

        public void insert(String word) {
            TrieNode curr = node;
            for (char w : word.toCharArray()) {
                if (!curr.children.containsKey(w)) {
                    curr.children.put(w, new TrieNode());
                }
                curr = curr.children.get(w);
                curr.count++;
            }
        }

        public String getUniquePrefix(String word) {
            TrieNode curr = node;
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

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        int count = 0;
    }

}
