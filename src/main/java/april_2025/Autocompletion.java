package april_2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Autocompletion {

    public static void main(String[] args) {
        String[] words = {"dog", "door", "dark", "cat", "elephant", "elemelek"};
        String word = "x";
        Autocompletion autocompletion = new Autocompletion(words);
        List<String> result = autocompletion.autocompletion(word);
        System.out.println(result);
    }

    TrieNode root;
    public Autocompletion(String[] words) {
        root = new TrieNode();
        populateTrie(words);
    }

    public List<String> autocompletion(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return new ArrayList<>();
            }
            curr = curr.children.get(c);
        }

        List<String> result = new ArrayList<>();

        StringBuilder builder = new StringBuilder();
        builder.append(word);

        populateList(curr, builder, result);

        return result;
    }

    private void populateList(TrieNode node, StringBuilder builder, List<String> result) {
        if (node.endWord) {
            result.add(builder.toString());
            return;
        }
        for (Map.Entry<Character, TrieNode> elem : node.children.entrySet()) {
            builder.append(elem.getKey());
            populateList(elem.getValue(), builder, result);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean endWord = false;
    }

    private void populateTrie(String[] words) {
        for (String word : words) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new TrieNode());
                }
                curr = curr.children.get(c);
            }
            curr.endWord = true;

        }
    }

}
