package problems.hard;

import java.util.ArrayList;

public class SolveSudoku {

    // O(1) time | O(1) space
    // OK - repeated 01/02/2022
    public ArrayList<ArrayList<Integer>> solveSudoku(ArrayList<ArrayList<Integer>> board) {
        // Write your code here.
        solvePartialSudoku(0, 0, board);
        return board;
    }

//       {{8,0,0,4,0,6,0,0,7},
//        {0,0,0,0,0,0,4,0,0},
//        {0,1,0,0,0,0,6,5,0},
//        {5,0,9,0,3,0,7,8,0},
//        {0,0,0,0,7,0,0,0,0},
//        {0,4,8,0,2,0,1,0,3},
//        {0,5,2,0,0,0,0,9,0},
//        {0,0,1,0,0,0,0,0,0},
//        {3,0,0,9,0,2,0,0,5}}
    private boolean solvePartialSudoku(int row, int col, ArrayList<ArrayList<Integer>> board) {
        int currentRow = row; // 0
        int currentCol = col; // 2

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
            if (isValidAtPosition(digit, row, col, board)) { // 3
                board.get(row).set(col, digit);
                if (solvePartialSudoku(row, col + 1, board)) {
                    return true;
                }
            }
        }
        board.get(row).set(col, 0);
        return false;
    }

    private boolean isValidAtPosition(int value, int row, int col, ArrayList<ArrayList<Integer>> board) {
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

        int subgridRowStart = row / 3;
        int subgridColStart = col / 3;
        for (int rowIdx = 0; rowIdx < 3; rowIdx++) {
            for (int colIdx = 0; colIdx < 3; colIdx++) {
                int rowToCheck = subgridRowStart * 3 + rowIdx;
                int colToCheck = subgridColStart * 3 + colIdx;
                Integer existingValue = board.get(rowToCheck).get(colToCheck);
                if (existingValue == value) {
                    return false;
                }
            }
        }
        return true;
    }

}
