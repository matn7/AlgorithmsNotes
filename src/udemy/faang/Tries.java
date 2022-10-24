package udemy.faang;

import java.util.HashMap;
import java.util.Map;

public class Tries implements Trie {

    TrieNode root;

    public Tries() {
        this.root = new TrieNode();
    }

    // specific k-anary tree that stores string

    // O(l) time (l length of word) | O(n) space
    @Override
    public void insert(String word) {
        TrieNode current = this.root;
        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            if (!current.children.containsKey(currChar)) {
                current.children.put(currChar, new TrieNode());
            }
            current = current.children.get(currChar);
        }
        current.children.put('*', null);
        current.fullString.put('*', word);
    }

    @Override
    public Boolean search(String word) {
        TrieNode current = this.root;
        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            if (!current.children.containsKey(currChar)) {
                return false;
            }
            current = current.children.get(currChar);
        }
        return current.children.containsKey('*');
    }

    @Override
    public Boolean startsWith(String prefix) {
        TrieNode current = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            char currChar = prefix.charAt(i);
            if (!current.children.containsKey(currChar)) {
                return false;
            }
            current = current.children.get(currChar);
        }
        return current.children.containsKey('*') || !current.children.isEmpty();
    }
}

class Main2 {
    public static void main(String[] args) {
        Tries tries = new Tries();
        String[] words = {"my", "learnbing", "majka", "maja", "Scuderia", "Seat", "Scena", "Scen"};
        for (String word : words) {
            tries.insert(word);
        }
        System.out.println();

        Boolean res1 = tries.search("Scena");
        Boolean res2 = tries.search("Scen");

        Boolean res3 = tries.startsWith("Scuder");
        Boolean res4 = tries.search("Scuder");
        tries.insert("Scuder");
        Boolean res5 = tries.search("Scuder");

        System.out.println();
        tries.insert("apple");
        Boolean res6 = tries.search("dog");
        tries.insert("dog");
        Boolean res7 = tries.search("dog");
        Boolean res8 = tries.startsWith("app");
        Boolean res9 = tries.search("app");
        tries.insert("app");
        Boolean res10 = tries.search("app");
        System.out.println();
    }
}

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    Map<Character, String> fullString = new HashMap<>();
}

interface Trie {
    void insert(String word);
    Boolean search(String word);
    Boolean startsWith(String prefix);
}
