package june_2025;

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
                {3, 2},
                {0, 1}
        };

        SwimInRisingWater swimInRisingWater = new SwimInRisingWater();
        int result = swimInRisingWater.swimInWater(grid);
        System.out.println(result);

    }

    // O(E * log(V)) time | O(V + E) space
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int rows = grid.length - 1;
        int cols = grid[0].length - 1;
        int cost = grid[rows][cols];

        minHeap.add(new int[] {cost, rows, cols});
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int maxInPath = grid[rows][cols];
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int cost1 = current[0];
            int r1 = current[1];
            int c1 = current[2];
            maxInPath = Math.max(maxInPath, cost1);
            if (r1 == 0 && c1 == 0) {
                break;
            }
            if (grid[r1][c1] == -1) {
                continue;
            }
            grid[r1][c1] = -1;

            for (int[] dir : directions) {
                int r2 = r1 + dir[0];
                int c2 = c1 + dir[1];

                if (isValidPos(grid, r2, c2) && grid[r2][c2] != -1) {
                    int cost2 = grid[r2][c2];
                    minHeap.add(new int[] {cost2, r2, c2});
                }
            }
        }
        return maxInPath;
    }

    private boolean isValidPos(int[][] grid, int r, int c) {
        return r >= 0 && r <= grid.length - 1 && c >= 0 && c <= grid[r].length - 1;
    }

}
