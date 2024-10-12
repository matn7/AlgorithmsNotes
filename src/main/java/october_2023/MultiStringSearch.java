package october_2023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiStringSearch {

    public static void main(String[] args) {
        String[] smallStrings = {"this", "yo", "is", "a", "bigger", "string", "kappa"};
        String bigString = "this is a big string";

        multiStringSearch(smallStrings, bigString);
    }

    // O(ns + bs) time | O(ns) space
    public static List<Boolean> multiStringSearch(String[] smallStrings, String bigString) {
        Trie trie = new Trie(bigString.split(" "));
        List<Boolean> result = new ArrayList<>();

        for (String str : smallStrings) {
            if (trie.contains(str)) {
                result.add(Boolean.TRUE);
            } else {
                result.add(Boolean.FALSE);
            }
        }

        return result;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        public Trie(String[] str) {
            populateTrie(str);
        }

        private void populateTrie(String[] strings) {
            for (String str : strings) {
                for (int i = 0; i < str.length(); i++) {
                    TrieNode curr = root;
                    for (int j = i; j < str.length(); j++) {
                        char c = str.charAt(j);
                        if (!curr.children.containsKey(c)) {
                            curr.children.put(c, new TrieNode());
                        }
                        curr = curr.children.get(c);
                    }
                    curr.endSymbol = '*';
                }
            }
        }

        public boolean contains(String str) {
            TrieNode curr = root;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
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
