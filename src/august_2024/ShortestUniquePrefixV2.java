package august_2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestUniquePrefixV2 {

    public static void main(String[] args) {
        String[] words = {"jon", "john", "jack", "techlead"};
        ShortestUniquePrefixV2 prefix = new ShortestUniquePrefixV2(words);
        prefix.shortestUniquePrefix(words);
    }

    TrieNode root = new TrieNode();

    public ShortestUniquePrefixV2(String[] words) {
        init(words);
    }

    // O(n*m) time | O(n*m) space
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


    public List<String> shortestUniquePrefix(String[] words) {
        List<String> result = new ArrayList<>();

        for (String word : words) {
            TrieNode curr = root;
            StringBuilder builder = new StringBuilder();
            for (char c : word.toCharArray()) {
                if (curr.count == 1) {
                    break;
                }
                curr = curr.children.get(c);
                builder.append(c);
            }
            result.add(builder.toString());
        }

        return result;
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        int count;
    }

}
