package coderpro;

import java.util.*;
import java.util.Queue;

public class MaxConnectedColorsInGrid {

    int[][] bounds = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 0, 2, 2, 2},
                {0, 0, 1, 2, 2, 2},
                {0, 0, 1, 0, 0, 0},
                {0, 1, 1, 1, 0, 2},
                {0, 0, 1, 1, 2, 0}
        };

        MaxConnectedColorsInGrid maxColors = new MaxConnectedColorsInGrid();
        int result = maxColors.maxColors(matrix);
        System.out.println(result); // 5

        System.out.println("===================");
        int[][] grid = {
                {1, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 1, 0, 0}
        };

        Grid2 grid2 = new Grid2(grid);
        int result2 = grid2.maxConnectedColors();
        System.out.println(result2);
    }



    // ----------------------------------
    // O(w * h) time | O(w * h) space
    public int maxColors(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int max = Integer.MIN_VALUE;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (!visited[row][col] && matrix[row][col] != 0) {
                    int currMax = explore(matrix, row, col, visited);
                    max = Math.max(max, currMax);
                }
            }
        }
        if (max == Integer.MIN_VALUE) {
            return 0;
        }
        return max;
    }

    private int explore(int[][] matrix, int row, int col, boolean[][] visited) {
        int length = 0;
        int color = matrix[row][col];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {row, col});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cX = current[0];
            int cY = current[1];
            if (visited[cX][cY]) {
                continue;
            }
            if (matrix[cX][cY] != color) {
                continue;
            }
            visited[cX][cY] = true;
            length++;
            List<int[]> neighbors = getNeighbors(matrix, cX, cY, visited);
            for (int[] neighbor : neighbors) {
                queue.add(neighbor);
            }
        }
        return length;
    }

    private List<int[]> getNeighbors(int[][] matrix, int row, int col, boolean[][] visited) {
        List<int[]> result = new ArrayList<>();

//        for (int[] bound : bounds) {
//            if (isValid(row, col, matrix, bound) && !visited[row + bound[0]][col + bound[1]]) {
//                result.add(new int[]{ row + bound[0], col + bound[1]});
//            }
//        }

        if (row > 0 && !visited[row - 1][col]) {
            result.add(new int[] {row - 1, col});
        }

        if (row < matrix.length - 1 && !visited[row + 1][col]) {
            result.add(new int[] {row + 1, col});
        }

        if (col > 0 && !visited[row][col - 1]) {
            result.add(new int[] {row, col - 1});
        }

        if (col < matrix[row].length - 1 && !visited[row][col + 1]) {
            result.add(new int[] {row, col + 1});
        }

        return result;
    }

    private boolean isValid(int row, int col, int[][] matrix, int[] bound) {
        return row + bound[0] > 0 && row + bound[0] < matrix.length - 1
                && col + bound[1] > 0 && col + bound[1] < matrix[row].length - 1;
    }


    enum Colors {
        WHITE, BLUE, GREEN
    }
}

class Grid2 {
    int[][] grid;

    public Grid2(int[][] grid) {
        this.grid = grid;
    }

    // O(n) time | O9n) space (n = w * h)
    public int maxConnectedColors() {
        int max_n = 0;
        Map<String, Boolean> visited = new HashMap<>();
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
//                max_n = Math.max(max_n, dfs(x, y, visited));
                max_n = Math.max(max_n, dfsIterative(x, y, visited));
            }
        }
        return max_n;
    }

    private int dfs(int x, int y, Map<String, Boolean> visited) {
        String key = x + "," + y;
        if (visited.containsKey(key)) {
            return 0;
        }
        visited.put(key, Boolean.TRUE);
        int result = 1;

        for (int[] neighbor : getNeighbors(x, y)) {
            result += dfs(neighbor[0], neighbor[1], visited);
        }
        return result;
    }

    private int dfsIterative(int x, int y, Map<String, Boolean> visited) {
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[] {x, y});
        int result = 0;
        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            int cX = top[0];
            int cY = top[1];
            String key = cX + ":" + cY;
            if (visited.containsKey(key)) {
                continue;
            }
            visited.put(key, Boolean.TRUE);

            result += 1;
            for (int[] neighbor : getNeighbors(cX, cY)) {
                stack.add(neighbor);
            }
        }
        return result;
    }

    private List<int[]> getNeighbors(int x, int y) {
        List<int[]> n = new ArrayList<>();
        int[][] positions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        for (int[] pos : positions) {
            if (colorAt(x + pos[0], y + pos[1]) == colorAt(x, y)) {
                n.add(new int[] {x + pos[0], y + pos[1]});
            }
        }
        return n;
    }

    private int colorAt(int x, int y) {
        if (x >= 0 && x < grid[0].length && y >= 0 && y < grid.length) {
            return grid[y][x];
        }
        return -1;
    }
}
