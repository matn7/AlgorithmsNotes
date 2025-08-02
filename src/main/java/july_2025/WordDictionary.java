package july_2025;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
//        wordDictionary.addWord("bad");
//        wordDictionary.addWord("dad");
//        wordDictionary.addWord("mad");
//        wordDictionary.addWord("and");
//        System.out.println(wordDictionary.search("pad"));
//        System.out.println(wordDictionary.search("bad"));
//        System.out.println(wordDictionary.search(".ad"));
//        System.out.println(wordDictionary.search(".t."));
//        System.out.println(wordDictionary.search("b.."));


        // [[],
        // ["at"], a
        // ["and"], a
        // ["an"], a
        // ["add"], a
        // ["a"], s
        // [".at"], s
        // ["bat"], a *
        // [".at"], s
        // ["an."], s
        // ["a.d."], s
        // ["b."], s

        // ["a.d"], s
        // ["."]] s

        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");
//        System.out.println(wordDictionary.search("a"));
//        System.out.println(wordDictionary.search(".at"));
        wordDictionary.addWord("bat");
//        System.out.println(wordDictionary.search(".at"));
//        System.out.println(wordDictionary.search("an."));
//        System.out.println(wordDictionary.search("a.d."));
//        System.out.println(wordDictionary.search("b."));
        System.out.println(wordDictionary.search("a.d"));
        System.out.println(wordDictionary.search("."));

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
        TrieNode curr = root;
        return searchHelper(word, 0, curr);
    }

    private boolean searchHelper(String word, int i, TrieNode curr) {
        for (int j = i; j < word.length(); j++) {
            char c = word.charAt(j);
            if (c == '.') {
                Map<Character, TrieNode> children = curr.children;
                for (Map.Entry<Character, TrieNode> elem : children.entrySet()) {
                    if (searchHelper(word, j + 1, elem.getValue())) {
                        return true;
                    }
                }
                return false;
            } else if (!curr.children.containsKey(c)) {
                    return false;
            } else {
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

