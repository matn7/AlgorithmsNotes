package june_2025;

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
        for (int c = 0; c < board[0].length; c++) {
            Set<Integer> rows = new HashSet<>();
            for (int r = 0; r < board.length; r++) {
                if (board[r][c] == '.') {
                    continue;
                }
                int num = board[r][c] - '0';
                if (rows.contains(num)) {
                    return false;
                }
                rows.add(num);
            }
        }
        // check cols
        for (int r = 0; r < board.length; r++) {
            Set<Integer> cols = new HashSet<>();
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] == '.') {
                    continue;
                }
                int num = board[r][c] - '0';
                if (cols.contains(num)) {
                    return false;
                }
                cols.add(num);
            }
        }

        // check grid
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Set<Integer> grid = new HashSet<>();
                for (int r = 3 * row; r < 3 * row + 3; r++) {
                    for (int c = 3 * col; c < 3 * col + 3; c++) {
                        if (board[r][c] == '.') {
                            continue;
                        }
                        int num = board[r][c] - '0';
                        if (grid.contains(num)) {
                            return false;
                        }
                        grid.add(num);
                    }
                }
            }
        }
        return true;
    }

}
