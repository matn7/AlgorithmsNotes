package october_2025;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SwimInRisingWater {

    public static void main(String[] args) {
        int[][] grid = {
            {0,1,2,3,4},
            {24,23,22,21,5},
            {12,13,14,15,16},
            {11,17,18,19,20},
            {10,9,8,7,6}
        };

        SwimInRisingWater swimInRisingWater = new SwimInRisingWater();
        int result = swimInRisingWater.swimInWater(grid);
        System.out.println(result);
    }

    // O(nlog(n)) time | O(n) space
    public int swimInWater(int[][] grid) {
        int rows = grid.length - 1;
        int cols = grid[0].length - 1;
        int result = 0;

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); // [height, xcoord, ycoord]
//        Set<String> visited = new HashSet<>();
        queue.add(new int[] {grid[rows][cols], rows, cols});
//        visited.add(rows + ":" + cols);
        grid[rows][cols] = -1;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currHeight = current[0];
            int xCoord = current[1];
            int yCoord = current[2];
            if (xCoord == 0 && yCoord == 0) {
                return Math.max(result, currHeight);
            }
            result = Math.max(result, currHeight);

            for (int[] dir : directions) {
                int newX = xCoord + dir[0];
                int newY = yCoord + dir[1];
                if (isValidPos(grid, newX, newY) && grid[newX][newY] != -1) {
                    int newHeight = grid[newX][newY];
                    queue.add(new int[] {newHeight, newX, newY});
                    grid[newX][newY] = -1;
//                    visited.add(newX + ":" + newY);
                }
            }
        }
        return result;
    }

    private boolean isValidPos(int[][] grid, int x, int y) {
        return x >= 0 && x <= grid.length - 1 && y >= 0 && y <= grid[0].length - 1;
    }

}
