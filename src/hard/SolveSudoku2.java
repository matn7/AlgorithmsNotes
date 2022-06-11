package hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolveSudoku2 {

    public static void main(String[] args) {
        int[][] board =
                       {{8,0,0,4,0,6,0,0,7},
                        {0,0,0,0,0,0,4,0,0},
                        {0,1,0,0,0,0,6,5,0},
                        {5,0,9,0,3,0,7,8,0},
                        {0,0,0,0,7,0,0,0,0},
                        {0,4,8,0,2,0,1,0,3},
                        {0,5,2,0,0,0,0,9,0},
                        {0,0,1,0,0,0,0,0,0},
                        {3,0,0,9,0,2,0,0,5}};

        boolean b = checkSudoku(board);
        System.out.println(b);
        solveSudoku(board);

    }

    public static int[][] solveSudoku(int[][] board) {
        // Write your code here.
        int[][] tempBoard = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                tempBoard[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // check if value is 0
                if (board[i][j] == 0) {
                    // try insert number from 1 to 9
                    for (int num = 1; num <= 9; num++) {
                        board[i][j] = num;
                        if (checkSudoku(board)) {
                            break;
                        } else {
                            // revert back to 0
                            board[i][j] = 0;
                        }
                    }
                    if (board[i][j] == 0) {
                        System.out.println("Not found " + i + ":" + j);
                        // retry
                        // redo row
                        int idx = 0;
                        int valueToRetry = 0;
                        for (int k = 0; k < 9; k++) {
                            if (tempBoard[i][k] == 0) {
                                if (idx == 0 && valueToRetry == 0) {
                                    idx = k;
                                    valueToRetry = board[i][k];
                                }
                                board[i][k] = 0;
                            }
                        }
                        System.out.println();
                    }
                }
            }
        }
        return new int[][] {};
    }

    public ArrayList<ArrayList<Integer>> solveSudoku(ArrayList<ArrayList<Integer>> board) {
        // Write your code here.
        return new ArrayList<ArrayList<Integer>>();
    }


    public static boolean checkSudoku(int[][] board) {
        // Write your code here.
        List<Set<Integer>> rows = new ArrayList<>();
        List<Set<Integer>> cols = new ArrayList<>();
        List<Set<Integer>> cells = new ArrayList<>();
        // rows, cols: no duplicate element in row and column
        for (int i = 0; i < 9; i++) {
            rows.add(i, new HashSet<>());
            cols.add(i, new HashSet<>());
            cells.add(i, new HashSet<>());
        }

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                int cell = board[row][col];
                if (cell != 0) {
                    if (rows.get(row).contains(cell) || cols.get(col).contains(cell)) {
                        return false;
                    }
                    rows.get(row).add(cell);
                    cols.get(col).add(cell);
                }
            }
        }

        int cellIdx = 0;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                for (int miniRow = 0; miniRow < 3; miniRow++) {
                    for (int miniCol = 0; miniCol < 3; miniCol++) {
                        int x = row * 3 + miniRow;
                        int y = col * 3 + miniCol;
                        int cell = board[x][y];
                        if (cell != 0) {
                            if (cells.get(cellIdx).contains(cell)) {
                                return false;
                            }
                            cells.get(cellIdx).add(cell);
                        }
                    }
                }
                cellIdx++;
            }
        }

        return true;
    }
}
