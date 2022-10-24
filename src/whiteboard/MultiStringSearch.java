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

}
