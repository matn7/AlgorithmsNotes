package june_2025;

import java.util.LinkedList;
import java.util.Queue;

public class IslandAndTreasure {

    public static void main(String[] args) {
        int INF = Integer.MAX_VALUE;
        int[][] grid = {
                {INF, -1, 0, INF},
                {INF, INF, INF, -1},
                {INF, -1, INF, -1},
                {0, -1, INF, INF}
        };

        IslandAndTreasure islandAndTreasure = new IslandAndTreasure();
        islandAndTreasure.islandsAndTreasure(grid);
        System.out.println();
    }

    // O(n*m) time | O(n*m) space
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> gates = new LinkedList<>();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 0) {
                    gates.add(new int[] {r, c});
                }
            }
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!gates.isEmpty()) {
            int[] position = gates.poll();
            int row = position[0];
            int col = position[1];
            int cost = grid[row][col];

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (isValidPos(grid, newRow, newCol) && grid[newRow][newCol] != -1 && cost + 1 < grid[newRow][newCol]) {
                    grid[newRow][newCol] = cost + 1;
                    gates.add(new int[] {newRow, newCol});
                }
            }
        }
    }

    private boolean isValidPos(int[][] grid, int r, int c) {
        return r >= 0 && r <= grid.length - 1 && c >= 0 && c <= grid[r].length - 1;
    }

}


