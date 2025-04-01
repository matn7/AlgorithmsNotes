package march_2025;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SwimInRisingWater {

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 3},
                {2, 4, 1},
                {1, 2, 1}
        };

        SwimInRisingWater swimInRisingWater = new SwimInRisingWater();
        int result = swimInRisingWater.swimInWater(grid);
        System.out.println(result);
    }

    // O(n^2 log(n)) time | O(n^2) space
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a[2])); // [coord.x, coord.y, cost]

        minHeap.add(new int[] {0, 0, grid[0][0]});
        grid[0][0] = -1; // mark node as visited (in case we can modify input params, other use separate ds)
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int r = current[0];
            int c = current[1];
            int t = current[2];
            if (r == grid.length - 1 && c == grid[r].length - 1) {
                // return result
                return t;
            }
            for (int[] dir : directions) {
                int r1 = r + dir[0];
                int c1 = c + dir[1];
                if (r1 < 0 || r1 >= grid.length || c1 < 0 || c1 >= grid[r].length || grid[r1][c1] == -1) {
                    continue;
                }
                int t1 = Math.max(t, grid[r1][c1]);
                minHeap.add(new int[] {r1, c1, t1});
                grid[r1][c1] = -1;
            }
        }
        return -1;
    }

}
