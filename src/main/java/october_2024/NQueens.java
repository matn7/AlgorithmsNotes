package october_2024;

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
        Set<Integer> col = new HashSet<>();
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
        backtrack(0, n, board, col, posDiag, negDiag, result);
        return result;
    }

    private void backtrack(int r, int n, List<List<String>> board, Set<Integer> col,
                           Set<Integer> posDiag, Set<Integer> negDiag, List<List<String>> result) {
        if (r == n) {
            List<List<String>> newBoard = new ArrayList<>(board);
            List<String> oneRes = new ArrayList<>();
            for (List<String> b : newBoard) {
                StringBuilder builder = new StringBuilder();
                for (String b1 : b) {
                    builder.append(b1);
                }
                oneRes.add(builder.toString());
            }
            result.add(oneRes);
            return;
        }
        for (int c = 0; c < n; c++) {
            if (col.contains(c) || posDiag.contains(r + c) || negDiag.contains(r - c)) {
                continue;
            }
            col.add(c);
            posDiag.add(r + c);
            negDiag.add(r - c);
            board.get(r).set(c, "Q");
            backtrack(r + 1, n, board, col, posDiag, negDiag, result);
            col.remove(c);
            posDiag.remove(r + c);
            negDiag.remove(r - c);
            board.get(r).set(c, ".");
        }
    }



}
