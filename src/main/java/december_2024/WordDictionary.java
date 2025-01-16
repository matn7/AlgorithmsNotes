package december_2024;

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
        curr.endWord = true;
    }

    public boolean search(String word) {
        return dfs(0, root, word);
    }

    private boolean dfs(int j, TrieNode root, String word) {
        TrieNode curr = root;
        for (int i = j; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (Map.Entry<Character, TrieNode> element : curr.children.entrySet()) {
                    TrieNode child = element.getValue();
                    if (dfs(i + 1, child, word)) {
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
        return curr.endWord;
    }


    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean endWord;
    }

}
