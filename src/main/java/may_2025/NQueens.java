package may_2025;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens {

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        List<List<String>> lists = nQueens.solveNQueens(4);
        System.out.println(lists);
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        Set<Integer> cols = new HashSet<>();
        Set<Integer> negPart = new HashSet<>();
        Set<Integer> posPart = new HashSet<>();
        char[][] board = new char[n][n];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                board[r][c] = '.';
            }
        }

        backtrack(0, n, cols, negPart, posPart, board, result);

        return result;
    }

    private void backtrack(int r, int n, Set<Integer> cols, Set<Integer> negPart, Set<Integer> posPart, char[][] board,
                           List<List<String>> res) {
        if (r == n) {
            List<String> part = new ArrayList<>();
            for (char[] row : board) {
                part.add(new String(row));
            }
            res.add(part);
            return;
        }

        for (int c = 0; c < n; c++) {
            if (cols.contains(c) || negPart.contains(r - c) || posPart.contains(r + c)) {
                continue;
            }
            cols.add(c);
            negPart.add(r - c);
            posPart.add(r + c);
            board[r][c] = 'Q';

            backtrack(r + 1, n, cols, negPart, posPart, board, res);

            cols.remove(c);
            negPart.remove(r - c);
            posPart.remove(r + c);
            board[r][c] = '.';
        }
    }

}
