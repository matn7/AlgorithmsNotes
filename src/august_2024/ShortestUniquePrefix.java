package august_2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestUniquePrefix {

    public static void main(String[] args) {
        String[] words = { "jon", "john", "jack", "techlead" };

        ShortestUniquePrefix shortestUniquePrefix = new ShortestUniquePrefix(words);

        System.out.println(shortestUniquePrefix.root);

        shortestUniquePrefix.shortestPrefix(words);
    }

    TrieNode root = new TrieNode();

    public ShortestUniquePrefix(String[] words) {
        init(words);
    }

    private void init(String[] words) {
        for (String word : words) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new TrieNode());
                }
                curr.count++;
                curr = curr.children.get(c);
            }
        }
    }

    // O(n) time | O(n) space
    public List<String> shortestPrefix(String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            TrieNode curr = root;
            StringBuilder builder = new StringBuilder();
            for (char c : word.toCharArray()) {
                if (curr.count == 1) {
                    break;
                }
                builder.append(c);
                curr = curr.children.get(c);
            }
            result.add(builder.toString());

        }
        // [jon, joh, ja, t]
        return result;
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        int count = 0;
    }


}
