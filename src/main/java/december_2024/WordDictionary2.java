package december_2024;

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
        curr.endWord = true;
    }

    public boolean search(String word) {
        return dfs(0, root, word);
    }

    private boolean dfs(int idx, TrieNode root, String word) {
        TrieNode curr = root;
        for (int i = idx; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (Map.Entry<Character, TrieNode> element : curr.children.entrySet()) {
                    if (dfs(i + 1, element.getValue(), word)) {
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
