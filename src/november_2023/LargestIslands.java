package november_2023;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestIslands {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 1, 1, 1, 1},
                {1, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
        };

        // 0 - land
        // 1 - water

        System.out.println(largestIsland(matrix));
    }

    // O(w^2 * h^2) time | O(w * h) space
    public static int largestIsland(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (isLand(matrix, row, col)) {
                    int explore = exploreRec(matrix, row, col);
                    max = Math.max(max, explore);
                }
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }

    private static int exploreRec(int[][] matrix, int row, int col) {
        if (!isLand(matrix, row, col)) {
            return 0;
        }
        sinkLand(matrix, row, col);
        int counter = 1;
        List<int[]> neighbors = getNeighbors(matrix, row, col);
        for (int[] neighbor : neighbors) {
            counter += exploreRec(matrix, neighbor[0], neighbor[1]);
        }
        return counter;
    }

    private static int explore(int[][] matrix, int row, int col) {
        int counter = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {row, col});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currRow = current[0];
            int currCol = current[1];
            if (!isLand(matrix, currRow, currCol)) {
                continue;
            }
            counter++;
            sinkLand(matrix, currRow, currCol);
            List<int[]> neighbors = getNeighbors(matrix, currRow, currCol);
            queue.addAll(neighbors);
        }

        return counter;
    }

    private static void sinkLand(int[][] matrix, int row, int col) {
        matrix[row][col] = 1;
    }

    private static List<int[]> getNeighbors(int[][] matrix, int row, int col) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        List<int[]> neighbors = new ArrayList<>();
        for (int[] direction : directions) {
            if (isValid(matrix, row, col, direction)) {
                neighbors.add(new int[] {row + direction[0], col + direction[1]});
            }
        }
        return neighbors;
    }

    private static boolean isValid(int[][] matrix, int row, int col, int[] direction) {
        return row + direction[0] >= 0 && row + direction[0] <= matrix.length - 1
                && col + direction[1] >= 0 && col + direction[1] <= matrix[row].length - 1
                && isLand(matrix, row + direction[0], col + direction[1]);
    }

    private static boolean isLand(int[][] matrix, int row, int col) {
        return matrix[row][col] == 0;
    }

}
