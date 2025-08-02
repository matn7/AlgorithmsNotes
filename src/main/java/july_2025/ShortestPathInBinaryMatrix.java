package july_2025;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

    public static void main(String[] args) {
//        int[][] grid = {
//                {0, 0, 0},
//                {1, 1, 0},
//                {1, 1, 0}
//        };

        int[][] grid = {
                {0, 1},
                {1, 0},
        };


        ShortestPathInBinaryMatrix shortestPathInBinaryMatrix = new ShortestPathInBinaryMatrix();
        int result = shortestPathInBinaryMatrix.shortestPathBinaryMatrix(grid);
        System.out.println(result);

    }

    // O(n * m) time | O(n * m) space
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1},{-1, 1}, {1, -1}};

        Queue<int[]> queue = new LinkedList<>(); // [r, c, distance]
        queue.add(new int[] {0, 0, 1});
        int minPath = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int dist = current[2];
            if (row == grid.length - 1 && col == grid[0].length - 1) {
                minPath = Math.min(minPath, current[2]);
                continue;
            }
            if (visited[row][col]) {
                continue;
            }
            visited[row][col] = true;

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if (isValidPos(grid, newRow, newCol) && !visited[newRow][newCol] && grid[newRow][newCol] == 0) {
                    queue.add(new int[] {newRow, newCol, dist + 1});
                }
            }
        }
        return minPath == Integer.MAX_VALUE ? -1 : minPath;

    }

    private boolean isValidPos(int[][] grid, int r, int c) {
        return r >= 0 && r <= grid.length - 1 && c >= 0 && c <= grid[r].length - 1;
    }


}
