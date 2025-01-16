package november_2024;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;

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
        boolean rowValid = checkRow(board);
        boolean colValid = checkCol(board);
        boolean qubeValid = checkCube(board);
        return rowValid && colValid && qubeValid;
    }

    private boolean checkCube(char[][] board) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Set<Integer> qubes = new HashSet<>();
                for (int r = 3 * row; r < 3 * row + 3; r++) {
                    for (int c = 3 * col; c < 3 * col + 3; c++) {
                        if (board[r][c] == '.') {
                            continue;
                        }
                        int num = board[r][c] - '0';
                        if (qubes.contains(num)) {
                            return false;
                        }
                        qubes.add(num);
                    }
                }
                System.out.println();
            }
        }
        return true;
    }

    private boolean checkCol(char[][] board) {
        for (int col = 0; col < board[0].length; col++) {
            Set<Integer> cols = new HashSet<>();
            for (int row = 0; row < board.length; row++) {
                if (board[row][col] == '.') {
                    continue;
                }
                int num = board[row][col] - '0';
                if (cols.contains(num)) {
                    return false;
                }
                cols.add(num);
            }
        }
        return true;
    }

    private boolean checkRow(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            Set<Integer> rows = new HashSet<>();
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == '.') {
                    continue;
                }
                int num = board[row][col] - '0';
                if (rows.contains(num)) {
                    return false;
                }
                rows.add(num);
            }
        }
        return true;
    }

}
