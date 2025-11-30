package november_2025;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        for (int r = 0; r < 9; r++) {
            Set<Integer> cols = new HashSet<>();
            Set<Integer> rows = new HashSet<>();
            for (int c = 0; c < 9; c++) {
                char col = board[r][c];
                char row = board[c][r];
                if (col != '.') {
                    if (cols.contains(col - '0')) {
                        return false;
                    }
                    cols.add(col - '0');
                }
                if (row != '.') {
                    if (rows.contains(row - '0')) {
                        return false;
                    }
                    rows.add(row - '0');
                }
            }
        }

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Set<Integer> grid = new HashSet<>();
                for (int r = row * 3; r < row * 3 + 3; r++) {
                    for (int c = col * 3; c < col * 3 + 3; c++) {
                        char curr = board[r][c];
                        if (curr == '.') {
                            continue;
                        }
                        if (grid.contains(curr - '0')) {
                            return false;
                        }
                        grid.add(curr - '0');
                    }
                }
            }
        }
        return true;
    }

}
