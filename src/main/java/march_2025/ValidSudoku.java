package march_2025;

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
        // valid rows
        Set<Integer> validRow = new HashSet<>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == '.') {
                    continue;
                }
                int num = board[row][col] - '0';
                if (validRow.contains(num)) {
                    return false;
                }
                validRow.add(num);
            }
            validRow = new HashSet<>();
        }

        // valid cols
        Set<Integer> validCol = new HashSet<>();
        for (int col = 0; col < board[0].length; col++) {
            for (int row = 0; row < board.length; row++) {
                if (board[row][col] == '.') {
                    continue;
                }
                int num = board[row][col] - '0';
                if (validCol.contains(num)) {
                    return false;
                }
                validCol.add(num);
            }
            validCol = new HashSet<>();
        }

        // valid 3 x 3 grid
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Set<Integer> nums = new HashSet<>();
                for (int r = row * 3; r < row * 3 + 3; r++) {
                    for (int c = col * 3; c < col * 3 + 3; c++) {
                        if (board[r][c] == '.') {
                            continue;
                        }
                        int num = board[r][c] - '0';
                        if (nums.contains(num)) {
                            return false;
                        }
                        nums.add(num);
                    }
                }

            }
        }
        return true;
    }

}
