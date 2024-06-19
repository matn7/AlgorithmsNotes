package june_2024;

import java.util.ArrayList;
import java.util.List;

public class SolveSudoku {

    public static void main(String[] args) {

    }

    public ArrayList<ArrayList<Integer>> solveSudoku(ArrayList<ArrayList<Integer>> board) {
        // Write your code here.
        solvePartialSudoku(0, 0, board);
        return board;
    }

    // O(1) time | O(1) space
    private boolean solvePartialSudoku(int row, int col, ArrayList<ArrayList<Integer>> board) {
        int currentRow = row;
        int currentCol = col;
        if (currentCol == board.get(row).size()) {
            currentRow++;
            currentCol = 0;
            if (currentRow == board.size()) {
                return true;
            }
        }
        if (board.get(currentRow).get(currentCol) == 0) {
            return tryDigitsAtPosition(currentRow, currentCol, board);
        }
        return solvePartialSudoku(currentRow, currentCol + 1, board);
    }

    private boolean tryDigitsAtPosition(int row, int col, ArrayList<ArrayList<Integer>> board) {
        for (int digit = 1; digit < 10; digit++) {
            if (isValid(digit, row, col, board)) {
                board.get(row).set(col, digit);
                if (solvePartialSudoku(row, col + 1, board)) {
                    return true;
                }

            }
        }
        board.get(row).set(col, 0);
        return false;
    }

    private boolean isValid(int value, int row, int col, ArrayList<ArrayList<Integer>> board) {
        boolean rowIsValid = !board.get(row).contains(value);
        boolean colIsValid = true;
        for (int r = 0; r < 9; r++) {
            if (board.get(r).get(col) == value) {
                colIsValid = false;
                break;
            }
        }
        if (!rowIsValid || !colIsValid) {
            return false;
        }

        int subgridRow = row / 3;
        int subgridCol = col / 3;

        for (int rowIdx = 0; rowIdx < 3; rowIdx++) {
            for (int colIdx = 0; colIdx < 3; colIdx++) {
                int rowToCheck = subgridRow * 3 + rowIdx;
                int colToCheck = subgridCol * 3 + colIdx;
                Integer existingValue = board.get(rowToCheck).get(colToCheck);
                if (existingValue == value) {
                    return false;
                }
            }
        }
        return true;
    }

}
