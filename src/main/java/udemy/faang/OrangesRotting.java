package udemy.faang;

import java.util.LinkedList;
import java.util.Queue;

public class OrangesRotting {

    public static void main(String[] args) {
//        int[][] matrix = {
//                {2, 0, 1, 0, 0},
//                {1, 1, 0, 0, 2},
//                {0, 1, 1, 1, 1},
//                {0, 1, 0, 0, 1}
//        };

        int[][] matrix = {
                {2, 1, 1, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 1, 1, 1, 1},
                {0, 1, 0, 0, 1}
        };

        OrangesRotting orangesRotting = new OrangesRotting();
        int result = orangesRotting.orangesRotting(matrix);
        System.out.println(result);
    }

    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int ROTTEN = 2;
    int FRESH = 1;
    int EMPTY = 0;

    // O(w * h) time | O(w * h) space
    public int orangesRotting(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        Queue<Coord> queue = new LinkedList<>();
        int freshOranges = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == ROTTEN) {
                    queue.add(new Coord(row, col));
                }
                if (matrix[row][col] == FRESH) {
                    freshOranges++;
                }
            }
        }

        int currentQueueSize = 0;
        int minutes = 0;
        while (!queue.isEmpty()) {
            if (currentQueueSize == 0) {
                minutes++;
                currentQueueSize = queue.size();
            }
            Coord currentOrange = queue.poll();
            currentQueueSize--;
            int row = currentOrange.row;
            int col = currentOrange.col;
            for (int i = 0; i < directions.length; i++) {
                int[] currentDir = directions[i];
                int nextRow = row + currentDir[0];
                int nextCol = col + currentDir[1];
                if (nextRow < 0 || nextRow >= matrix.length || nextCol < 0 || nextCol >= matrix[nextRow].length) {
                    continue;
                }
                if (matrix[nextRow][nextCol] == FRESH) {
                    matrix[nextRow][nextCol] = ROTTEN;
                    freshOranges--;
                    queue.add(new Coord(nextRow, nextCol));
                }
            }
        }
        if (freshOranges > 0) {
            return -1;
        }
        return minutes;
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
