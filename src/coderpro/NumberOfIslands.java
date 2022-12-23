package coderpro;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOfIslands {

    public static void main(String[] args) {

        // 1 - land
        // 0 - water

        int[][] matrix = {
                {1, 1, 1, 1, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 1, 1, 0, 0},
        };

        NumberOfIslands numberOfIslands = new NumberOfIslands();
        int result = numberOfIslands.num_islands(matrix);
        System.out.println(result);
    }

    public int num_islands(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int numRows = grid.length;
        int numCols = grid[0].length;
        int count = 0;

        for (int row = 0 ; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (isLand(grid, row, col)) {
                    count++;
                    sinkLand(grid, row, col);
                }
            }
        }
        return count;
    }

    // O(n) time | O(n) space, n is w * h (width * height)
    private boolean isLand(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) {
            return false;
        }
        return grid[row][col] == 1;
    }

    private void sinkLand(int[][] grid, int row, int col) {
        if (!isLand(grid, row, col)) {
            return;
        }
        grid[row][col] = 0;

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int[] d : directions) {
            sinkLand(grid, row + d[0], col + d[1]);
        }

    }


    // O(w * h) time | O(w * h) space
    public int getNumberOfIslands(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        List<Integer> islands = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (!visited[row][col]) {
                    explore(matrix, row, col, visited, islands);
                }
            }
        }

        return islands.size();
    }

    private void explore(int[][] matrix, int row, int col, boolean[][] visited, List<Integer> islands) {
        int len = 0;
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{row, col});

        while (!queue.isEmpty()) {
            Integer[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];
            if (visited[currX][currY]) {
                continue;
            }
            visited[currX][currY] = true;
            if (matrix[currX][currY] == 0) {
                continue;
            }
            len++;
            List<Integer[]> neighbors = getNeighbors(matrix, currX, currY, visited);
            for (Integer[] neighbor : neighbors) {
                queue.add(neighbor);
            }
        }

        if (len > 0) {
            islands.add(len);
        }
    }

    private List<Integer[]> getNeighbors(int[][] matrix, int row, int col, boolean[][] visited) {
        List<Integer[]> neighbors = new ArrayList<>();

        if (row > 0 && !visited[row - 1][col]) {
            neighbors.add(new Integer[] {row - 1, col});
        }
        if (row < matrix.length - 1 && !visited[row + 1][col]) {
            neighbors.add(new Integer[]{row + 1, col});
        }
        if (col > 0 && !visited[row][col - 1]) {
            neighbors.add(new Integer[] {row, col - 1});
        }
        if (col < matrix[row].length - 1&& !visited[row][col + 1]) {
            neighbors.add(new Integer[]{row, col + 1});
        }

        return neighbors;
    }

}

















