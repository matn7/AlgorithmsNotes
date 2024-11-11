package october_2024;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class WordDictionary2 {

    public static void main(String[] args) {
        WordDictionary2 wordDictionary = new WordDictionary2();

        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");

        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ax"));

    }

    // leetcode 211

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
        return dfs(0, root, word);
    }

    private boolean dfs(int j, TrieNode root, String word) {
        TrieNode curr = root;
        for (int i = j; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (Map.Entry<Character, TrieNode> elem : curr.children.entrySet()) {
                    TrieNode child = elem.getValue();
                    if (dfs(i + 1, child, word)) {
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