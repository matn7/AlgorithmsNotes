package october_2025;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WallsAndGates {

    static int M = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] grid = {
                {M, -1, 0, M},
                {M, M, M, -1},
                {M, -1, M, -1},
                {0, -1, M, M}
        };

        WallsAndGates wallsAndGates = new WallsAndGates();
        wallsAndGates.islandsAndTreasure(grid);
        System.out.println();
    }

    // O(n * m) time | O(n * m) space
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 0) {
                    visited[r][c] = true;
                    queue.add(new int[] {r, c});
                }
            }
        }

        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curX = current[0];
            int curY = current[1];
            int curVal = grid[curX][curY];
            for (int[] dir : directions) {
                int newX = curX + dir[0];
                int newY = curY + dir[1];
                if (isValidPos(grid, newX, newY) && grid[newX][newY] > 0 && !visited[newX][newY]) {
                    int newVal = grid[newX][newY];
                    if (curVal + 1 < newVal) {
                        grid[newX][newY] = curVal + 1;
                        visited[newX][newY] = true;
                        queue.add(new int[] {newX, newY});
                    }
                }
            }
        }
    }

    private boolean isValidPos(int[][] grid, int r, int c) {
        return r >= 0 && r <= grid.length - 1 && c >= 0 && c <= grid[r].length - 1;
    }

}
