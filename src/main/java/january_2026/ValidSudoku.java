package january_2026;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args) {
        char[][] board = {
                {'.','.','4','.','.','.','6','3','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'5','.','.','.','.','.','.','9','.'},
                {'.','.','.','5','6','.','.','.','.'},
                {'4','.','3','.','.','.','.','.','1'},
                {'.','.','.','7','.','.','.','.','.'},
                {'.','.','.','5','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'}
        };

        ValidSudoku validSudoku = new ValidSudoku();
        boolean result = validSudoku.isValidSudoku(board);
        System.out.println(result);
    }

    // O(1) time | O(1) spce
    public boolean isValidSudoku(char[][] board) {
        List<Set<Integer>> rows = new ArrayList<>();
        List<Set<Integer>> cols = new ArrayList<>();
        List<List<Set<Integer>>> subGrid = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
        }
        for (int i = 0; i < 3; i++) {
            subGrid.add(new ArrayList<>());
            for (int j = 0; j < 3; j++) {
                subGrid.get(i).add(new HashSet<>());
            }
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    continue;
                }
                int num = board[r][c] - '0';

                if (rows.get(r).contains(num)) {
                    return false;
                }
                if (cols.get(c).contains(num)) {
                    return false;
                }
                if (subGrid.get(r / 3).get(c / 3).contains(num)) {
                    return false;
                }
                rows.get(r).add(num);
                cols.get(c).add(num);
                subGrid.get(r / 3).get(c / 3).add(num);
            }
        }
        return true;
    }

    public boolean isValidSudoku2(char[][] board) {
        Set<Integer> cols = new HashSet<>();
        Set<Integer> rows = new HashSet<>();
        Set<Integer> grid = new HashSet<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    int numCol = board[r][c] - '0';
                    if (cols.contains(numCol)) {
                        return false;
                    }
                    cols.add(numCol);
                }
                if (board[c][r] != '.') {
                    int numRow = board[c][r] - '0';
                    if (rows.contains(numRow)) {
                        return false;
                    }
                    rows.add(numRow);
                }
            }
            rows.clear();
            cols.clear();
        }

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                for (int r = 3 * row; r < 3 * row + 3; r++) {
                    for (int c = 3 * col; c < 3 * col + 3; c++) {
                        if (board[r][c] != '.') {
                            int numGrid = board[r][c] - '0';
                            if (grid.contains(numGrid)) {
                                return false;
                            }
                            grid.add(numGrid);
                        }
                    }
                }
                grid.clear();
            }
        }
        return true;
    }

}
