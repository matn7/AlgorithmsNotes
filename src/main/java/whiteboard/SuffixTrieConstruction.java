package whiteboard;

import java.util.HashMap;
import java.util.Map;

public class SuffixTrieConstruction {

    public static void main(String[] args) {
        SuffixTrie suffixTrie = new SuffixTrie("babc");
        suffixTrie.contains("aba");
    }

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
        public void populateSuffixTrieFrom(String str) {
            // Write your code here.
            for (int i = 0; i < str.length(); i++) {
                TrieNode currentNode = this.root;
                for (int j = i; j < str.length(); j++) {
                    char character = str.charAt(j);
                    if (currentNode.children.containsKey(character)) {
                        currentNode = currentNode.children.get(character);
                        continue;
                    }
                    currentNode.children.put(character, new TrieNode());
                    currentNode = currentNode.children.get(character);
                }
                currentNode.children.put(endSymbol, null);
            }
            System.out.println();
        }

        // O(m) time | O(1) space
        public boolean contains(String str) {
            // Write your code here.
            TrieNode currentNode = this.root;
            for (int i = 0; i < str.length(); i++) {
                char character = str.charAt(i);
                if (!currentNode.children.containsKey(character)) {
                    return false;
                }
                currentNode = currentNode.children.get(character);
            }
            return currentNode.children.containsKey(endSymbol);
        }
    }

}
