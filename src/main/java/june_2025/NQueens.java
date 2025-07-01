package june_2025;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens {

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        int n = 4;
        List<List<String>> result = nQueens.solveNQueens(n);
        System.out.println(result);
    }

    // O(n!) time | O(n^2) space
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                board[r][c] = '.';
            }
        }
        Set<Integer> cols = new HashSet<>();
        Set<Integer> posDiag = new HashSet<>();
        Set<Integer> negDiag = new HashSet<>();

        backtrack(0,  n, cols, posDiag, negDiag, board, result);
        return result;
    }

    private void backtrack(int r, int n, Set<Integer> cols, Set<Integer> posDiag,
                           Set<Integer> negDiag, char[][] board, List<List<String>> result) {
        if (r == n) {
            List<String> part = new ArrayList<>();
            for (char[] chars : board) {
                part.add(new String(chars));
            }
            result.add(part);
            return;
        }

        for (int c = 0; c < n; c++) {
            if (cols.contains(c) || posDiag.contains(r + c) || negDiag.contains(r - c)) {
                continue;
            }
            cols.add(c);
            posDiag.add(r + c);
            negDiag.add(r - c);
            board[r][c] = 'Q';

            backtrack(r + 1, n, cols, posDiag, negDiag, board, result);

            board[r][c] = '.';
            cols.remove(c);
            posDiag.remove(r + c);
            negDiag.remove(r - c);
        }
    }

}
