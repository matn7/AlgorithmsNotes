package may_2025;

import java.util.PriorityQueue;
import java.util.function.Predicate;

public class SwimInRisingWater {

    public static void main(String[] args) {
//        int[][] grid = {
//                {0,1,2,3,4},
//                {24,23,22,21,5},
//                {12,13,14,15,16},
//                {11,17,18,19,20},
//                {10,9,8,7,6}
//        };
//
//        int[][] grid = {
//                {3, 2},
//                {0, 1}
//        };

        int[][] grid = {{0}};

        SwimInRisingWater swimInRisingWater = new SwimInRisingWater();
        int result = swimInRisingWater.swimInWater(grid);
        System.out.println(result);
    }

    // O(n^2 * log(n)) time | O(n^2) space
    public int swimInWater(int[][] grid) {

        int start = grid[0][0];
        int end = grid[grid.length - 1][grid[0].length - 1];

        int[] coord;
        Predicate<int[]> endCondition;
        if (start > end) {
            coord = new int[] {0, 0};
            endCondition = x -> x[0] == grid.length - 1 && x[1] == grid[0].length - 1;
        } else {
            coord = new int[] {grid.length - 1, grid[0].length - 1};
            endCondition = x -> x[0] == 0 && x[1] == 0;
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(Math.max(start, end), coord));

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int time = node.time;
            int[] c = node.coord;
            int x = c[0];
            int y = c[1];
            if (grid[x][y] == -1) {
                continue;
            }
            max = Math.max(max, time);
            grid[x][y] = -1;
            if (endCondition.test(new int[] {x, y})) {
                break;
            }
            for (int[] direction : directions) {
                int x1 = x + direction[0];
                int y1 = y + direction[1];
                if (isValidPos(x1, y1, grid) && grid[x1][y1] != -1) {
                    queue.add(new Node(grid[x1][y1], new int[] {x1, y1}));
                }
            }
        }
        return max;
    }

    private boolean isValidPos(int x, int y, int[][] grid) {
        return x >= 0 && x <= grid.length - 1 && y >= 0 && y <= grid[x].length - 1;
    }

    static class Node implements Comparable<Node> {
        int time;
        int[] coord;

        public Node(int time, int[] coord) {
            this.time = time;
            this.coord = coord;
        }

        @Override
        public int compareTo(Node o) {
            return time - o.time;
        }
    }

}
