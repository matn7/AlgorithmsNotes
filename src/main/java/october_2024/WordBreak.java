package october_2024;

import java.util.*;

public class WordBreak {

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();

        boolean result = wordBreak.wordBreak("leetcode", Arrays.asList("leet", "code"));
        System.out.println(result);
    }

    TrieNode root = new TrieNode();

    // O(s) time | O(n*m) space
    public boolean wordBreak(String s, List<String> wordDict) {
        initTrie(wordDict);
        return canBreak(s);
    }

    private boolean canBreak(String s) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[s.length() + 1];
        queue.add(0); // Start from the beginning of the string
        visited[0] = true; // Mark the start as visited

        while (!queue.isEmpty()) {
            int start = queue.poll();
            TrieNode curr = root;

            for (int i = start; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!curr.children.containsKey(c)) {
                    break; // Stop if no further matches in the trie
                }
                curr = curr.children.get(c);

                if (curr.endSymbol == '*') { // Found an end of a word
                    if (i + 1 == s.length()) {
                        return true; // Found a valid segmentation
                    }
                    if (!visited[i + 1]) {
                        visited[i + 1] = true; // Mark the next position as visited
                        queue.add(i + 1); // Enqueue the next starting position
                    }
                }
            }
        }

        return false; // No valid segmentation found
    }

    private void initTrie(List<String> wordDict) {
        for (String word : wordDict) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new TrieNode());
                }
                curr = curr.children.get(c);
            }
            curr.endSymbol = '*';
        }
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        char endSymbol;
    }

}
