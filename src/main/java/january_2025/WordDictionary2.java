package january_2025;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary2 {

    TrieNode root;

    public WordDictionary2() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }
        curr.word = true;
    }

    public boolean search(String word) {
        return helper(word, 0, root);
    }

    private boolean helper(String word, int idx, TrieNode root) {
        TrieNode curr = root;
        for (int i = idx; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                Map<Character, TrieNode> children = curr.children;
                for (Map.Entry<Character, TrieNode> elem : children.entrySet()) {
                    if (helper(word, i + 1, elem.getValue())) {
                        return true;
                    }
                }
                return false;
            } else {
                if (!curr.children.containsKey(c)) {
                    return false;
                }
                curr = curr.children.get(c);
            }
        }
        return curr.word;
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean word = false;
    }

}
