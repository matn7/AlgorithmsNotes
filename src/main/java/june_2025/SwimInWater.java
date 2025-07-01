package june_2025;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SwimInWater {

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

        SwimInWater swimInWater = new SwimInWater();
        int result = swimInWater.swimInWater(grid);
        System.out.println(result);
    }

    // O(E*log(V)) time | O(E) space
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        int row = grid.length - 1;
        int col = grid[0].length - 1;
        queue.add(new int[] {row, col, grid[row][col]});

        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int max = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int h = current[2];
            max = Math.max(max, h);
            if (r == 0 && c == 0) {
                return max;
            }
            grid[r][c] = -1; // mark as visited
            for (int[] dir : directions) {
                int nR = r + dir[0];
                int nC = c + dir[1];
                if (isValidPos(grid, nR, nC) && grid[nR][nC] != -1) {
                    queue.add(new int[] {nR, nC, grid[nR][nC]});
                }
            }
        }

        return max;
    }

    private boolean isValidPos(int[][] grid, int row, int col) {
        return row >= 0 && row <= grid.length - 1 && col >= 0 && col <= grid[row].length - 1;
    }

}
