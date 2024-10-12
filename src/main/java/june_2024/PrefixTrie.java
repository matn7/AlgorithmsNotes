package june_2024;

import java.util.HashMap;
import java.util.Map;


public class PrefixTrie implements Trie {

    public static void main(String[] args) {
        PrefixTrie prefixTrie = new PrefixTrie();
        prefixTrie.insert("apple");
        System.out.println(prefixTrie.search("dog"));
        prefixTrie.insert("dog");
        System.out.println(prefixTrie.search("dog"));
        System.out.println(prefixTrie.startsWith("app"));
        System.out.println(prefixTrie.search("app"));
        prefixTrie.insert("app");
        System.out.println(prefixTrie.search("app"));
    }

    // O(l) time | O(l) space (l - length of word)
    TrieNode root = new TrieNode();

    @Override
    public void insert(String word) {
        TrieNode current = root;

        for (char c : word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                current.children.put(c, new TrieNode());
            }
            current = current.children.get(c);
        }
        current.fullWord = word;
    }

    @Override
    public boolean search(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                return false;
            }
            current = current.children.get(c);
        }
        return current.fullWord.equals(word);
    }

    @Override
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            if (!current.children.containsKey(c)) {
                return false;
            }
            current = current.children.get(c);
        }
        return true;
    }
}

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    String fullWord = "";
}


class PrefixTrie2 implements Trie {

    TrieNode2 root = new TrieNode2();

    @Override
    public void insert(String word) {
        TrieNode2 node = this.root;
        insertHelper(word, node);
    }

    private void insertHelper(String word, TrieNode2 node) {
        if (word.length() == 0) {
            node.end = true;
            return;
        } else if (!node.keys.containsKey(word.charAt(0))) {
            node.keys.put(word.charAt(0), new TrieNode2());
            insertHelper(word.substring(1), node.keys.get(word.charAt(0)));
        } else {
            insertHelper(word.substring(1), node.keys.get(word.charAt(0)));
        }
    }

    @Override
    public boolean search(String word) {
        TrieNode2 node = this.root;
        return searchHelper(word, node);
    }

    private boolean searchHelper(String word, TrieNode2 node) {
        if (word.length() == 0 && node.end) {
            return true;
        } else if (word.length() == 0) {
            return false;
        } else if (!node.keys.containsKey(word.charAt(0))) {
            return false;
        }
        return searchHelper(word.substring(1), node.keys.get(word.charAt(0)));
    }

    @Override
    public boolean startsWith(String prefix) {
        TrieNode2 node = this.root;
        return startsWithHelper(prefix, node);
    }

    private boolean startsWithHelper(String prefix, TrieNode2 node) {
        if (prefix.length() == 0) {
            return true;
        } else if (!node.keys.containsKey(prefix.charAt(0))) {
            return false;
        }
        return startsWithHelper(prefix.substring(1), node.keys.get(prefix.charAt(0)));
    }
}

class TrieNode2 {
    Map<Character, TrieNode2> keys = new HashMap<>();
    boolean end = false;
}


interface Trie {
    void insert(String word);
    boolean search(String word);
    boolean startsWith(String prefix);
}