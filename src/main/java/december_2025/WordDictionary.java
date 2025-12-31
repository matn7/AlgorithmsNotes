package december_2025;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");

        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // O(k) time | O(k) space
    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.word = true;
    }

    // O(k) or O(26 * k) time | O(1) or O(k) space
    public boolean search(String word) {
        return helper(word, 0, root);
    }

    public boolean helper(String word, int idx, TrieNode curr) {
        for (int i = idx; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                TrieNode[] children = curr.children;
                for (TrieNode elem : children) {
                    if (elem == null) {
                        continue;
                    }
                    if (helper(word, i + 1, elem)) {
                        return true;
                    }
                }
                return false;
            } else if (curr.children[c - 'a'] != null) {
                curr = curr.children[c - 'a'];
            } else {
                return false;
            }
        }
        return curr.word;
    }

    static class TrieNode {
        // Map<Character, TrieNode> children = new HashMap<>();
        TrieNode[] children = new TrieNode[26];
        boolean word;
    }

}
