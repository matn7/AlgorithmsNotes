package august_2025;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottingOranges {

    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        RottingOranges rottingOranges = new RottingOranges();
        int result = rottingOranges.orangesRotting(grid);
        System.out.println(result);
    }

    // O(n * m) time | O(n * m) space
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 1) {
                    fresh++;
                }
                if (grid[r][c] == 2) {
                    queue.add(new int[] {r, c});
                }
            }
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotted = false;
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int curX = current[0];
                int curY = current[1];

                for (int[] dir : directions) {
                    int newX = curX + dir[0];
                    int newY = curY + dir[1];
                    if (isValidPos(grid, newX, newY) && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        fresh--;
                        queue.add(new int[] {newX, newY});
                        rotted = true;
                    }
                }
            }
            if (rotted) {
                count++;
            }
        }
        return fresh == 0 ? count : -1;
    }

    private boolean isValidPos(int[][] grid, int x, int y) {
        return x >= 0 && x <= grid.length - 1 && y >= 0 && y <= grid[x].length - 1;
    }

}
