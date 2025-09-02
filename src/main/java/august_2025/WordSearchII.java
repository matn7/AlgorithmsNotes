package august_2025;

import java.util.*;

public class WordSearchII {

    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        String[] words = {"oath","pea","eat","rain"};

        WordSearchII wordSearchII = new WordSearchII();
        List<String> result = wordSearchII.findWords(board, words);
        System.out.println(result);
    }

    // O(n * m * 4^m*n) time
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        TrieNode root = new TrieNode();
        populate(root, words);
        StringBuilder builder = new StringBuilder();

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (root.children.containsKey(board[r][c])) {
                    dfs(board, r, c, root, builder, result);
                }
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, StringBuilder builder, Set<String> result) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[r].length || board[r][c] == '#' || !node.children.containsKey(board[r][c])) {
            return;
        }
        char ch = board[r][c];
        board[r][c] = '#';
        builder.append(ch);
        node = node.children.get(ch);
        if (node.word) {
            result.add(builder.toString());
        }

        dfs(board, r + 1, c, node, builder, result);
        dfs(board, r - 1, c, node, builder, result);
        dfs(board, r, c + 1, node, builder, result);
        dfs(board, r, c - 1, node, builder, result);

        builder.deleteCharAt(builder.length() - 1);
        board[r][c] = ch;
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
