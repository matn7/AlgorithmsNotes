package december_2023;

import java.util.ArrayList;
import java.util.List;

public class RevealMinesweeper {

    public static void main(String[] args) {
        String[][] board = {
                {"0", "1", "H", "H", "M"},
                {"H", "1", "M", "H", "1"},
                {"H", "H", "H", "H", "H"},
                {"H", "H", "H", "M", "H"}
        };

        RevealMinesweeper revealMinesweeper = new RevealMinesweeper();
        revealMinesweeper.revealMinesweeper(board, 2, 2);
    }

    // O(w*h) time | O(w*h) space
    public String[][] revealMinesweeper(String[][] board, int row, int column) {
        // Write your code here.
        if (board[row][column].equals("M")) {
            board[row][column] = "X";
            return board;
        }
        List<Integer[]> neighbors = getNeighbors(board, row, column);
        int adjacentMinesCount = 0;
        for (Integer[] neighbor : neighbors) {
            Integer neighborRow = neighbor[0];
            Integer neighborColumn = neighbor[1];
            if (board[neighborRow][neighborColumn].equals("M")) {
                adjacentMinesCount++;
            }
        }

        if (adjacentMinesCount > 0) {
            board[row][column] = String.valueOf(adjacentMinesCount);
        } else {
            board[row][column] = "0";
            for (Integer[] neighbor : neighbors) {
                int neighborRow = neighbor[0];
                int neighborColumn = neighbor[1];
                if (board[neighborRow][neighborColumn].equals("H")) {
                    revealMinesweeper(board, neighborRow, neighborColumn);
                }
            }
        }
        return board;
    }

    private List<Integer[]> getNeighbors(String[][] board, int row, int column) {
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}, {1,1}, {1,-1}, {-1,1}, {-1,-1}};
        List<Integer[]> neighbors = new ArrayList<>();
        for (int[] direction : directions) {
            int directionRow = direction[0];
            int directionColumn = direction[1];
            int newRow = row + directionRow;
            int newColumn = column + directionColumn;
            if (newRow >= 0 && newRow < board.length && newColumn>= 0 && newColumn < board[0].length) {
                neighbors.add(new Integer[]{newRow, newColumn});
            }
        }
        return neighbors;
    }
}
