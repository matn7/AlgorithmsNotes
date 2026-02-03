package january_2026;

import java.util.HashMap;
import java.util.Map;

public class WordSearch {

    public static void main(String[] args) {
//        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        String word = "ABCB";

        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";

        WordSearch wordSearch = new WordSearch();
        boolean exist = wordSearch.exist(board, word);
        System.out.println(exist);
    }

    // O(n * m * 4^l) time | O(l) space
    public boolean exist(char[][] board, String word) {

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (word.charAt(0) == board[r][c]) {
                    boolean match = backtrack(board, r, c, 0, word);
                    if (match) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, int r, int c, int idx, String word) {
        if (idx == word.length()) {
            return true;
        }
        if (r < 0 || r >= board.length || c < 0 || c >= board[r].length || board[r][c] == '#' || word.charAt(idx) != board[r][c]) {
            return false;
        }
        char curr = board[r][c];
        board[r][c] = '#';
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for (int[] dir : directions) {
            boolean match = backtrack(board, r + dir[0], c + dir[1], idx + 1, word);
            if (match) {
                return true;
            }
        }
        board[r][c] = curr;
        return false;
    }


}
