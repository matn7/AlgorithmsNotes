package february_2024;

import java.util.ArrayList;
import java.util.List;

public class RevelMinesweeper {

    public static void main(String[] args) {
        String[][] board = {
                {"0", "1", "H", "H", "M"},
                {"H", "1", "M", "H", "1"},
                {"H", "H", "H", "H", "H"},
                {"H", "H", "H", "M", "H"}
        };

        String[][] mines = mines(board, 2, 2);
        for (int row = 0; row < mines.length; row++) {
            for (int col = 0; col < mines[row].length; col++) {
                System.out.print(mines[row][col]);
            }
            System.out.println();
        }
    }

    // O(w*h) time | O(w*h) space
    public static String[][] mines(String[][] board, int row, int col) {
        if (board[row][col].equals("M")) {
            board[row][col] = "X";
            return board;
        }

        List<Integer[]> neighbors = getNeighbors(board, row, col);
        int adjMinesCount = 0;
        for (Integer[] neighbor : neighbors) {
            int neighborRow = neighbor[0];
            int neighborCol = neighbor[1];
            if (board[neighborRow][neighborCol].equals("M")) {
                adjMinesCount++;
            }
        }

        if (adjMinesCount > 0) {
            board[row][col] = String.valueOf(adjMinesCount);
        } else {
            board[row][col] = "0";
            for (Integer[] neighbor : neighbors) {
                int neighborRow = neighbor[0];
                int neighborCol = neighbor[1];
                if (board[neighborRow][neighborCol].equals("H")) {
                    mines(board, neighborRow, neighborCol);
                }
            }
        }

        return board;
    }

    private static List<Integer[]> getNeighbors(String[][] board, int row, int col) {
        List<Integer[]> neighbors = new ArrayList<>();
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {1, 1}, {1, -1}, {-1, 0}, {-1, 1}, {-1, -1}};

        for (int[] direction : directions) {
            int dirRow = direction[0];
            int dirCol = direction[1];
            int newRow = row + dirRow;
            int newCol = col + dirCol;
            if (newRow >= 0 && newRow <= board.length - 1 && newCol >= 0 && newCol <= board[0].length - 1) {
                neighbors.add(new Integer[] {newRow, newCol});
            }
        }
        return neighbors;
    }

}
