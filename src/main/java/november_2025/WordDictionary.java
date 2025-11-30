package november_2025;

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

    // O(n) time | O(n) space
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            int k = c - 'a';
            if (curr.children[k] == null) {
                curr.children[k] = new TrieNode();
            }
            curr = curr.children[k];
        }
        curr.word = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        return searchHelper(word, 0, curr);
    }

    private boolean searchHelper(String word, int idx, TrieNode curr) {
        for (int i = idx; i < word.length(); i++) {
            char c = word.charAt(i);
            int k = c - 'a';
            if (c == '.') {
                TrieNode[] children = curr.children;
                for (int j = 0; j < 26; j++) {
                    if (children[j] != null) {
                        if (searchHelper(word, i + 1, children[j])) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                if (curr.children[k] == null) {
                    return false;
                }
                curr = curr.children[k];
            }
        }
        return curr.word;
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean word;
    }

}
