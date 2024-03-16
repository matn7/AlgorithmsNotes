package october_2023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Autocompletion {

    public static void main(String[] args) {
        String[] words = {"dog", "door", "dark", "cat", "elephant", "dodge"};
        String substring = "do";

        autocompletion(words, substring);
    }

    // O(n*m) time | O(n*m) space
    public static List<String> autocompletion(String[] words, String substring) {
        Trie trie = new Trie(words);

        List<String> result = new ArrayList<>();

        TrieNode curr = trie.root;
        for (char c : substring.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return null;
            }
            curr = curr.children.get(c);
        }

        StringBuilder builder = new StringBuilder(substring);
        dfs(curr, builder, result, substring);

        return result;
    }

    private static void dfs(TrieNode curr, StringBuilder builder, List<String> result, String substring) {
        if (curr.endSymbol == '*') {
            result.add(builder.toString());
            builder.setLength(0);
            builder.append(substring);
            return;
        }

        for (Map.Entry<Character, TrieNode> elem : curr.children.entrySet()) {
            Character key = elem.getKey();
            builder.append(key);
            TrieNode value = elem.getValue();
            dfs(value, builder, result, substring);
        }

    }


    static class Trie {
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public Trie(String[] words) {
            populate(words);
        }

        private void populate(String[] words) {
            for (String word : words) {
                for (int i = 0; i < word.length(); i++) {
                    TrieNode curr = root;
                    for (int j = i; j < word.length(); j++) {
                        char c = word.charAt(j);
                        if (!curr.children.containsKey(c)) {
                            curr.children.put(c, new TrieNode());
                        }
                        curr = curr.children.get(c);
                    }
                    curr.endSymbol = endSymbol;
                }
            }
        }

    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        char endSymbol;
    }
}
