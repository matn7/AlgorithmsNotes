package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiStringSearch {

    public static void main(String[] args) {
        String bigString = "this is a big string";
        String[] smallStrings = {"this", "yo", "is", "a", "bigger", "string", "kappa"};

        List<Boolean> booleans = multiStringSearch(bigString, smallStrings);
        booleans.stream().forEach(System.out::println);
    }

    // O(ns + bs) time | O(ns) space
    public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
        Trie trie = new Trie();
        for (String string : smallStrings) {
            trie.insert(string);
        }
        Map<String, Boolean> containedStrings = new HashMap<>();
        for (int i = 0; i < bigString.length(); i++) {
            findSmallStringsIn(bigString, i, trie, containedStrings);
        }
        List<Boolean> result = new ArrayList<>();
        for (String string : smallStrings) {
            if (containedStrings.containsKey(string)) {
                result.add(containedStrings.get(string));
            } else {
                result.add(Boolean.FALSE);
            }
        }
        return result;
    }

    private static void findSmallStringsIn(String string, int startIdx, Trie trie,
                                           Map<String, Boolean> containedStrings) {
        TrieNode currentNode = trie.root;
        for (int i = startIdx; i < string.length(); i++) {
            char currentChar = string.charAt(i); // 'g'
            if (!currentNode.children.containsKey(currentChar)) {
                break;
            }
            currentNode = currentNode.children.get(currentChar);
            if (currentNode.children.containsKey(trie.endSymbol)) {
                containedStrings.put(currentNode.fullString.get(trie.endSymbol), Boolean.TRUE);
            }
        }
    }

    static class Trie {
        TrieNode root;
        Character endSymbol = '*';

        public Trie() {
            this.root = new TrieNode();
        }

        // "this"
        private void insert(String word) {
            TrieNode current = root;
            for (Character letter : word.toCharArray()) {
                if (!current.children.containsKey(letter)) {
                    current.children.put(letter, new TrieNode());
                }
                current = current.children.get(letter);
            }
            current.children.put('*', null);
            current.fullString.put('*', word);
        }
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        Map<Character, String> fullString = new HashMap<Character, String>();
    }
}
