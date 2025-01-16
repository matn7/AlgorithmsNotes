package december_2024;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SwimInRisingWater {

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 3},
                {2, 4, 1},
                {1, 2, 1}
        };
//        int[][] grid = {
//                {0, 2},
//                {1, 3},
//        };
        SwimInRisingWater swimInRisingWater = new SwimInRisingWater();
        int result = swimInRisingWater.swimInWater(grid);
        System.out.println(result);
    }

    // O(n^2 log(n)) time | O(n^2) space
    public int swimInWater(int[][] grid) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(new int[] {0, 0}, grid[0][0]));

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        visit[0][0] = true;
        while (!queue.isEmpty()) {
            Node frontier = queue.poll();
            int[] coord = frontier.coord;
            int height = frontier.height;
            if (coord[0] == grid.length - 1 && coord[1] == grid[0].length - 1) {
                return height;
            }

            for (int[] direction : directions) {
                int newRow = direction[0] + coord[0];
                int newCol = direction[1] + coord[1];
                if (isValidPos(newRow, newCol, grid) && !visit[newRow][newCol]) {
                    visit[newRow][newCol] = true;
                    queue.add(new Node(new int[] {newRow, newCol}, Math.max(grid[newRow][newCol], height)));
                }
            }
        }
        return -1;
    }

    private boolean isValidPos(int r, int c, int[][] grid) {
        return r >= 0 && r <= grid.length - 1 && c >= 0 && c <= grid[r].length - 1;
    }

    static class Node implements Comparable<Node> {
        int[] coord;
        int height;

        public Node(int[] coord, int height) {
            this.coord = coord;
            this.height = height;
        }

        @Override
        public int compareTo(Node o) {
            return height - o.height;
        }
    }

}
