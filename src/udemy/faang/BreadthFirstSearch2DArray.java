package udemy.faang;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch2DArray {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}
        };

        traversalBFS(matrix);
    }

    static int[][] directions = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };

    // O(n) time | O(n) space
    private static List<Integer> traversalBFS(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        Queue<Coord> queue = new LinkedList<>();
        queue.add(new Coord(2, 2));
        while (!queue.isEmpty()) {
            Coord currentPos = queue.poll();
            int row = currentPos.row;
            int col = currentPos.col;
            if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[row].length || visited[row][col]) {
                continue;
            }
            visited[row][col] = true;
            result.add(matrix[row][col]);
            for (int i = 0; i < directions.length; i++) {
                int[] currentDir = directions[i];
                queue.add(new Coord(row + currentDir[0], col + currentDir[1]));
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
