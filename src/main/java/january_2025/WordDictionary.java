package january_2025;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {

    TrieNode root;

    public WordDictionary() {
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
        return dfs(0, root, word);
    }

    private boolean dfs(int j, TrieNode root, String word) {
        TrieNode curr = root;
        for (int i = j; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                Map<Character, TrieNode> children = curr.children;
                for (Map.Entry<Character, TrieNode> child : children.entrySet()) {
                    if (dfs(i + 1, child.getValue(), word)) {
                        return true;
                    }
                }
                return false;
            }
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return curr.word;
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean word;
    }

}
