package december_2024;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {

    static int R = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[][] grid = {
                {R, -1, 0, R},
                {R, R, R, -1},
                {R, -1, R, -1},
                {0, -1, R, R}
        };

        WallsAndGates wallsAndGates = new WallsAndGates();
        wallsAndGates.islandsAndTreasure(grid);
        System.out.println();
    }

    public void islandsAndTreasure(int[][] grid) {
        bfs(findGates(grid), grid);
    }

    private Queue<int[]> findGates(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 0) {
                    queue.add(new int[] {r, c});
                }
            }
        }
        return queue;
    }

    private void bfs(Queue<int[]> queue, int[][] grid) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int curVal = grid[row][col];
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if (isValidPos(newRow, newCol, grid) && grid[newRow][newCol] != -1
                        && (curVal + 1 < grid[newRow][newCol])) {
                    grid[newRow][newCol] = curVal + 1;
                    queue.add(new int[] {newRow, newCol});
                }
            }
        }
    }

    private boolean isValidPos(int r, int c, int[][] grid) {
        return r >= 0 && r <= grid.length - 1 && c >= 0 && c <= grid[r].length - 1;
    }
}
