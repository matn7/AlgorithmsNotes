package november_2025;

import java.util.HashMap;
import java.util.Map;

public class Trie2 {

    TrieNode root;

    public Trie2() {
        root = new TrieNode();
    }

    // O(n) time | O(n) space
    public void insert(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
//                curr.children.put(c, new TrieNode());
                curr.children[c - 'a'] = new TrieNode();
            }
//            curr = curr.children.get(c);
            curr = curr.children[c - 'a'];
        }
        curr.word = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                return false;
            }
//            curr = curr.children.get(c);
            curr = curr.children[c - 'a'];
        }
        return curr.word;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                return false;
            }
//            curr = curr.children.get(c);
            curr = curr.children[c - 'a'];
        }
        return true;
    }

    static class TrieNode {
//        Map<Character, TrieNode> children = new HashMap<>();
        TrieNode[] children = new TrieNode[26];
        boolean word;
    }

}
