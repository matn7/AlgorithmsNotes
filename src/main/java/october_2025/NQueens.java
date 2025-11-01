package october_2025;

import java.util.*;

public class NQueens {

    public static void main(String[] args) {
        int n = 4;
        NQueens nQueens = new NQueens();
        List<List<String>> result = nQueens.solveNQueens(n);
        System.out.println(result);
    }

    // O(n!) time | O(n^2) space
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        Set<Integer> cols = new HashSet<>();
        Set<Integer> posDiag = new HashSet<>();
        Set<Integer> negDiag = new HashSet<>();

        List<List<String>> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(".");
            }
            board.add(row);
        }

        backtrack(n, 0, cols, posDiag, negDiag, board, result);

        return result;
    }

    private void backtrack(int n, int r, Set<Integer> cols, Set<Integer> posDiag, Set<Integer> negDiag,
                           List<List<String>> board, List<List<String>> result) {
        if (r == n) {
            List<String> newRow = new ArrayList<>();
            for (List<String> row : board) {
                StringBuilder oneRow = new StringBuilder();
                for (int i = 0; i < row.size(); i++) {
                    oneRow.append(row.get(i));
                }
                newRow.add(oneRow.toString());
            }
            result.add(newRow);
            return;
        }

        for (int c = 0; c < n; c++) {
            if (cols.contains(c) || posDiag.contains(r + c) || negDiag.contains(r - c)) {
                continue;
            }
            cols.add(c);
            posDiag.add(r + c);
            negDiag.add(r - c);

            board.get(r).set(c, "Q");

            backtrack(n, r + 1, cols, posDiag, negDiag, board, result);

            board.get(r).set(c, ".");
            cols.remove(c);
            posDiag.remove(r + c);
            negDiag.remove(r - c);
        }
    }

}
