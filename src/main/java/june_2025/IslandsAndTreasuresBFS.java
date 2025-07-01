package june_2025;

import java.util.LinkedList;
import java.util.Queue;

public class IslandsAndTreasuresBFS {

    private static int R = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[][] grid = {
                {R, -1, 0, R},
                {R, R, R, -1},
                {R, -1, R, -1},
                {0, -1, R, R}
        };

        IslandsAndTreasuresBFS islandsAndTreasure = new IslandsAndTreasuresBFS();
        islandsAndTreasure.islandsAndTreasure(grid);
        System.out.println();
    }

    // O(n*m) time | O(n*m) space
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 0) {
                    queue.add(new int[] {r, c});
                }
            }
        }

        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1, 0}};
        boolean[][] seen = new boolean[grid.length][grid[0].length];

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int val = grid[r][c];
            seen[r][c] = true;

            for (int[] dir : directions) {
                int nR = r + dir[0];
                int nC = c + dir[1];
                if (isValidPos(grid, nR, nC) && grid[r][c] != -1 && !seen[nR][nC]) {
                    if (val + 1 < grid[nR][nC]) {
                        grid[nR][nC] = val + 1;
                        queue.add(new int[] {nR, nC});
                    }
                }
            }
        }
    }

    private boolean isValidPos(int[][] grid, int r, int c) {
        return r >= 0 && r <= grid.length - 1 && c >= 0 && c <= grid[r].length - 1;
    }


}
