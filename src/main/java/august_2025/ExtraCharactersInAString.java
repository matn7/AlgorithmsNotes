package august_2025;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ExtraCharactersInAString {

    public static void main(String[] args) {

//        String s = "leetscode";
//        String[] dictionary = {"leet","code","leetcode"};

        String s = "sayhelloworld";
        String[] dictionary = {"hello","world"};

        ExtraCharactersInAString extraCharactersInAString = new ExtraCharactersInAString();
        int result = extraCharactersInAString.minExtraChar(s, dictionary);
        System.out.println(result);
    }

    // O(n^2 + m * k) time | O(n + m * k) space
    // Where n is the length of the string s, m is the number of words in the dictionary, and k is the average length of a word in the dictionary.
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> words = new HashSet<>();
        for (String str : dictionary) {
            words.add(str);
        }
        TrieNode trie = new Trie(dictionary).root;

        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(s.length(), 0);
        return dfs(s, 0, trie, dp);
    }

    private int dfs(String s, int i, TrieNode root, Map<Integer, Integer> dp) {
        if (dp.containsKey(i)) {
            return dp.get(i);
        }
        int res = 1 + dfs(s, i + 1, root, dp);
        TrieNode curr = root;
        for (int j = i; j < s.length(); j++) {
            if (!curr.children.containsKey(s.charAt(j))) {
                break;
            }
            curr = curr.children.get(s.charAt(j));
            if (curr.word) {
                res = Math.min(res, dfs(s, j + 1, root, dp));
            }
        }
        dp.put(i, res);
        return res;
    }

    static class Trie {
        TrieNode root;
        public Trie(String[] words) {
            root = new TrieNode();
            for (String word : words) {
                TrieNode curr = root;
                for (char c : word.toCharArray()) {
                    if (!curr.children.containsKey(c)) {
                        curr.children.put(c, new TrieNode());
                    }
                    curr = curr.children.get(c);
                }
                curr.word = true;
            }

        }
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean word = false;
    }


}
