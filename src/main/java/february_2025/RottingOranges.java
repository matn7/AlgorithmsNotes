package february_2025;

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

    // O(n*m) time | O(n*m) space
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 1) {
                    fresh++;
                }
                if (grid[r][c] == 2) {
                    queue.add(new int[] {r, c});
                }
            }
        }
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int res = 0;
        while (fresh != 0 && !queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int r = current[0];
                int c = current[1];
                for (int[] dir : directions) {
                    int nR = r + dir[0];
                    int nC = c + dir[1];
                    if (nR < 0 || nR == grid.length || nC < 0 || nC == grid[nR].length || grid[nR][nC] != 1) {
                        continue;
                    }
                    fresh--;
                    grid[nR][nC] = 2;
                    queue.add(new int[] {nR, nC});
                }
            }
            res++;
        }
        return fresh == 0 ? res : -1;
    }

}
