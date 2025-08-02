package july_2025;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottingOranges {

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};

        RottingOranges rottingOranges = new RottingOranges();
        int result = rottingOranges.orangesRotting(grid);
        System.out.println(result);
    }

    // O(n*m) time | O(n*m) space
    public int orangesRotting(int[][] grid) {
        Queue<int[]> rotten = new LinkedList<>();
        int fresh = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 1) {
                    fresh++;
                }
                if (grid[r][c] == 2) {
                    rotten.add(new int[] {r, c});
                }
            }
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int time = 0;
        while (!rotten.isEmpty()) {
            int size = rotten.size();
            int freshBefore = fresh;
            for (int i = 0; i < size; i++) {
                int[] current = rotten.poll();
                int row = current[0];
                int col = current[1];
                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];
                    if (isValidPos(grid, newRow, newCol) && grid[newRow][newCol] == 1) {
                        fresh--;
                        grid[newRow][newCol] = 2;
                        rotten.add(new int[] {newRow, newCol});
                    }
                }
            }
            if (fresh < freshBefore) {
                time++;
            }
        }

        return fresh == 0 ? time : -1;
    }

    private boolean isValidPos(int[][] grid, int r, int c) {
        return r >= 0 && r <= grid.length - 1 && c >= 0 && c <= grid[r].length - 1;
    }

}
