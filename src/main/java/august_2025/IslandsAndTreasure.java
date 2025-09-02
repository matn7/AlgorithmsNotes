package august_2025;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IslandsAndTreasure {

    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] grid = {
                {INF, -1, 0, INF},
                {INF, INF, INF, -1},
                {INF, -1, INF, -1},
                {0, -1, INF, INF}
        };

        IslandsAndTreasure islandsAndTreasure = new IslandsAndTreasure();
        islandsAndTreasure.islandsAndTreasure(grid);

        System.out.println();

    }

    // O(n * m) time | O(n * m) space
    public void islandsAndTreasure(int[][] grid) {

        Queue<int[]> queue = new LinkedList<>();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 0) {
                    queue.add(new int[] {r, c});
                }
            }
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int cost = grid[x][y];

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (isValidPos(grid, newX, newY) && isLand(grid, newX, newY)) {
                    int newCost = cost + 1;
                    if (newCost < grid[newX][newY]) {
                        grid[newX][newY] = newCost;
                        queue.add(new int[] {newX, newY});
                    }
                }
            }
        }

    }

    private boolean isLand(int[][] grid, int x, int y) {
        return grid[x][y] != -1;
    }

    private boolean isValidPos(int[][] grid, int x, int y) {
        return x >= 0 && x <= grid.length - 1 && y >= 0 && y <= grid[x].length - 1;
    }

}
