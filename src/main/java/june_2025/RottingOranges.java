package june_2025;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public static void main(String[] args) {
//        int[][] grid = {
//                {2, 1, 1},
//                {1, 1, 0},
//                {0, 1, 1}
//        };

//        int[][] grid = {
//                {2, 1, 1},
//                {0, 1, 1},
//                {1, 0, 1}
//        };

        int[][] grid = {
                {0, 2}
        };

        RottingOranges rottingOranges = new RottingOranges();
        int result = rottingOranges.orangesRotting(grid);
        System.out.println(result);
    }

    // O(n * m) time | O(n * m) space
    public int orangesRotting(int[][] grid) {
        Queue<int[]> rotten = new LinkedList<>();
        int freshFruit = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 2) {
                    rotten.add(new int[] {r, c});
                }
                if (grid[r][c] == 1) {
                    freshFruit++;
                }
            }
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int result = 0;
        while (!rotten.isEmpty()) {
            int size = rotten.size();
            boolean rotted = false;
            for (int i = 0; i < size; i++) {
                int[] position = rotten.poll();
                int row = position[0];
                int col = position[1];

                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if (isValidPos(grid, newRow, newCol) && grid[newRow][newCol] == 1) {
                        rotted = true;
                        grid[newRow][newCol] = 2;
                        freshFruit--;
                        rotten.add(new int[] {newRow, newCol});
                    }
                }
            }
            if (rotted) {
                result++;
            }
        }

        return freshFruit == 0 ? result : -1;
    }

    private boolean isValidPos(int[][] grid, int row, int col) {
        return row >= 0 && row <= grid.length - 1 && col >= 0 && col <= grid[row].length - 1;
    }


}
