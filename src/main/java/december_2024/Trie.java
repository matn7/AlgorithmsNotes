package december_2024;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }
        curr.endSymbol = '*';

    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return curr.endSymbol == '*';
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return true;
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        char endSymbol;
    }
}