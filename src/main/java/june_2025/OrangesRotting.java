package june_2025;

import java.util.LinkedList;
import java.util.Queue;

public class OrangesRotting {

    public static void main(String[] args) {
//        Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
//        Output: 4
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        OrangesRotting orangesRotting = new OrangesRotting();
        int result = orangesRotting.orangesRotting(grid);
        System.out.println(result);
    }

    // O(n*m) time | O(n*m) space
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 2) {
                    queue.add(new int[] {r, c});
                }
                if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }
        int count = 0;
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int r = current[0];
                int c = current[1];

                for (int[] dir : directions) {
                    int nR = r + dir[0];
                    int nC = c + dir[1];
                    if (isValidPos(grid, nR, nC) && grid[nR][nC] == 1) {
                        grid[nR][nC] = 2;
                        fresh--;
                        queue.add(new int[] {nR, nC});
                    }
                }
            }
            count++;
        }

        return fresh == 0 ? count : -1;
    }

    private boolean isValidPos(int[][] grid, int r, int c) {
        return r >= 0 && r <= grid.length - 1 && c >= 0 && c <= grid[r].length - 1;
    }

}
