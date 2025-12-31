package december_2025;

import java.util.ArrayDeque;
import java.util.List;

public class RottingOranges {

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};

        RottingOranges rottingOranges = new RottingOranges();
        int result = rottingOranges.orangesRotting(grid);
        System.out.println(result);

    }

    // O(v + e) time | O(v + e) space
    public int orangesRotting(int[][] grid) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int fresh = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 2) {
                    queue.addLast(new int[] {r, c});
                }
                if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) {
            return 0;
        }

        if (queue.isEmpty()) {
            return -1;
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotted = false;

            for (int i = 0; i < size; i++) {
                int[] current = queue.removeFirst();
                int r = current[0];
                int c = current[1];

                for (int[] dir : directions) {
                    int newR = r + dir[0];
                    int newC = c + dir[1];

                    if (isWithinBound(grid, newR, newC) && grid[newR][newC] == 1) {
                        queue.add(new int[] {newR, newC});
                        grid[newR][newC] = 2;
                        rotted = true;
                        fresh--;
                    }
                }
            }
            if (rotted) {
                count++;
            }
        }
        if (fresh > 0) {
            return -1;
        }
        return count;
    }

    private boolean isWithinBound(int[][] grid, int r, int c) {
        return r >= 0 && r <= grid.length - 1 && c >= 0 && c <= grid[r].length - 1;
    }

}
