package october_2023;

import java.util.HashMap;
import java.util.Map;

public class SuffixTrieConstruction {

    public static void main(String[] args) {
        String str = "babc";

        SuffixTrie suffixTrie = new SuffixTrie(str);
        boolean result = suffixTrie.contains("abc");
        System.out.println(result);
    }

    static class SuffixTrie {
        TrieNode root = new TrieNode();

        public SuffixTrie(String string) {
            populateSuffixTrie(string);
        }

        // O(n^2) time | O(n^2) space
        private void populateSuffixTrie(String string) {
            for (int i = 0; i < string.length(); i++) {
                TrieNode curr = root;
                for (int j = i; j < string.length(); j++) {
                    char c = string.charAt(j);
                    if (!curr.children.containsKey(c)) {
                        curr.children.put(c, new TrieNode());
                    }
                    curr = curr.children.get(c);
                }
                curr.endSymbol = '*';
            }
        }

        // O(m) time | O(1) space
        public boolean contains(String substring) {
            TrieNode curr = root;
            for (int i = 0; i < substring.length(); i++) {
                char c = substring.charAt(i);
                if (!curr.children.containsKey(c)) {
                    return false;
                }
                curr = curr.children.get(c);
            }
            return curr.endSymbol == '*';
        }

    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        char endSymbol;
    }

}
