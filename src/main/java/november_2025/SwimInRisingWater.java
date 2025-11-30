package november_2025;

import java.util.List;
import java.util.PriorityQueue;

public class SwimInRisingWater {

    public static void main(String[] args) {
        int[][] grid = {
            {0,1,2,3,4},
            {24,23,22,21,5},
            {12,13,14,15,16},
            {11,17,18,19,20},
            {10,9,8,7,6}
        };

//        int[][] grid = {
//                {3, 2},
//                {0, 1}
//        };

        SwimInRisingWater swimInRisingWater = new SwimInRisingWater();
        int result = swimInRisingWater.swimInWater(grid);
        System.out.println(result);

    }

    // O(n^2 * log(n)) time | O(n) space
    public int swimInWater(int[][] grid) {
        int rows = grid.length - 1;
        int cols = grid[0].length - 1;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]); // [r, c, level of water]

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int level = grid[rows][cols];
        minHeap.add(new int[] {rows, cols, level});
        grid[rows][cols] = -1; // means visited

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int r1 = current[0];
            int c1 = current[1];
            int w1 = current[2];
            level = Math.max(level, w1);
            if (r1 == 0 && c1 == 0) {
                return level;
            }

            for (int[] dir : directions) {
                int r2 = r1 + dir[0];
                int c2 = c1 + dir[1];
                if (isValidPos(r2, c2, grid) && grid[r2][c2] != -1) {
                    minHeap.add(new int[] {r2, c2, grid[r2][c2]});
                    grid[r2][c2] = -1;
                }
            }
        }
        return level;
    }

    private boolean isValidPos(int r, int c, int[][] grid) {
        return r >= 0 && r <= grid.length - 1 && c >= 0 && c <= grid[r].length - 1;
    }

}
