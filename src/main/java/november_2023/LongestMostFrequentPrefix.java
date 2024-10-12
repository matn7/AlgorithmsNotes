package november_2023;

import java.util.HashMap;
import java.util.Map;

public class LongestMostFrequentPrefix {

    public static void main(String[] args) {
        String[] strings = {"algoexpert", "algorithm", "frontendexpert", "mlexpert"};

        LongestMostFrequentPrefix longestMostFrequentPrefix = new LongestMostFrequentPrefix();
        longestMostFrequentPrefix.longestMostFrequentPrefix(strings);
    }

    // O(n * m) time | O(n * m) space
    public String longestMostFrequentPrefix(String[] strings) {
        // Write your code here.
        Trie trie = new Trie(strings);

        String substring = trie.maxPrefixFullString.substring(0, trie.maxPrefixLength);
        return substring;
    }

    static class Trie {
        TrieNode root = new TrieNode();
        int maxPrefixCount = 0;
        int maxPrefixLength = 0;
        String maxPrefixFullString = "";

        public Trie(String[] strings) {
            populate(strings);
        }

        private void populate(String[] strings) {
            for (String str : strings) {
                TrieNode curr = root;
                for (int i = 0; i < str.length(); i++) {
                    char c = str.charAt(i);
                    if (!curr.children.containsKey(c)) {
                        curr.children.put(c, new TrieNode());
                    }
                    curr = curr.children.get(c);
                    curr.count++;

                    if (curr.count > maxPrefixCount) {
                        maxPrefixCount = curr.count;
                        maxPrefixLength = i + 1;
                        maxPrefixFullString = str;
                    } else if (curr.count == maxPrefixCount && i + 1 > maxPrefixLength) {
                        maxPrefixLength = i + 1;
                        maxPrefixFullString = str;
                    }
                }
                curr.endSymbol = '*';
            }
        }
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        int count;
        char endSymbol;
    }

}
