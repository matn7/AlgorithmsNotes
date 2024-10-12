package november_2023;

import java.util.HashMap;
import java.util.Map;

public class SuffixTrieConstruction {

    public static void main(String[] args) {
        String str = "abac";
        SuffixTrieConstruction suffixTrieConstruction = new SuffixTrieConstruction(str);

        System.out.println(suffixTrieConstruction.contains("ac"));
    }

    TrieNode root;


    public SuffixTrieConstruction(String str) {
        root = new TrieNode();
        populateSuffixTrie(str);
    }

    // O(n^2) time | O(n^2) space
    private void populateSuffixTrie(String str) {
        for (int i = 0; i < str.length(); i++) {
            TrieNode curr = root;
            for (int j = i; j < str.length(); j++) {
                char c = str.charAt(j);
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new TrieNode());
                }
                curr = curr.children.get(c);
            }
            curr.children.put('*', null);
        }
    }

    // O(m) time | O(1) space
    public boolean contains(String str) {
        TrieNode curr = root;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return curr.children.containsKey('*');
    }


    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
    }
}
