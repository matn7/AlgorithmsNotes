package whiteboard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RemoveIslands {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1},
                {0, 0, 1, 0, 1, 0},
                {1, 1, 0, 0, 1, 0},
                {1, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 1}
        };

        RemoveIslands removeIslands = new RemoveIslands();
        removeIslands.removeIslands(matrix);
    }

    // O(wh) time | O(wh) space
    // #2: 17/06/2022
    public int[][] removeIslands(int[][] matrix) {
        // Write your code here.
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (isOnBorder(row, col, matrix) && matrix[row][col] == 1) {
                    explore(row, col, matrix, visited);
                }
            }
        }
        // change 1 to 0 and 2 to 1
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 1) {
                    matrix[row][col] = 0;
                }
                if (matrix[row][col] == 2) {
                    matrix[row][col] = 1;
                }
            }
        }
        return matrix;
    }

    private void explore(int row, int col, int[][] matrix, boolean[][] visited) {
        Queue<Coords> queue = new LinkedList<>();
        queue.add(new Coords(row, col));
        while (!queue.isEmpty()) {
            Coords currCell = queue.poll();
            int currRow = currCell.row;
            int currCol = currCell.col;
            if (matrix[currRow][currCol] == 0) {
                visited[currRow][currCol] = true;
                continue;
            }
            matrix[currRow][currCol] = 2;
            visited[currRow][currCol] = true;
            List<Coords> neighbors = getNeighbors(currRow, currCol, matrix, visited);
            for (Coords neighbor : neighbors) {
                queue.add(neighbor);
            }
        }
    }

    private List<Coords> getNeighbors(int row, int col, int[][] matrix, boolean[][] visited) {
        List<Coords> result = new ArrayList<>();
        if (row > 0) {
            if (!visited[row - 1][col]) {
                result.add(new Coords(row - 1, col));
            }
        }
        if (row < matrix.length - 1) {
            if (!visited[row + 1][col]) {
                result.add(new Coords(row + 1, col));
            }
        }
        if (col > 0) {
            if (!visited[row][col - 1]) {
                result.add(new Coords(row, col - 1));
            }
        }
        if (col < matrix[row].length - 1) {
            if (!visited[row][col + 1]) {
                result.add(new Coords(row, col + 1));
            }
        }

        return result;
    }

    private boolean isOnBorder(int row, int col, int[][] matrix) {
        return row == 0 || row == matrix.length - 1 || col == 0 || col == matrix[row].length - 1;
    }

    static class Coords {
        int row;
        int col;

        public Coords(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}
