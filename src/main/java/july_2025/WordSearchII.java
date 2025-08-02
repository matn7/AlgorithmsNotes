package july_2025;

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

    TrieNode root = new TrieNode();
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        populateTrie(words);
        boolean[][] seen = new boolean[board.length][board[0].length];
        StringBuilder builder = new StringBuilder();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                searchWord(board, r, c, root, seen, builder, result);
            }
        }

        return new ArrayList<>(result);
    }

    private void searchWord(char[][] board, int r, int c, TrieNode node, boolean[][] seen, StringBuilder builder, Set<String> result) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[r].length || seen[r][c] || !node.children.containsKey(board[r][c])) {
            return;
        }
        char curr = board[r][c];
        builder.append(curr);
        seen[r][c] = true;

        node = node.children.get(curr);

        if (node.word) {
            result.add(builder.toString());
        }

        for (int[] dir : directions) {
            searchWord(board, r + dir[0], c + dir[1], node, seen, builder, result);
        }

        seen[r][c] = false;
        builder.deleteCharAt(builder.length() - 1);
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
            curr.word = true;
        }
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean word = false;
    }

}
