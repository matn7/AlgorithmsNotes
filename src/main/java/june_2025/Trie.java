package june_2025;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    // O(n) time | O(t) space
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            if (!curr.childern.containsKey(c)) {
                curr.childern.put(c, new TrieNode());
            }
            curr = curr.childern.get(c);
        }
        curr.word = true;

    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.childern.containsKey(c)) {
                return false;
            }
            curr = curr.childern.get(c);
        }
        return curr.word;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            if (!curr.childern.containsKey(c)) {
                return false;
            }
            curr = curr.childern.get(c);
        }
        return true;

    }

    static class TrieNode {
        Map<Character, TrieNode> childern = new HashMap<>();
        boolean word = false;
    }

}
