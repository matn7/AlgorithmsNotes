package november_2024;

import java.util.*;

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

    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    fresh++;
                }
                if (grid[row][col] == 2) {
                    queue.addLast(new int[] {row, col});
                }
            }
        }

        int time = 0;
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.removeFirst();
                for (int[] direction : directions) {
                    int newRow = current[0] + direction[0];
                    int newCol = current[1] + direction[1];

                    if (isValidPos(newRow, newCol, grid) && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        queue.addLast(new int[] {newRow, newCol});
                        fresh--;
                    }
                }
            }
            time++;
        }

        return fresh == 0 ? time : -1;
    }

    private boolean isValidPos(int row, int col, int[][] grid) {
        return row >= 0 && row <= grid.length - 1 && col >= 0 && col <= grid[row].length - 1;
    }

}
