package january_2024;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslands {

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 1, 1, 1},
                {1, 0, 1, 1, 0},
                {0, 1, 1, 0, 0},
                {1, 0, 0, 1, 1}
        };

        numberOfIslands(matrix);
    }

    // O(n) time | O(n) space
    public static int numberOfIslands(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int number = 0;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (!visited[row][col] && isLand(matrix, row, col)) {
                    number++;
                    explore(matrix, row, col, visited);
                }
            }
            System.out.println();
        }

        return number;
    }

    private static void explore(int[][] matrix, int row, int col, boolean[][] visited) {
        if (visited[row][col] || !isLand(matrix, row, col)) {
            return;
        }
        visited[row][col] = true;
        List<int[]> neighbors = getNeighbors(matrix, row, col, visited);

        for (int[] neighbor : neighbors) {
            explore(matrix, neighbor[0], neighbor[1], visited);
        }
    }

    private static List<int[]> getNeighbors(int[][] matrix, int row, int col,  boolean[][] visited) {
        List<int[]> neighbors = new ArrayList<>();
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] direction : directions) {
            if (isValidPosition(matrix, row + direction[0], col + direction[1])) {
                if (!visited[row + direction[0]][col + direction[1]]) {
                    neighbors.add(new int[] {row + direction[0], col + direction[1]});
                }
            }
        }
        return neighbors;
    }

    private static boolean isValidPosition(int[][] matrix, int row, int col) {
        return row >= 0 && row <= matrix.length - 1 && col >= 0 && col <= matrix[row].length - 1;
    }

    private static boolean isLand(int[][] matrix, int row, int col) {
        return matrix[row][col] == 0;
    }

}
