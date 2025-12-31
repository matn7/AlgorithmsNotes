package december_2025;

import java.util.*;

public class WordSearchII {

    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'},
        };

        String[] words = {"oath","pea","eat","rain"};

        WordSearchII wordSearchII = new WordSearchII();
        List<String> result = wordSearchII.findWords(board, words);
        System.out.println(result);
    }

    // O(N * L + m * n * 3L) time | O(N * L) space
    Trie trie;

    public List<String> findWords(char[][] board, String[] words) {
        trie = new Trie(words);
        Trie.TrieNode root = trie.root;
        Set<String> result = new HashSet<>();
        StringBuilder builder = new StringBuilder();

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                helper(board, r, c, root, builder, result);
            }
        }

        return new ArrayList<>(result);
    }

    private void helper(char[][] board, int r, int c, Trie.TrieNode curr, StringBuilder builder, Set<String> result) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[r].length || board[r][c] == '#' || curr.children[board[r][c] - 'a'] == null) {
            return;
        }
        char ch = board[r][c];
        board[r][c] = '#';
        builder.append(ch);
        curr = curr.children[ch - 'a'];
        if (curr != null && curr.word) {
            result.add(builder.toString());
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : directions) {
            helper(board, r + dir[0], c + dir[1], curr, builder, result);
        }

        board[r][c] = ch;
        builder.deleteCharAt(builder.length() - 1);
    }

    static class Trie {
        TrieNode root;
        public Trie(String[] words) {
            root = new TrieNode();
            insert(words);
        }

        private void insert(String[] words) {
            for (String word : words) {
                TrieNode curr = root;
                for (char c : word.toCharArray()) {
                    if (curr.children[c - 'a'] == null) {
                        curr.children[c - 'a'] = new TrieNode();
                    }
                    curr = curr.children[c - 'a'];
                }
                curr.word = true;
            }
        }

        static class TrieNode {
            // Map<Character, TrieNode> children = new HashMap<>();
            TrieNode[] children = new TrieNode[26];
            boolean word;
        }
    }

}

