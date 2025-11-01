package october_2025;

import java.util.ArrayDeque;

public class ShortestPathInBinaryMatrix {

    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};

        ShortestPathInBinaryMatrix shortestPathInBinaryMatrix = new ShortestPathInBinaryMatrix();
        int result = shortestPathInBinaryMatrix.shortestPathBinaryMatrix(grid);
        System.out.println(result);

    }

    // O(n * m) time | O(n * m) space
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) {
            return -1;
        }

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {0, 0, 1});
        grid[0][0] = -1; // visit

        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}, {1,1}, {1,-1}, {-1,1}, {-1,-1}};

        while (!queue.isEmpty()) {
            int[] current = queue.removeFirst();
            int r1 = current[0];
            int c1 = current[1];
            int dist = current[2];

            if (r1 == grid.length - 1 && c1 == grid[r1].length - 1) {
                return dist;
            }

            for (int[] dir : directions) {
                int r2 = r1 + dir[0];
                int c2 = c1 + dir[1];
                if (isValidPos(grid, r2, c2) && grid[r2][c2] == 0) {
                    queue.add(new int[] {r2, c2, dist + 1});
                    grid[r2][c2] = -1;
                }
            }
        }
        return -1;
    }

    private boolean isValidPos(int[][] grid, int r, int c) {
        return r >= 0 && r <= grid.length - 1 && c >= 0 && c <= grid[r].length - 1;
    }

}
