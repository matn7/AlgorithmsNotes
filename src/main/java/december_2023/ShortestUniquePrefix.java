package december_2023;

import java.util.HashMap;
import java.util.Map;

public class ShortestUniquePrefix {

    public static void main(String[] args) {
        String[] strings = {"foods", "zig", "foo", "zag", "face"};
        String[] result = new ShortestUniquePrefix().shortestUniquePrefixes(strings);
        System.out.println(result);
    }

    // n - num of strings
    // m - length of the longest string
    // O(n*m) time | O(n*m) space
    public String[] shortestUniquePrefixes(String[] strings) {
        // Write your code here.
        Trie trie = new Trie(strings);
        return getPrefixes(strings, trie);
    }

    private static String[] getPrefixes(String[] strings, Trie trie) {
        String[] result = new String[strings.length];
        int resIdx = 0;
        for (String string : strings) {
            int idx = 0;
            TrieNode curr = trie.root;
            while (idx < string.length() - 1) {
                curr = curr.children.get(string.charAt(idx));
                if (curr.count == 1) {
                    break;
                }
                idx++;
            }
            result[resIdx] = string.substring(0, idx + 1);
            resIdx++;
        }
        return result;
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        int count;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        public Trie(String[] strings) {
            for (String string : strings) {
                insert(string);
            }
        }

        private void insert(String string) {
            TrieNode curr = root;
            for (int i = 0; i < string.length(); i++) {
                char c = string.charAt(i);
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new TrieNode());
                }
                curr = curr.children.get(c);
                curr.count++;
            }
        }
    }

}
