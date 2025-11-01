package october_2025;

import java.util.ArrayDeque;

public class RottingOranges2 {

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};

        RottingOranges2 rottingOranges2 = new RottingOranges2();
        int result = rottingOranges2.orangesRotting(grid);
        System.out.println(result);
    }

    // O(n*m) time | O(n*m) space
    public int orangesRotting(int[][] grid) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int fresh = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c]==2) {
                    queue.addLast(new int[]{r, c});
                }
                if (grid[r][c]==1) {
                    fresh++;
                }
            }
        }
        if (fresh==0) {
            return 0;
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rot = false;
            for (int i = 0; i < size; i++) {
                int[] current = queue.removeFirst();
                int r1 = current[0];
                int c1 = current[1];

                for (int[] dir : directions) {
                    int r2 = r1 + dir[0];
                    int c2 = c1 + dir[1];
                    if (isValidPos(grid, r2, c2) && grid[r2][c2]==1) {
                        // rot orange
                        grid[r2][c2] = 2;
                        fresh--;
                        rot = true;
                        queue.add(new int[]{r2, c2});
                    }
                }
            }
            if (rot) {
                time++;
            }
        }
        return fresh==0 ? time:-1;
    }

    private boolean isValidPos(int[][] grid, int r, int c) {
        return r >= 0 && r <= grid.length - 1 && c >= 0 && c <= grid[r].length - 1;
    }

}
