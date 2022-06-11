package medium;

import java.util.HashMap;
import java.util.Map;

public class SuffixTrieConstruction {

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    }

    static class SuffixTrie {
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public SuffixTrie(String str) {
            populateSuffixTrieFrom(str);
        }

        // O(n^2) time | O(n^2) space
        public void populateSuffixTrieFrom(String string) {
            // Write your code here.
            for (int i = 0; i < string.length(); i++) {
                insertSubstringStartingAt(i, string);
            }
        }

        private void insertSubstringStartingAt(int i, String string) {
            TrieNode node = root;
            for (int j = i; j < string.length(); j++) {
                char letter = string.charAt(j);
                if (!node.children.containsKey(letter)) {
                    node.children.put(letter, new TrieNode());
                }
                node = node.children.get(letter);
            }
            node.children.put(endSymbol, null);
        }

        // O(m) time (m string length) | O(1) space
        public boolean contains(String string) {
            // Write your code here.
            TrieNode node = root;
            for (char letter : string.toCharArray()) {
                if (!node.children.containsKey(letter)) {
                    return false;
                }
                node = node.children.get(letter);
            }
            return node.children.containsKey(endSymbol);
        }
    }

}
