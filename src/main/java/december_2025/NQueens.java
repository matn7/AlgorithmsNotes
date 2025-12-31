package december_2025;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens {

    public static void main(String[] args) {
        int n = 4;
        NQueens nQueens = new NQueens();
        List<List<String>> lists = nQueens.solveNQueens(n);
        System.out.println(lists);
    }

    // O(n!) time | O(n) space
    public List<List<String>> solveNQueens(int n) {

        Set<Integer> cols = new HashSet<>();
        Set<Integer> posDiag = new HashSet<>();
        Set<Integer> negDiag = new HashSet<>();

        String[][] board = new String[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                board[r][c] = ".";
            }
        }

        List<List<String>> result = new ArrayList<>();
        backtrack(n, 0, cols, posDiag, negDiag, board, result);

        return result;
    }

    private void backtrack(int n, int r, Set<Integer> cols, Set<Integer> posDiag, Set<Integer> negDiag,  String[][] board, List<List<String>> res) {
        if (r == n) {
            // result
            List<String> oneRes = new ArrayList<>();
            for (int row = 0; row < n; row++) {
                StringBuilder builder = new StringBuilder();
                for (int col = 0; col < n; col++) {
                    builder.append(board[row][col]);
                }
                oneRes.add(builder.toString());
            }
            res.add(oneRes);
            return;
        }

        for (int c = 0; c < n; c++) {
            if (cols.contains(c) || posDiag.contains(r + c) || negDiag.contains(r - c)) {
                continue;
            }
            cols.add(c);
            posDiag.add(r + c);
            negDiag.add(r - c);
            board[r][c] = "Q";

            backtrack(n, r + 1, cols, posDiag, negDiag, board, res);

            cols.remove(c);
            posDiag.remove(r + c);
            negDiag.remove(r - c);
            board[r][c] = ".";
        }
    }


}
