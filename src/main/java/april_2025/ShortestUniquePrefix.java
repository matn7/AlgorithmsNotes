package april_2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestUniquePrefix {

    public static void main(String[] args) {
        String[] words = {"jon", "john", "jack", "techlead"};

        ShortestUniquePrefix shortestUniquePrefix = new ShortestUniquePrefix(words);
        String[] result = shortestUniquePrefix.uniquePrefixes(words);
        System.out.println(result);
    }

    TrieNode root;
    public ShortestUniquePrefix(String[] words) {
        root = new TrieNode();
        populateTrie(words);
    }

    public String[] uniquePrefixes(String[] words) {
        String[] result = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            TrieNode curr = root;
            StringBuilder builder = new StringBuilder();
            for (char c : word.toCharArray()) {
                builder.append(c);
                if (curr.children.get(c).count == 1) {
                    break;
                }
                curr = curr.children.get(c);
            }
            result[i] = builder.toString();
        }

        return result;
    }

    private void populateTrie(String[] words) {
        for (String word : words) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new TrieNode());
                }
                curr.count++;
                curr = curr.children.get(c);
            }
            curr.endWord = true;
        }
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean endWord;
        int count;
    }

}
