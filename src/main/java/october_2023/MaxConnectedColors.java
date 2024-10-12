package october_2023;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxConnectedColors {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1, 2, 2, 2},
                {0, 0, 1, 2, 2, 2},
                {0, 0, 1, 0, 0, 0},
                {0, 1, 1, 1, 0, 2},
                {0, 0, 1, 1, 2, 0}
        };

        int result = maxConnectedColors(matrix);
        System.out.println();
    }

    // O(n) time | O(n) space
    public static int maxConnectedColors(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (!visited[row][col]) {
//                    int explored = explore(matrix, row, col, visited);
                    int explored = dfs(matrix, row, col, visited);
                    max = Math.max(max, explored);
                }
            }
        }
        return max;
    }

    private static int dfs(int[][] matrix, int row, int col, boolean[][] visited) {
        if (visited[row][col]) {
            return 0;
        }
        int color = matrix[row][col];
        visited[row][col] = true;
        int value = 1;

        List<int[]> neighbors = getNeighbors(matrix, row, col, color);
        for (int[] neighbor : neighbors) {
            value += dfs(matrix, neighbor[0], neighbor[1], visited);
        }

        return value;
    }


    private static int explore(int[][] matrix, int row, int col, boolean[][] visited) {
        int color = matrix[row][col]; // 1
        int value = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {row, col});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currRow = current[0];
            int currCol = current[1];
            if (visited[currRow][currCol]) {
                continue;
            }
            if (matrix[currRow][currCol] != color) {
                continue;
            }
            visited[currRow][currCol] = true;
            value++;
            List<int[]> neighbors = getNeighbors(matrix, currRow, currCol, color);
            queue.addAll(neighbors);
        }

        return value;
    }

    private static List<int[]> getNeighbors(int[][] matrix, int row, int col, int color) {
        List<int[]> neighbors = new ArrayList<>();
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] direction : directions) {
            if (isValidPosition(matrix, row, col, direction)) {
                if (matrix[row + direction[0]][col + direction[1]] == color) {
                    neighbors.add(new int[] {row + direction[0], col + direction[1]});
                }
            }
        }
        return neighbors;
    }

    private static boolean isValidPosition(int[][] matrix, int row, int col, int[] direction) {
        return row + direction[0] >= 0 && row + direction[0] <= matrix.length - 1
                && col + direction[1] >= 0 && col + direction[1] <= matrix[row].length - 1;
    }
}
