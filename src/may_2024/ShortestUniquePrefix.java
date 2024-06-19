package may_2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestUniquePrefix {

    public static void main(String[] args) {
        String[] words = {"john", "jon", "jack", "techlead"};

        ShortestUniquePrefix shortestUniquePrefix = new ShortestUniquePrefix(words);

        List<String> shortestPrefix = new ArrayList<>();
        for (String word : words) {
            String prefix = shortestUniquePrefix.uniquePrefix(word);
            shortestPrefix.add(prefix);
        }
        System.out.println(shortestPrefix);
    }

    TrieNode root = new TrieNode();

    public ShortestUniquePrefix(String[] words) {
        populateTrie(words);
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
        }
    }

    public String uniquePrefix(String word) {
        TrieNode curr = root;
        StringBuilder builder = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (curr.count == 1) {
                break;
            }
            builder.append(c);
            curr = curr.children.get(c);
        }
        return builder.toString();
    }


    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        int count;
    }


}
