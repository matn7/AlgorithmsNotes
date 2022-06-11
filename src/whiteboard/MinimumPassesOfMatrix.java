package whiteboard;

import java.util.ArrayList;
import java.util.List;

public class MinimumPassesOfMatrix {

    public static void main(String[] args) {
//        int[][] matrix = {
//                {0, -1, -3, 2, 0},
//                {1, -2, -5, -1, -3},
//                {3, 0, 0, -4, -1}
//        };

        int[][] matrix = {
                {-1, 0, 3},
                {0, -5, -6}
        };

        MinimumPassesOfMatrix min = new MinimumPassesOfMatrix();
        int result = min.minimumPassesOfMatrix(matrix);
        System.out.println();
    }

    // O(w * h) time | O(w * h) space
    public int minimumPassesOfMatrix(int[][] matrix) {
        // Write your code here.
        int passes = 0;

        boolean toExplore = true;
        List<Coord> toChangeList = new ArrayList<>();

        while (toExplore) {
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    if (matrix[row][col] >= 0) {
                        continue;
                    }
                    explore(matrix, row, col, toChangeList);
                }
            }
            if (toChangeList.isEmpty()) {
                toExplore = false;
                break;
            }
            passes += 1;
            update(matrix, toChangeList);
            toChangeList.clear();
        }

        // final check whether there are negative value elements
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] < 0) {
                    return -1;
                }
            }
        }

        return passes;
    }

    private void update(int[][] matrix, List<Coord> toChangeList) {
        for (Coord coord : toChangeList) {
            matrix[coord.row][coord.col] *= -1;
        }
    }

    private void explore(int[][] matrix, int row, int col, List<Coord> toChangeList) {
        int currVal = matrix[row][col];
        List<Coord> neighbors = getNeighbors(matrix, row, col);
        boolean toChange = false;
        for (Coord neighbor : neighbors) {
            if (matrix[neighbor.row][neighbor.col] > 0) {
                toChange = true;
                break;
            }
        }
        if (toChange) {
            toChangeList.add(new Coord(row, col));
        }
    }

    private List<Coord> getNeighbors(int[][] matrix, int row, int col) {
        List<Coord> neighbors = new ArrayList<>();
        if (row > 0) {
            neighbors.add(new Coord(row - 1, col));
        }
        if (row < matrix.length - 1) {
            neighbors.add(new Coord(row + 1, col));
        }
        if (col > 0) {
            neighbors.add(new Coord(row, col - 1));
        }
        if (col < matrix[row].length - 1) {
            neighbors.add(new Coord(row, col + 1));
        }
        return neighbors;
    }


    static class Coord {
        int row;
        int col;

        public Coord(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}
