package october_2023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestUniquePrefix {

    public static void main(String[] args) {
        String[] words = {"john", "jon", "jack", "techlead"};
        String[] strings = {"algoexpert", "algorithm", "frontendexpert", "mlexpert"};


        shortestUniquePrefix(strings);
    }

    // O(n) time | O(n) space
    public static List<String> shortestUniquePrefix(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        for (String word : words) {
            System.out.println(trie.contains(word));
        }
        List<String> result = new ArrayList<>();
        for (String word : words) {
            result.add(trie.uniquePrefix(word));
        }

        return result;
    }


    static class Trie {
        TrieNode root = new TrieNode();

        private void insert(String word) {
            TrieNode curr = root;
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new TrieNode());
                }
                curr.count++;
                curr = curr.children.get(c);
            }
            curr.endSymbol = '*';
        }

        public String uniquePrefix(String word) {
            TrieNode node = root;
            StringBuilder prefix = new StringBuilder();
            for (char c : word.toCharArray()) {
                if (node.count == 1) {
                    return prefix.toString();
                } else {
                    node = node.children.get(c);
                    prefix.append(c);
                }
            }
            return prefix.toString();
        }

        public boolean contains(String word) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!curr.children.containsKey(c)) {
                    return false;
                }
                curr = curr.children.get(c);
            }
            return curr.endSymbol == '*';
        }
    }

    static class TrieNode {
        int count;
        Map<Character, TrieNode> children = new HashMap<>();
        char endSymbol;
    }

}
