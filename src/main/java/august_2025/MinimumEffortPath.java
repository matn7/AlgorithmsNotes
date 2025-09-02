package august_2025;

import java.util.PriorityQueue;

public class MinimumEffortPath {

    public static void main(String[] args) {
        int[][] heights = {
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };

        MinimumEffortPath minimumEffortPath = new MinimumEffortPath();
        int result = minimumEffortPath.minimumEffortPath(heights);
        System.out.println(result);
    }

    // O(n * m * log(n * m)) time | O(m * n) space
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        minHeap.add(new int[] {0, 0, 0});
        boolean[][] visited = new boolean[heights.length][heights[0].length];

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int result = Integer.MIN_VALUE;
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int x = current[0];
            int y = current[1];
            if (visited[x][y]) {
                continue;
            }
            visited[x][y] = true;
            int currEffort = current[2];
            result = Math.max(result, currEffort);
            if (x == heights.length - 1 && y == heights[x].length - 1) {
                break;
            }
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (isValidPos(heights, newX, newY) && !visited[newX][newY]) {
                    int newEffort = Math.max(currEffort, Math.abs(heights[x][y] - heights[newX][newY]));
                    minHeap.add(new int[] {newX, newY, newEffort});
                }
            }
        }
        return result;
    }

    private boolean isValidPos(int[][] heights, int x, int y) {
        return x >= 0 && x <= heights.length - 1 && y >= 0 && y <= heights[x].length - 1;
    }

}
