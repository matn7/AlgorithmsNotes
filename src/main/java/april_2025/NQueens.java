package april_2025;

import java.util.*;

public class NQueens {

    // O(n!) time | O(n^2) space
    public List<List<String>> solveNQueens(int n) {
        Set<Integer> col = new HashSet<>();
        Set<Integer> posDiag = new HashSet<>();
        Set<Integer> negDiag = new HashSet<>();
        char[][] board = new char[n][n];

        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        List<List<String>> result = new ArrayList<>();

        backtrack(0, n, col, posDiag, negDiag, board, result);

        return result;
    }

    private void backtrack(int r, int n, Set<Integer> col, Set<Integer> posDiag, Set<Integer> negDiag,
                           char[][] board, List<List<String>> res) {
        if (r == n) {
            List<String> oneRes = new ArrayList<>();
            for (char[] row : board) {
                oneRes.add(new String(row));
            }
            res.add(oneRes);
            return;
        }

        for (int c = 0; c < n; c++) {
            if (col.contains(c) || posDiag.contains(r + c) || negDiag.contains(r - c)) {
                continue;
            }
            col.add(c);
            posDiag.add(r + c);
            negDiag.add(r - c);
            board[r][c] = 'Q';

            backtrack(r + 1, n, col, posDiag, negDiag, board, res);

            col.remove(c);
            posDiag.remove(r + c);
            negDiag.remove(r - c);
            board[r][c] = '.';
        }

    }

}
