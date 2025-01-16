package december_2024;

import java.util.LinkedList;
import java.util.Queue;

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
        Queue<int[]> rotten = findRottenOranges(grid);
        return bfs(rotten, grid);
    }

    private int bfs(Queue<int[]> rotten, int[][] grid) {
        int count = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!rotten.isEmpty()) {
            int size = rotten.size();
            for (int i = 0; i < size; i++) {
                int[] current = rotten.poll();
                int row = current[0];
                int col = current[1];
                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];
                    if (isValidPos(newRow, newCol, grid) && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        rotten.add(new int[] {newRow, newCol});
                    }
                }
            }
            if (!rotten.isEmpty()) {
                count++;
            }
        }

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 1) {
                    return -1;
                }
            }
        }

        return count;
    }

    private Queue<int[]> findRottenOranges(int[][] grid) {
        Queue<int[]> rotten = new LinkedList<>();
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 2) {
                    rotten.add(new int[] {r, c});
                }
            }
        }
        return rotten;
    }

    private boolean isValidPos(int r, int c, int[][] grid) {
        return r >= 0 && r <= grid.length - 1 && c >= 0 && c <= grid[r].length - 1;
    }

}
