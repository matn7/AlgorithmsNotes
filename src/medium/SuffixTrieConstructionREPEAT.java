package medium;

import java.util.HashMap;
import java.util.Map;

public class SuffixTrieConstructionREPEAT {

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    }

    // OK - repeated 10/02/2022
    static class SuffixTrie {
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public SuffixTrie(String str) {
            populateSuffixTrieFrom(str); // babc
        }

        // O(n^2) time | O(n^2) space
        public void populateSuffixTrieFrom(String str) {
            // Write your code here.
            // babc
            for (int i = 0; i < str.length(); i++) {
                insertSubstringStartingAt(i, str);
            }
        }

        // rec(0, "babc")
        // rec(1, "babc")
        // rec(2, "babc")
        // rec(3, "babc")
        private void insertSubstringStartingAt(int i, String str) {
            // babc
            // root = {
            //      'b': {
            //        'a': {'b': {'c': {'*': {}}}},
            //        'c': {'*': {}}
            //      },
            //      'a': {'b': {'c': {'*': {}}}},
            //      'c': {'*': {}}
            // }
            TrieNode node = root;
            for (int j = i; j < str.length(); j++) {
                char letter = str.charAt(j); // c
                if (!node.children.containsKey(letter)) {
                    node.children.put(letter, new TrieNode());
                }
                node = node.children.get(letter);
            }
            node.children.put('*', new TrieNode());
        }

        // O(m) time (m str we search) | O(1) space
        public boolean contains(String str) {
            // Write your code here.
            TrieNode node = this.root;
            // bc
            for (char letter : str.toCharArray()) { // bc
                // c
                if (!node.children.containsKey(letter)) {
                    return false;
                }
                node = node.children.get(letter);
            }
            return node.children.containsKey(endSymbol);
        }
    }

}
