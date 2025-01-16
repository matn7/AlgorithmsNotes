package november_2024;

import java.util.ArrayDeque;

public class RottingOranges2 {

    public int orangesRotting(int[][] grid) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int time = 0;
        int fresh = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 1) {
                    fresh++;
                }
                if (grid[r][c] == 2) {
                    q.add(new int[] {r, c});
                }
            }
        }
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] front = q.removeFirst();
                int r = front[0];
                int c = front[1];
                for (int[] direction : directions) {
                    int row = r + direction[0];
                    int col = c + direction[1];
                    if (row < 0 || row == grid.length || col < 0
                            || col == grid[row].length || grid[row][col] != 1) {
                        continue;
                    }
                    grid[row][col] = 2;
                    q.add(new int[] {row, col});
                    fresh--;
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }

}
