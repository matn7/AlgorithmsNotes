package july_2024;

import java.util.HashMap;
import java.util.Map;

public class LongestMostFrequentPrefix {

    public static void main(String[] args) {
        String[] strings = {"algoexpert", "algorithm", "frontendexpert", "mlexpert"};
    }

    static class Trie {
        TrieNode root = new TrieNode();
        int maxPrefixCount = 0;
        int maxPrefixLength = 0;
        String maxPrefixFullStr = "";

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
                        maxPrefixFullStr = str;
                    } else if (curr.count == maxPrefixCount && i + 1 > maxPrefixLength) {
                        maxPrefixLength = i + 1;
                        maxPrefixFullStr = str;
                    }
                }
//                curr.endSymbol;
            }
        }
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        int count;
        char endSymbol;
    }

}
