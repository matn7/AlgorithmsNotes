package july_2025;

import java.util.PriorityQueue;

public class SwimInRisingWater {

    public static void main(String[] args) {
        int[][] grid = {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
        SwimInRisingWater swimInRisingWater = new SwimInRisingWater();
        int result = swimInRisingWater.swimInWater(grid);
        System.out.println(result);
    }

    // O(n^2 * log(n)) time | O(n^2) space
    public int swimInWater(int[][] grid) {
        int r = grid.length - 1;
        int c = grid[r].length - 1;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]); // [4, 4, 6]
        queue.add(new int[] {r, c, grid[r][c]});
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int maxHeight = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r1 = current[0];
            int c1 = current[1];
            int w1 = current[2];
            if (w1 < 0) {
                continue;
            }
            if (r1 == 0 && c1 == 0) {
                maxHeight = Math.max(maxHeight, w1);
                break;
            }
            maxHeight = Math.max(maxHeight, w1);
            grid[r1][c1] = -1;

            for (int[] dir : directions) {
                int r2 = r1 + dir[0];
                int c2 = c1 + dir[1];

                if (isValidPos(r2, c2, grid) && grid[r2][c2] != -1) {
                    queue.add(new int[] {r2, c2, grid[r2][c2]});
                }
            }
        }
        return maxHeight;
    }

    private boolean isValidPos(int r, int c, int[][] grid) {
        return r >= 0 && r <= grid.length - 1 && c >= 0 && c <= grid[r].length - 1;
    }

}
