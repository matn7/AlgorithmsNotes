package whiteboard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RemoveIslands2 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1},
                {0, 0, 1, 0, 1, 0},
                {1, 1, 0, 0, 1, 0},
                {1, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 1}
        };

        RemoveIslands2 ri2 = new RemoveIslands2();
        ri2.removeIslands(matrix);
    }

    public int[][] removeIslands(int[][] matrix) {
        // Write your code here.
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (isOnBorder(matrix, row, col) && !visited[row][col]) {
                    if (matrix[row][col] == 1) {
                        explore(matrix, row, col, visited);
                    }
                }
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 1) {
                    matrix[row][col] = 0;
                } else if (matrix[row][col] == 2) {
                    matrix[row][col] = 1;
                }
            }
        }

        return matrix;
    }

    private void explore(int[][] matrix, int row, int col, boolean[][] visited) {
        Queue<Coords> queue = new LinkedList<>();
        queue.add(new Coords(row, col));
        while (!queue.isEmpty()) {
            Coords frontElement = queue.poll();
            int currRow = frontElement.row;
            int currCol = frontElement.col;
            int frontVal = matrix[currRow][currCol];
            if (frontVal == 0) {
                visited[currRow][currCol] = true;
                continue;
            }
            visited[currRow][currCol] = true;
            matrix[currRow][currCol] = 2;
            List<Coords> neighbors = getNeighbord(matrix, currRow, currCol, visited);
            for (Coords neighbor : neighbors) {
                queue.add(neighbor);
            }
        }
    }

    private List<Coords> getNeighbord(int[][] matrix, int row, int col, boolean[][] visited) {
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

    private boolean isOnBorder(int[][] matrix, int row, int col) {
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
