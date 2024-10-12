package whiteboard;

import java.util.ArrayList;
import java.util.List;

public class MinimumPassesOfMatrix2 {

    public static void main(String[] args) {
        int[][] matrix = {
                {0, -1, -3, 2, 0},
                {1, -2, -5, -1, -3},
                {3, 0, 0, -4, 1}
        };

        MinimumPassesOfMatrix2 mpm2 = new MinimumPassesOfMatrix2();
        mpm2.minimumPassesOfMatrix(matrix);
    }

    public int minimumPassesOfMatrix(int[][] matrix) {
        // Write your code here.
        int counter = 0;
        boolean finished = false;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        List<Coord> coords = new ArrayList<>();

        while (!finished) {
            finished = true;
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    if (matrix[row][col] > 0) {
                        collectCoord(matrix, row, col, coords, visited);
                    }
                }
            }
            if (!coords.isEmpty()) {
                counter++;
                finished = false;
            } else {
                finished = true;
                continue;
            }
            while (!coords.isEmpty()) {
                Coord coord = coords.remove(coords.size() - 1);
                int x = coord.x;
                int y = coord.y;
                matrix[x][y] *= -1;
                visited[x][y] = false;
            }

        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] < 0) {
                    return -1;
                }
            }
        }

        return counter;
    }

    private void collectCoord(int[][] matrix, int row, int col, List<Coord> coords, boolean[][] visited) {
        if (row > 0 && matrix[row - 1][col] < 0) {
            if (!visited[row - 1][col]) {
                visited[row - 1][col] = true;
                coords.add(new Coord(row - 1, col));
            }
        }
        if (row < matrix.length - 1 && matrix[row + 1][col] < 0) {
            if (!visited[row + 1][col]) {
                visited[row + 1][col] = true;
                coords.add(new Coord(row + 1, col));
            }
        }
        if (col > 0 && matrix[row][col - 1] < 0) {
            if (!visited[row][col - 1]) {
                visited[row][col - 1] = true;
                coords.add(new Coord(row, col - 1));
            }
        }
        if (col < matrix[row].length - 1 && matrix[row][col + 1] < 0) {
            if (!visited[row][col + 1]) {
                visited[row][col + 1] = true;
                coords.add(new Coord(row, col + 1));
            }
        }
    }

    static class Coord {
        int x;
        int y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
