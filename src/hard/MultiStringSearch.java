package hard;

import medium.SuffixTrieConstruction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiStringSearch {

    public static void main(String[] args) {
        String bigString = "this is a big string";
        String[] smallStrings = {"this", "yo", "is", "a", "bigger", "string", "kappa"};
        multiStringSearch(bigString, smallStrings);
    }

    // O(ns + bs) time | O(ns) space
    public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
        // Write your code here.
        Trie trie = new Trie();

        for (String smallString : smallStrings) {
            trie.insert(smallString);
        }

        Map<String, Boolean> containedString = new HashMap<>();
        for (int i = 0; i < bigString.length(); i++) {
            findSmallStringsIn(bigString, i, trie, containedString);
        }

        List<Boolean> result = new ArrayList<>();
        for (String smallString : smallStrings) {
            if (containedString.get(smallString) != null) {
                result.add(containedString.get(smallString));
            } else {
                result.add(Boolean.FALSE);
            }
        }

        return result;
    }

    private static void findSmallStringsIn(String string, int startIdx, Trie trie,
                                           Map<String, Boolean> containedString) {
        TrieNode currentNode = trie.root;
        for (int i = startIdx; i < string.length(); i++) {
            char currentChar = string.charAt(i);
            if (!currentNode.children.containsKey(currentChar)) {
                break;
            }
            currentNode = currentNode.children.get(currentChar);
            if (currentNode.children.containsKey(trie.endSymbol)) {
                containedString.put(currentNode.fullString.get(trie.endSymbol), Boolean.TRUE);
            }
        }

    }

    static class Trie {
        TrieNode root;
        Character endSymbol = '*';

        public Trie() {
            this.root = new TrieNode();
        }

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

//    // O(b^2 + ns) time | O(b^2 + n) space
//    public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
//        // Write your code here.
//        ModifiedSuffixTrie modifiedSuffixTrie = new ModifiedSuffixTrie(bigString);
//        List<Boolean> result = new ArrayList<Boolean>();
//
//        for (String smallString : smallStrings) {
//            result.add(modifiedSuffixTrie.contains(smallString));
//        }
//
//        return result;
//    }
//
//    static class TrieNode {
//        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
//    }
//
//    static class ModifiedSuffixTrie {
//        TrieNode root = new TrieNode();
////        char endSymbol = '*';
//
//        public ModifiedSuffixTrie(String str) {
//            populateSuffixTrieFrom(str);
//        }
//
//        // O(n^2) time | O(n^2) space
//        public void populateSuffixTrieFrom(String string) {
//            // Write your code here.
//            for (int i = 0; i < string.length(); i++) {
//                insertSubstringStartingAt(i, string);
//            }
//        }
//
//        private void insertSubstringStartingAt(int i, String string) {
//            TrieNode node = root;
//            for (int j = i; j < string.length(); j++) {
//                char letter = string.charAt(j);
//                if (!node.children.containsKey(letter)) {
//                    node.children.put(letter, new TrieNode());
//                }
//                node = node.children.get(letter);
//            }
////            node.children.put(endSymbol, null);
//        }
//
//        // O(m) time (m string length) | O(1) space
//        public boolean contains(String string) {
//            // Write your code here.
//            TrieNode node = root;
//            for (char letter : string.toCharArray()) {
//                if (!node.children.containsKey(letter)) {
//                    return false;
//                }
//                node = node.children.get(letter);
//            }
//            return true;
////            return node.children.containsKey(endSymbol);
//        }
//    }

//    // O(bns) time | O(n) space (b length of bigstring, s length of smallstring, n number of small strings)
//    public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
//        // Write your code here.
//        List<Boolean> result = new ArrayList<>();
//
//        for (String smallString : smallStrings) {
//            result.add(isInBigString(bigString, smallString));
//        }
//
//        return result;
//    }
//
//    private static Boolean isInBigString(String bigString, String smallString) {
//        for (int i = 0; i < bigString.length(); i++) {
//            if (i + smallString.length() > bigString.length()) {
//                break;
//            }
//            if (isInBigStringHelper(bigString, smallString, i)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private static boolean isInBigStringHelper(String bigString, String smallString, int startIdx) {
//        int leftBigIdx = startIdx;
//        int rightBigIdx = startIdx + smallString.length() - 1;
//        int leftSmallIdx = 0;
//        int rightSmallIdx = smallString.length() - 1;
//        while (leftBigIdx <= rightBigIdx) {
//            if (bigString.charAt(leftBigIdx) != smallString.charAt(leftSmallIdx) ||
//                bigString.charAt(rightBigIdx) != smallString.charAt(rightSmallIdx)) {
//                return false;
//            }
//            leftBigIdx++;
//            rightBigIdx--;
//            leftSmallIdx++;
//            rightSmallIdx--;
//        }
//        return true;
//    }
}
