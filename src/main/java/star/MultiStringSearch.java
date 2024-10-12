package star;

import java.util.*;

public class MultiStringSearch {

    public static void main(String[] args) {
        String[] smallStrings = {"this", "yo", "is", "a", "bigger", "string", "kappa"};
        String bigString = "this is a big string";

        MultiStringSearch multiStringSearch = new MultiStringSearch();
        multiStringSearch.multiStringSearch(smallStrings, bigString);
    }

    // O(ns + bs) time | O(ns) spac
    public List<Boolean> multiStringSearch(String[] smallStrings, String bigString) {
        Trie trie = new Trie();

        for (String word : smallStrings) {
            trie.insert(word);
        }
        Set<String> found = new HashSet<>();
        for (int i = 0; i < bigString.length(); i++) {
            findStringIn(bigString, i, trie, found);
        }

        List<Boolean> result = new ArrayList<>();
        for (String s : smallStrings) {
            if (found.contains(s)) {
                result.add(Boolean.TRUE);
            } else {
                result.add(Boolean.FALSE);
            }
        }

        return result;
    }

    private void findStringIn(String bigString, int startIdx, Trie trie, Set<String> found) {
        TrieNode currNode = trie.root;
        for (int i = startIdx; i < bigString.length(); i++) {
            char currChar = bigString.charAt(i);
            if (!currNode.children.containsKey(currChar)) {
                break;
            }
            currNode = currNode.children.get(currChar);
            if (currNode.children.containsKey(trie.endSymbol)) {
                found.add(currNode.fullString.get(trie.endSymbol));
            }
        }

    }

    static class Trie {
        TrieNode root;
        char endSymbol = '*';

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode curr = root;
            for (Character letter : word.toCharArray()) {
                if (!curr.children.containsKey(letter)) {
                    curr.children.put(letter, new TrieNode());
                }
                curr = curr.children.get(letter);
            }
            curr.children.put(endSymbol, null);
            curr.fullString.put(endSymbol, word);
        }
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        Map<Character, String> fullString = new HashMap<>();
    }


}
