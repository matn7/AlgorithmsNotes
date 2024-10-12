package udemy.generalprogramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sudoku {

    public static boolean isValid(int[][] sudokuBoard) {
        // check whether all rows and columns have unique numbers 1-9. We will use a set to check
        // whether the number has been added before in that row or column.
        if (!isValidRowsAndColumns(sudokuBoard)) {
            return false;
        }

        // now check each 3x3 block to see if the numbers between 1-9 are repeated within that block
        if (!isValidBlocks(sudokuBoard)) {
            return false;
        }

        return true;
    }

    private static boolean isValidBlocks(int[][] sudokuBoard) {
        // have an integer set associated with each to check whether a number in that cell has occurred in the block before
        List<Set<Integer>> blockList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            blockList.add(new HashSet<>());
        }

        for (int rowBlock = 0; rowBlock < 3; rowBlock++) {
            for (int colBlock = 0; colBlock < 3; colBlock++) {
                // here we iterate over the cell in each block
                for (int miniRow = 0; miniRow < 3; miniRow++) {
                    for (int miniCol = 0; miniCol < 3; miniCol++) {
                        int row = rowBlock * 3 + miniRow;
                        int col = colBlock * 3 + miniCol;

                        int cellValue = sudokuBoard[row][col];

                        // if no value has been assigned to a cell then continue, don't perform any checks
                        if (cellValue == -1) {
                            continue;
                        }
                        if (cellValue < 1 || cellValue > 9) {
                            return false;
                        }
                        int blockNumber = rowBlock * 3 + colBlock;
                        if (blockList.get(blockNumber).contains(cellValue)) {
                            return false;
                        }
                        blockList.get(blockNumber).add(cellValue);
                    }
                }
            }
        }
        return true;
    }

    private static boolean isValidRowsAndColumns(int[][] sudokuBoard) {
        List<Set<Integer>> rowList = new ArrayList<>();
        List<Set<Integer>> columnList = new ArrayList<>();

        // initialize a set associated with each row and column
        for (int i = 0; i < 9; i++) {
            rowList.add(new HashSet<>());
            columnList.add(new HashSet<>());
        }

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // get the value in that sudoku cell
                int cellValue = sudokuBoard[row][col];
                // if no value has been assigned to a cell then continue, don't perform any checks
                if (cellValue == -1) {
                    continue;
                }
                if (cellValue < 1 || cellValue > 9) {
                    return false;
                }

                // if the value has been seen in that row or column before return false
                if (rowList.get(row).contains(cellValue)) {
                    return false;
                }
                if (columnList.get(col).contains(cellValue)) {
                    return false;
                }

                // add the current cell value to the row or column set
                rowList.get(row).add(cellValue);
                columnList.get(col).add(cellValue);
            }
        }
        return true;
    }

}
