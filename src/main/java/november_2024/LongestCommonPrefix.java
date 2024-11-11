package november_2024;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = { "flower", "flow", "flowight" };

        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String result = longestCommonPrefix.longestCommonPrefix(strs);
        System.out.println(result);
    }

    TrieNode root = new TrieNode();

    public String longestCommonPrefix(String[] strs) {
        generateTrie(strs);
        int count = strs.length;
        StringBuilder builder = new StringBuilder();
        TrieNode curr = root;
        buildPrefix(curr, builder, count);
        return builder.toString();
    }

    private void buildPrefix(TrieNode node, StringBuilder builder, int count) {
        for (Map.Entry<Character, TrieNode> elem : node.children.entrySet()) {
            if (elem.getValue().count != count) {
                return;
            }
            char c = elem.getKey();
            builder.append(c);
            buildPrefix(node.children.get(c), builder, count);
        }
    }

    private void generateTrie(String[] strs) {
        for (String str : strs) {
            TrieNode curr = root;
            for (char c : str.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new TrieNode());
                }
                curr = curr.children.get(c);
                curr.count++;
            }
        }
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        int count;
    }

}
