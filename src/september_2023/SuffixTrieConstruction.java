package september_2023;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SuffixTrieConstruction {

    public static void main(String[] args) {
        SuffixTrie suffixTrie = new SuffixTrie("babc");
        suffixTrie.contains("abc");
    }

    // Do not edit the class below except for the
    // populateSuffixTrieFrom and contains methods.
    // Feel free to add new properties and methods
    // to the class.
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
                TrieNode curr = root;
                for (int j = i; j < str.length(); j++) {
                    char c = str.charAt(j);
                    if (!curr.children.containsKey(c)) {
                        curr.children.put(c, new TrieNode());
                    }
                    curr = curr.children.get(c);
                }
                curr.children.put(endSymbol, null);
            }

        }

        // O(m) time | O(1) space
        public boolean contains(String str) {
            // Write your code here.
            TrieNode curr = root;
            for(int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (!curr.children.containsKey(c)) {
                    return false;
                }
                curr = curr.children.get(c);
            }
            return curr.children.containsKey(endSymbol);
        }
    }

}
