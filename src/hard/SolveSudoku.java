package hard;

import java.util.*;

public class SolveSudoku {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> board = new ArrayList<>();

        board.add(new ArrayList<>(Arrays.asList(0, 2, 0, 0, 9, 0, 1, 0, 0)));
        board.add(new ArrayList<>(Arrays.asList(0, 0, 7, 8, 0, 0, 0, 0, 0)));
        board.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 3, 6, 0)));
        board.add(new ArrayList<>(Arrays.asList(0, 0, 1, 9, 0, 4, 0, 0, 0)));
        board.add(new ArrayList<>(Arrays.asList(0, 0, 0, 6, 0, 5, 0, 0, 7)));
        board.add(new ArrayList<>(Arrays.asList(8, 0, 0, 0, 0, 0, 0, 0, 9)));
        board.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 2, 0, 0, 0, 0)));
        board.add(new ArrayList<>(Arrays.asList(7, 0, 0, 0, 0, 0, 0, 8, 5)));
        board.add(new ArrayList<>(Arrays.asList(4, 9, 0, 0, 3, 0, 0, 0, 0)));

        SolveSudoku solveSudoku = new SolveSudoku();
        solveSudoku.solveSudoku(board);
    }

    public ArrayList<ArrayList<Integer>> solveSudoku(ArrayList<ArrayList<Integer>> board) {
        // Write your code here.
        solvePartialSudoku(0, 0, board);
        return board;
    }

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
        return solvePartialSudoku(currentRow, currentCol+1, board);
    }

    private boolean tryDigitsAtPosition(int row, int col, ArrayList<ArrayList<Integer>> board) {
        for (int digit = 1; digit < 10; digit++) {
            if (isValidAtPosition(digit, row, col, board)) {
                board.get(row).remove(col);
                board.get(row).add(col, digit);
                if (solvePartialSudoku(row, col + 1, board)) {
                    return true;
                }
            }
        }
        board.get(row).remove(col);
        board.get(row).add(col, 0);
        return false;
    }

    private boolean isValidAtPosition(int value, int row, int col, ArrayList<ArrayList<Integer>> board) {
        boolean rowIsValid = true;
        boolean colIsValid = true;
        for (Integer element : board.get(row)) {
            if (value == element) {
                rowIsValid = false;
            }
        }

        for (int rowIdx = 0; rowIdx < 9; rowIdx++) {
            if (value == board.get(rowIdx).get(col)) {
                colIsValid = false;
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
                int existingValue = board.get(rowToCheck).get(colToCheck);

                if (existingValue == value) {
                    return false;
                }
            }
        }
        return true;
    }
}
