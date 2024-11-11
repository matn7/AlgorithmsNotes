package october_2024;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
        Map<String, Set<Integer>> squares = new HashMap<>();

        Map<Integer, Set<Integer>> cols = new HashMap<>();
        Map<Integer, Set<Integer>> rows = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            cols.put(i, new HashSet<>());
            rows.put(i, new HashSet<>());
        }

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                String key = r + ":" + c;
                squares.put(key, new HashSet<>());
            }
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    continue;
                }
                String key = (r / 3)  + ":" + (c / 3);
                int num = board[r][c] - '0';
                if (rows.get(r).contains(num) ||
                    cols.get(c).contains(num) ||
                    squares.get(key).contains(num)) {
                    return false;
                }
                cols.get(c).add(num);
                rows.get(r).add(num);
                squares.get(key).add(num);
            }
        }
        return true;
    }



}
