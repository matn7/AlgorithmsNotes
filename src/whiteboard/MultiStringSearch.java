package whiteboard;

import java.util.*;

public class MultiStringSearch {

    public static void main(String[] args) {
        String[] smallStrings = {"this", "yo", "is", "a", "bigger", "string", "kappa"};
        String bigString = "this is a big string";
        multiStringSearch(bigString, smallStrings);

        String bigString2 = "abcdefghijklmnopqrstuwxyz";
        String[] smallStrings2 = {"abc", "mnopqr", "tuw", "a", "bigger", "xyz", "kappa"};
//        String[] smallStrings2 = {"abc", "a"};
        multiStringSearch(bigString2, smallStrings2);
    }

    // ********
    // * STAR *
    // ********

    // O(ns + bs) time | O(ns) space -
    // (n: number of small string , s: longest length of small string)
    // (b: number of characters in big string)

    // Trie construction O(ns) time | O(ns) space
    public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
        // Write your code here.

        List<Boolean> result = new ArrayList<>();
        SuffixTree suffixTree = new SuffixTree();
        for (String string : smallStrings) {
            suffixTree.insert(string);
            result.add(Boolean.FALSE);
        }

        Set<String> foundElement = new HashSet<>();
        for (int i = 0; i < bigString.length(); i++) {
            ChildNode currentNode = suffixTree.root;
            for (int j = i; j < bigString.length(); j++) {
                char currentChar = bigString.charAt(j);
                if (!currentNode.children.containsKey(currentChar)) {
                    break;
                }

                currentNode = currentNode.children.get(currentChar);
                if (currentNode.children.containsKey('*')) {
                    String foundString = currentNode.fullString.get('*');
                    foundElement.add(foundString);
                }
            }
        }

        for (int i = 0; i < smallStrings.length; i++) {
            if (foundElement.contains(smallStrings[i])) {
                result.set(i, Boolean.TRUE);
            }
        }

        return result;
    }

    static class SuffixTree {
        ChildNode root = new ChildNode();

        public void insert(String string) {
            ChildNode currentNode = root;
            for (int i = 0; i < string.length(); i++) {
                char current = string.charAt(i);
                if (!currentNode.children.containsKey(current)) {
                    currentNode.children.put(current, new ChildNode());
                }
                currentNode = currentNode.children.get(current);
            }
            currentNode.children.put('*', null);
            currentNode.fullString.put('*', string);
        }
    }

    static class ChildNode {
        Map<Character, ChildNode> children = new HashMap<>();
        Map<Character, String> fullString = new HashMap<>();
    }

    // ************************
    // O(bns) time | O(n) space
    public static List<Boolean> multiStringSearch2(String bigString, String[] smallStrings) {
        List<Boolean> result = new ArrayList<>();
        for (String smallString : smallStrings) {
            isInBigString(bigString, smallString, result);
        }
        return result;
    }

    private static void isInBigString(String bigString, String smallString, List<Boolean> result) {
        for (int i = 0; i < bigString.length(); i++) {
            if (i + smallString.length() > bigString.length()) {
                break;
            }
            if (isInBigStringHelper(bigString, smallString, i)) {
                result.add(true);
                return;
            }
        }
        result.add(false);
    }

    private static boolean isInBigStringHelper(String bigString, String smallString, int startIdx) {
        int leftBigIdx = startIdx;
        int rightBigIdx = startIdx + smallString.length() - 1;
        int leftSmallIdx = 0;
        int rightSmallIdx = smallString.length() - 1;

        while (leftBigIdx <= rightBigIdx) {
            if (bigString.charAt(leftBigIdx) != smallString.charAt(leftSmallIdx) ||
                    bigString.charAt(rightBigIdx) != smallString.charAt(rightSmallIdx)) {
                return false;
            }
            leftBigIdx++;
            rightBigIdx--;
            leftBigIdx++;
            rightSmallIdx--;
        }
        return true;
    }

    // ***********************************
    // O(b^2 + ns) time | O(b^2 + n) space
    public static List<Boolean> multiStringSearch3(String bigString, String[] smallStrings) {
        // Write your code here.
        ModifiedSuffixTrie modifiedSuffixTrie = new ModifiedSuffixTrie(bigString);
        List<Boolean> result = new ArrayList<Boolean>();

        for (String smallString : smallStrings) {
            result.add(modifiedSuffixTrie.contains(smallString));
        }

        return result;
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    }

    static class ModifiedSuffixTrie {
        TrieNode root = new TrieNode();
//        char endSymbol = '*';

        public ModifiedSuffixTrie(String str) {
            populateSuffixTrieFrom(str);
        }

        // O(n^2) time | O(n^2) space
        public void populateSuffixTrieFrom(String string) {
            // Write your code here.
            for (int i = 0; i < string.length(); i++) {
                insertSubstringStartingAt(i, string);
            }
        }

        private void insertSubstringStartingAt(int i, String string) {
            TrieNode node = root;
            for (int j = i; j < string.length(); j++) {
                char letter = string.charAt(j);
                if (!node.children.containsKey(letter)) {
                    node.children.put(letter, new TrieNode());
                }
                node = node.children.get(letter);
            }
//            node.children.put(endSymbol, null);
        }

        // O(m) time (m string length) | O(1) space
        public boolean contains(String string) {
            // Write your code here.
            TrieNode node = root;
            for (char letter : string.toCharArray()) {
                if (!node.children.containsKey(letter)) {
                    return false;
                }
                node = node.children.get(letter);
            }
            return true;
//            return node.children.containsKey(endSymbol);
        }
    }
}
