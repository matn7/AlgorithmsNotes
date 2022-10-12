package udemy.faang;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch2DArray {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}
        };

        traversalDFS(matrix);
    }

    static int[][] directions = {
            {-1, 0},    // UP
            {0, 1},     // RIGHT
            {1, 0},     // DOWN
            {0, -1}     // LEFT
    };

    // O(n) time | O(n) space
    public static List<Integer> traversalDFS(int[][] matrix) {
        boolean[][] seen = new boolean[matrix.length][matrix[0].length];
        List<Integer> result = new ArrayList<>();
        dfs(matrix, 0, 0, seen, result);
        return result;
    }

    private static void dfs(int[][] matrix, int row, int col, boolean[][] seen, List<Integer> result) {
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[row].length || seen[row][col]) {
            return;
        }
        result.add(matrix[row][col]);
        seen[row][col] = true;
        for (int i = 0; i < directions.length; i++) {
            int[] currentDirection = directions[i];
            dfs(matrix, row + currentDirection[0], col + currentDirection[1], seen, result);
        }
    }

}
