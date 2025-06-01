package may_2025;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };
        ValidSudoku validSudoku = new ValidSudoku();
        boolean result = validSudoku.isValidSudoku(board);
        System.out.println(result);
    }

    public boolean isValidSudoku(char[][] board) {
        // check rows
        for (int col = 0; col < 9; col++) {
            Set<Character> rows = new HashSet<>();
            for (int row = 0; row < 9; row++) {
                char digit = board[row][col];
                if (digit == '.') {
                    continue;
                }
                if (rows.contains(digit)) {
                    return false;
                }
                rows.add(digit);
            }
        }

        // check cols
        for (int row = 0; row < 9; row++) {
            Set<Character> cols = new HashSet<>();
            for (int col = 0; col < 9; col++) {
                char digit = board[row][col];
                if (digit == '.') {
                    continue;
                }
                if (cols.contains(digit)) {
                    return false;
                }
                cols.add(digit);
            }
        }

        // check 3x3 grid
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Set<Character> grid = new HashSet<>();
                for (int r = row * 3; r < row * 3 + 3; r++) {
                    for (int c = col * 3; c < col * 3 + 3; c++) {
                        char digit = board[r][c];
                        if (digit == '.') {
                            continue;
                        }
                        if (grid.contains(digit)) {
                            return false;
                        }
                        grid.add(digit);
                    }
                }
            }
        }
        return true;
    }

}
