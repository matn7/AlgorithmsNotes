package whiteboard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RiverSizes {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0}
        };

        List<Integer> result = riverSizes(matrix);
        System.out.println(result);
    }

    // O(wh) time | O(wh) space (to verify in future - 14.05.2022)
    // #2: 15/06/2022
    // random: 14/07/2022 - 28/07/2022
    public static List<Integer> riverSizes(int[][] matrix) {
        // Write your code here.
        List<Integer> result = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (!visited[row][col]) {
                    System.out.println(row + ":" + col);
                    explore(row, col, matrix, result, visited);
                }
            }
        }

        return result;
    }

    private static void explore(int row, int col, int[][] matrix, List<Integer> result, boolean[][] visited) {
        Queue<Coord> queue = new LinkedList<>(); // Queue add some Entity Class like Coords containing x and y
        queue.add(new Coord(row, col));
        int currentLength = 0;
        while (!queue.isEmpty()) {
            Coord currentCell = queue.poll();
            int currRow = currentCell.row;
            int currCol = currentCell.col;
            int currentValue = matrix[currRow][currCol];
            if (currentValue == 0) {
                visited[currRow][currCol] = true;
                continue;
            }
            if (visited[currRow][currCol]) {
                continue;
            }
            visited[currRow][currCol] = true;
            currentLength++;

            List<Coord> neighbors = getNeighbors(currRow, currCol, matrix, visited); // O(1)
            for (Coord neighbor : neighbors) { // O(4)
                queue.add(new Coord(neighbor.row, neighbor.col));
            }

        }
        if (currentLength != 0) {
            result.add(currentLength);
        }
    }

    private static List<Coord> getNeighbors(int row, int col, int[][] matrix, boolean[][] visited) {
        List<Coord> result = new ArrayList<>();
        if (row > 0) {
            if (!visited[row - 1][col]) {
                result.add(new Coord(row - 1, col));
            }
        }
        if (row < matrix.length - 1) {
            if (!visited[row + 1][col]) {
                result.add(new Coord(row + 1, col));
            }
        }
        if (col > 0) {
            if (!visited[row][col - 1]) {
                result.add(new Coord(row, col - 1));
            }
        }
        if (col < matrix[row].length - 1) {
            if (!visited[row][col + 1]) {
                result.add(new Coord(row, col + 1));
            }
        }
        return result;
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
