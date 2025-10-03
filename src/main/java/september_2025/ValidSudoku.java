package september_2025;

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

    // O(1) time | O(1) space
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            Set<Integer> cols = new HashSet<>();
            Set<Integer> rows = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    int numR = board[j][i] - '0';
                    if (cols.contains(numR)) {
                        return false;
                    }
                    cols.add(numR);
                }
                if (board[i][j] != '.') {
                    int numC = board[i][j] - '0';
                    if (rows.contains(numC)) {
                        return false;
                    }
                    rows.add(numC);
                }
            }
            int col = i % 3;
            int row = (i * 3) % 3;
        }
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Set<Integer> grid = new HashSet<>();
                for (int r = row * 3; r < row * 3 + 3; r++) {
                    for (int c = col * 3; c < col * 3 + 3; c++) {
                        if (board[r][c] == '.') {
                            continue;
                        }
                        int numG = board[r][c] - '0';
                        if (grid.contains(numG)) {
                            return false;
                        }
                        grid.add(numG);
                    }
                }
            }
        }
        return true;
    }

}
