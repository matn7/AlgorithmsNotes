package september_2025;

import java.util.PriorityQueue;

public class MinPathSum {

    public static void main(String[] args) {
//        int[][] grid = {
//                {1, 3, 1},
//                {1, 5, 1},
//                {4, 2, 1}
//        };

        int[][] grid = {
                {1, 2},
                {1, 1},
        };

        MinPathSum minPathSum = new MinPathSum();
        int result = minPathSum.minPathSum(grid);
        System.out.println(result);
    }

    // O(nlog(n)) time | O(n) space
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        queue.add(new int[] {0, 0, grid[0][0]});
        boolean[][] seen = new boolean[m][n];

        int[][] directions = {{0, 1}, {1, 0}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r1 = current[0];
            int c1 = current[1];
            int w1 = current[2];
            if (r1 == m - 1 && c1 == n - 1) {
                return w1;
            }
            if (seen[r1][c1]) {
                continue;
            }
            seen[r1][c1] = true;
            for (int[] dir : directions) {
                int r2 = r1 + dir[0];
                int c2 = c1 + dir[1];

                if (isValidPos(grid, r2, c2) && !seen[r2][c2]) {
                    int w2 = w1 + grid[r2][c2];
                    queue.add(new int[] {r2, c2, w2});
                }
            }
        }
        return -1;
    }

    private boolean isValidPos(int[][] grid, int r, int c) {
        return r >= 0 && r <= grid.length - 1 && c >= 0 && c <= grid[r].length - 1;
    }


}
