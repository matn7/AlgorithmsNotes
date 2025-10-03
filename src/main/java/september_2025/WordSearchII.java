package september_2025;

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
        populateTrie(root, words);
        StringBuilder builder = new StringBuilder();

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                char ch = board[r][c];
                if (root.children.containsKey(ch)) {
                    backtrack(r, c, board, root, builder, result);
                }
            }
        }

        return new ArrayList<>(result);
    }

    private void backtrack(int r, int c, char[][] board, TrieNode curr, StringBuilder builder, Set<String> result) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[r].length || board[r][c] == '#' || !curr.children.containsKey(board[r][c])) {
            return;
        }
        char ch = board[r][c];
        board[r][c] = '#';
        builder.append(ch);
        curr = curr.children.get(ch);
        if (curr.word) {
            result.add(builder.toString());
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : directions) {
            backtrack(r + dir[0], c + dir[1], board, curr, builder, result);
        }
        builder.deleteCharAt(builder.length() - 1);
        board[r][c] = ch;
    }

    private void populateTrie(TrieNode root, String[] words) {
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
        boolean word;
    }


}
