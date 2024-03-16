package coderpro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NQueens {

    static int[][] matrix;

    public static void main(String[] args) {
        matrix = new int[5][5];

        NQueens nQueens = new NQueens();
        List<Integer[]> integers = nQueens.nQueens(5);
        System.out.println();
    }

    // REPEAT

    // O(n^n) time | O(6n) -> O(n) space
    public List<Integer[]> nQueens(int n) {
        List<Boolean> col = new ArrayList<>();
        List<Boolean> row = new ArrayList<>();
        List<Boolean> asc_diag = new ArrayList<>();
        List<Boolean> desc_diag = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            col.add(true);
            row.add(true);
        }
        
        for (int i = 0; i < n * 2 - 1; i++) {
            asc_diag.add(true);
            desc_diag.add(true);
        }
        
        List<Integer[]> queen_pos = new ArrayList<>();
        nqueens_helper(n, col, row, asc_diag, desc_diag, queen_pos);
        return queen_pos;
    }

    private void nqueens_helper(int n, List<Boolean> col, List<Boolean> row, List<Boolean> asc_diag,
                                List<Boolean> desc_diag, List<Integer[]> queen_pos) {
        int curr_row = queen_pos.size();
        for (int curr_col = 0; curr_col < n; curr_col++) {
            if (col.get(curr_col) && row.get(curr_row)
                    && (curr_row - curr_col > 0)
                    && asc_diag.get(curr_row + curr_col) && desc_diag.get(curr_row - curr_col)) {
                col.set(curr_col, false);
                row.set(curr_row, false);
                asc_diag.set(curr_row + curr_col, false);
                desc_diag.set(curr_row - curr_col, false);
                queen_pos.add(new Integer[] {curr_row, curr_col});
                nqueens_helper(n, row, col, asc_diag, desc_diag, queen_pos);
                if (queen_pos.size() == n) {
                    return;
                }

                // backtrack
                col.set(curr_col, true);
                row.set(curr_row, true);
                asc_diag.set(curr_row + curr_col, true);
                desc_diag.set(curr_row - curr_col, true);
                queen_pos.remove(queen_pos.size() - 1);
            }
        }
    }

}
