package udemy.faang;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 1},
                {0, 0, 0, 1, 1}
        };
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        numberOfIslands.numberOfIslands(matrix);
    }

    int[][] directions = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };

    // O(m * n) time | O(max(m,n)) space
    public int numberOfIslands(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int islandsCount = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 1) {
                    islandsCount++;
                    matrix[row][col] = 0;
                    Queue<Coord> queue = new LinkedList<>();
                    queue.add(new Coord(row, col));
                    while (!queue.isEmpty()) {
                        Coord currPos = queue.poll();
                        int currRow = currPos.row;
                        int currCol = currPos.col;
                        for (int i = 0; i < directions.length; i++) {
                            int[] currDir = directions[i];
                            int nextRow = currRow + currDir[0];
                            int nextCol = currCol + currDir[1];
                            if (nextRow < 0 || nextRow >= matrix.length || nextCol < 0 || nextCol >= matrix[nextRow].length) {
                                continue;
                            }
                            if (matrix[nextRow][nextCol] == 1) {
                                queue.add(new Coord(nextRow, nextCol));
                                matrix[nextRow][nextCol] = 0;
                            }
                        }
                    }
                }
            }
        }
        return islandsCount;
    }

    class Coord {
        int row;
        int col;

        public Coord(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}
