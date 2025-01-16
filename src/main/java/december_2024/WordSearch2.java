package december_2024;

import javax.print.DocFlavor;
import java.util.HashSet;
import java.util.Set;

public class WordSearch2 {

    public boolean exist(char[][] board, String word) {
        int ROWS = board.length;
        int COLS = board[0].length;
        Set<String> path = new HashSet<>();

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (dfs(r, c, 0, ROWS, COLS, board, path, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int r, int c, int i, int ROWS, int COLS, char[][] board, Set<String> path, String word) {
        if (i == word.length()) {
            return true;
        }
        String key = r + ":" + c;
        if (r < 0 || c < 0 || r >= ROWS || c >= COLS || word.charAt(i) != board[r][c] || path.contains(key)) {
            return false;
        }
        path.add(key);
        boolean res = dfs(r + 1, c, i + 1, ROWS, COLS, board, path, word) ||
                dfs(r - 1, c, i + 1, ROWS, COLS, board, path, word) ||
                dfs(r, c + 1, i + 1, ROWS, COLS, board, path, word) ||
                dfs(r, c - 1, i + 1, ROWS, COLS, board, path, word);
        path.remove(key);
        return res;
    }

}
