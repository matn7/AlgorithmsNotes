package january_2026;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens {

    public static void main(String[] args) {
        int n = 4;

        NQueens nQueens = new NQueens();
        List<List<String>> result = nQueens.solveNQueens(n);
        System.out.println(result);
    }

    // O(n!) time | O(n^2) space
    public List<List<String>> solveNQueens(int n) {
        Set<Integer> cols = new HashSet<>();
        Set<Integer> posDiag = new HashSet<>();
        Set<Integer> negDiag = new HashSet<>();
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                board[r][c] = '.';
            }
        }
        backtrack(0, n, cols, posDiag, negDiag, board, result);

        return result;
    }

    private void backtrack(int r, int n, Set<Integer> cols, Set<Integer> posDiag, Set<Integer> negDiag, char[][] board,
                           List<List<String>> result) {
        if (r == n) {
            // add
            List<String> oneRes = new ArrayList<>();
            
            for (int row = 0; row < n; row++) {
                StringBuilder oneRow = new StringBuilder();
                for (int col = 0; col < n; col++) {
                    oneRow.append(board[row][col]);
                }
                oneRes.add(oneRow.toString());
            }
            
            result.add(oneRes);
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
