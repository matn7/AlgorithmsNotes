package august_2025;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SwimInRisingWater {

    public static void main(String[] args) {
//        int[][] grid = {
//            {0,1,2,3,4},
//            {24,23,22,21,5},
//            {12,13,14,15,16},
//            {11,17,18,19,20},
//            {10,9,8,7,6}
//        };

        int[][] grid = {
                {0, 2},
                {1, 3}
        };

        SwimInRisingWater swimInRisingWater = new SwimInRisingWater();
        int result = swimInRisingWater.swimInWater(grid);
        System.out.println(result);
    }

    // O(n^2 log(n)) time | O(n^2) space
    public int swimInWater(int[][] grid) {
        int rows = grid.length - 1;
        int cols = grid[0].length - 1;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        int maxHeight = grid[rows][cols];
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        minHeap.add(new int[] {rows, cols, grid[rows][cols]});
        grid[rows][cols] = -1;

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int currRow = current[0];
            int currCol = current[1];
            int currHeight = current[2];

            maxHeight = Math.max(maxHeight, currHeight);

            if (currRow == 0 && currCol == 0) {
                return maxHeight;
            }

            for (int[] dir : directions) {
                int newRow = currRow + dir[0];
                int newCol = currCol + dir[1];
                if (isValidPos(grid, newRow, newCol) && grid[newRow][newCol] != -1) {
                    minHeap.add(new int[] {newRow, newCol, grid[newRow][newCol]});
                    grid[newRow][newCol] = -1;
                }
            }
        }
        return maxHeight;
    }

    private boolean isValidPos(int[][] grid, int r, int c) {
        return r >= 0 && r <= grid.length - 1 && c >= 0 && c <= grid[r].length - 1;
    }

}
