package may_2025;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens2 {

    public static void main(String[] args) {
        NQueens2 nQueens2 = new NQueens2();
        int n = 4;
        List<List<String>> result = nQueens2.solveNQueens(n);

        System.out.println(result);

    }

    // O(n!) time | O(n^2) space
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                board[r][c] = '.';
            }
        }
        List<List<String>> result = new ArrayList<>();
        Set<Integer> cols = new HashSet<>();
        Set<Integer> posDiag = new HashSet<>();
        Set<Integer> negDiag = new HashSet<>();
        backtrack(n, 0, board, cols, posDiag, negDiag, result);
        return result;
    }

    private void backtrack(int n, int r, char[][] board, Set<Integer> cols,
                           Set<Integer> posDiag, Set<Integer> negDiag, List<List<String>> result) {
        if (r == n) {
            List<String> oneRes = new ArrayList<>();
            for (char[] row : board) {
                oneRes.add(new String(row));
            }
            result.add(oneRes);
            return;
        }

        for (int c = 0; c < n; c++) {
            if (cols.contains(c) || posDiag.contains(r + c) || negDiag.contains(r- c)) {
                continue;
            }
            cols.add(c);
            posDiag.add(r + c);
            negDiag.add(r - c);
            board[r][c] = 'Q';

            backtrack(n, r + 1, board, cols, posDiag, negDiag, result);

            cols.remove(c);
            posDiag.remove(r + c);
            negDiag.remove(r - c);
            board[r][c] = '.';
        }
    }

}
