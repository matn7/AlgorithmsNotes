package whiteboard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RemoveIslands {

    // O(n * m) time | O(n * m) space
    public int[][] removeIslands(int[][] matrix) {
        // Write your code here.
        if (matrix.length == 0) {
            return matrix;
        }
        boolean[][] seen = new boolean[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (isOnBorder(matrix, row, col) && !seen[row][col]) {
                    explore(matrix, row, col, seen);
                }
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 2) {
                    matrix[row][col] = 1;
                } else if (matrix[row][col] == 1) {
                    matrix[row][col] = 0;
                }
            }
        }

        return matrix;
    }

    private void explore(int[][] matrix, int row, int col, boolean[][] seen) {
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{row, col});
        while (!queue.isEmpty()) {
            Integer[] current = queue.poll();
            int currentRow = current[0];
            int currentCol = current[1];
            if (matrix[currentRow][currentCol] == 0) {
                seen[currentRow][currentCol] = true;
                continue;
            }
            if (seen[currentRow][currentCol]) {
                continue;
            }
            seen[currentRow][currentCol] = true;
            matrix[currentRow][currentCol] = 2;
            List<Integer[]> neighbors = getNeighbors(matrix, currentRow, currentCol, seen);
            for (Integer[] neighbor : neighbors) {
                queue.add(neighbor);
            }
        }

    }

    private List<Integer[]> getNeighbors(int[][] matrix, int row, int col, boolean[][] seen) {
        List<Integer[]> neighbors = new ArrayList<>();
        if (row > 0 && !seen[row - 1][col]) {
            neighbors.add(new Integer[]{row - 1, col});
        }
        if (row < matrix.length - 1 && !seen[row + 1][col]) {
            neighbors.add(new Integer[]{row + 1, col});
        }
        if (col > 0 && !seen[row][col - 1]) {
            neighbors.add(new Integer[]{row, col - 1});
        }
        if (col < matrix[row].length - 1 && !seen[row][col + 1]) {
            neighbors.add(new Integer[]{row, col + 1});
        }
        return neighbors;
    }

    private boolean isOnBorder(int[][] matrix, int row, int col) {
        return row == 0 || row == matrix.length - 1 || col == 0 || col == matrix[row].length - 1;
    }

}
