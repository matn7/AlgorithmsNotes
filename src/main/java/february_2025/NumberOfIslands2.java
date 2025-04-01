package february_2025;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands2 {

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '1', '1'},
        };

        NumberOfIslands2 numberOfIslands = new NumberOfIslands2();
        int result = numberOfIslands.numIslands(grid);
        System.out.println(result);
    }

    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // O(n * m) time | O(n * m) space
    public int numIslands(char[][] grid) {
        int count = 0;



        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    bfs(grid, r, c);
//                    sink(grid, r, c);
                }
            }
        }

        return count;
    }

    private void bfs(char[][] grid, int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        grid[r][c] = '0';
        queue.add(new int[] {r, c});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            for (int[] dir : directions) {
                int nR = row + dir[0];
                int nC = col + dir[1];
                if (nR < 0 || nR == grid.length || nC < 0 || nC == grid[nR].length || grid[nR][nC] == '0') {
                    continue;
                }
                queue.add(new int[] {nR, nC});
                grid[nR][nC] = '0';
            }
        }
    }

    private void sink(char[][] grid, int r, int c) {
        if (r < 0 || r == grid.length || c < 0 || c == grid[r].length || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        for (int[] dir : directions) {
            int nR = r + dir[0];
            int nC = c + dir[1];
            sink(grid, nR, nC);
        }
    }

}
