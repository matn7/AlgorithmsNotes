package june_2025;

import java.util.*;

public class WordSearchII {

    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        String[] words = {"oath", "pea", "eat", "rain"};

        WordSearchII wordSearchII = new WordSearchII();
        List<String> result = wordSearchII.findWords(board, words);
        System.out.println(result);
    }

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        TrieNode root = new TrieNode();
        populate(root, words);
        StringBuilder builder = new StringBuilder();
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                helper(board, r, c, visited, builder, root, result);
            }
        }

        return new ArrayList<>(result);
    }

    private void helper(char[][] board, int r, int c, boolean[][] visited, StringBuilder builder,
                        TrieNode curr, Set<String> result) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[r].length || visited[r][c]
                || !curr.children.containsKey(board[r][c])) {
            return;
        }
        char w = board[r][c];
        curr = curr.children.get(w);
        builder.append(w);
        if (curr.word) {
            result.add(builder.toString());
        }

        visited[r][c] = true;
        helper(board, r + 1, c, visited, builder, curr, result);
        helper(board, r - 1, c, visited, builder, curr, result);
        helper(board, r, c + 1, visited, builder, curr, result);
        helper(board, r, c - 1, visited, builder, curr, result);

        visited[r][c] = false;
        builder.deleteCharAt(builder.length() - 1);
    }

    private void populate(TrieNode root, String[] words) {
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

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean word = false;
    }

}
