package september_2023;

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

        riverSizes(matrix);
    }

    // O(w * h) time | O(w * h) space
    public static List<Integer> riverSizes(int[][] matrix) {
        // Write your code here.
        List<Integer> result = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (!visited[row][col] && matrix[row][col] == 1) {
                    explore(matrix, row, col, visited, result);
                }
            }
        }
        return result;
    }

    private static void explore(int[][] matrix, int row, int col, boolean[][] visited, List<Integer> result) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {row, col});

        int size = 0;

        while (!queue.isEmpty()) {
            int[] polled = queue.poll();
            int currRow = polled[0];
            int currCol = polled[1];
            if (visited[currRow][currCol]) {
                continue;
            }
            visited[currRow][currCol] = true;
            if (matrix[currRow][currCol] == 0) {
                continue;
            }
            size++;
            List<int[]> neighbors = getNeighbors(matrix, currRow, currCol, visited);
            for (int[] neighbor : neighbors) {
                queue.add(neighbor);
            }
        }

        if (size != 0) {
            result.add(size);
        }
    }

    private static List<int[]> getNeighbors(int[][] matrix, int row, int col, boolean[][] visited) {
        List<int[]> result = new ArrayList<>();
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        for (int[] d : directions) {
            if (isWithinRange(matrix, row, col, d) && !visited[row + d[0]][col + d[1]]) {
                result.add(new int[] {row + d[0], col + d[1]});
            }
        }
        return result;

    }

    private static boolean isWithinRange(int[][] matrix, int row, int col, int[] direction) {
        return row + direction[0] >= 0 && row + direction[0] < matrix.length
                && col + direction[1] >= 0 && col + direction[1] < matrix[row].length;
    }


}
