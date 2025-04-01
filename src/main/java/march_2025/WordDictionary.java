package march_2025;

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
        return searchHelper(word, 0, root);
    }

    private boolean searchHelper(String word, int idx, TrieNode curr) {
        for (int i = idx; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                Map<Character, TrieNode> children = curr.children;
                for (Map.Entry<Character, TrieNode> child : children.entrySet()) {
                    if (searchHelper(word, i + 1, child.getValue())) {
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
        boolean word;
    }

}
