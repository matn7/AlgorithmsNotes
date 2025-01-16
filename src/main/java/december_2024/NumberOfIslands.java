package december_2024;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'},
                {'1', '1', '0', '0', '1'},
        };

        NumberOfIslands numberOfIslands = new NumberOfIslands();
        int result = numberOfIslands.numIslands(grid);
        System.out.println(result);
    }

    public int numIslands(char[][] grid) {
        int count = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    bfs(r, c, grid);
                }
            }
        }
        return count;
    }

    private void bfs(int r, int c, char[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r, c});
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cR = current[0];
            int cC = current[1];
            grid[cR][cC] = '2';
            for (int[] direction : directions) {
                int newR = cR + direction[0];
                int newC = cC + direction[1];
                if (isValidPos(newR, newC, grid) && grid[newR][newC] == '1') {
                    queue.add(new int[] {newR, newC});
                }
            }

        }
    }

    private void dfs(int r, int c, char[][] grid) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        grid[r][c] = '2';

        for (int[] direction : directions) {
            int newR = r + direction[0];
            int newC = c + direction[1];
            if (isValidPos(newR, newC, grid) && grid[newR][newC] == '1') {
                dfs(newR, newC, grid);
            }
        }
    }

    private boolean isValidPos(int r, int c, char[][] grid) {
        return r >= 0 && r <= grid.length - 1 && c >= 0 && c <= grid[r].length - 1;
    }

}
