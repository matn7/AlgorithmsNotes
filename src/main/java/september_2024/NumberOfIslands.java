package september_2024;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = {
                {'0', '1', '0', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        NumberOfIslands numberOfIslands = new NumberOfIslands();
        int result = numberOfIslands.numIslands(grid);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '1' && !visited[row][col]) {
                    count++;
                    dfs(grid, row, col, visited);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int row, int col, boolean[][] visited) {
        if (visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        List<int[]> neighbors = getNeighbors(grid, row, col, visited);

        for (int[] neighbor : neighbors) {
            int currRow = neighbor[0];
            int currCol = neighbor[1];
            dfs(grid, currRow, currCol, visited);
        }
    }

//    private void explore(char[][] grid, int row, int col, boolean[][] visited) {
//        Queue<int[]> queue = new LinkedList<>();
//        queue.add(new int[] {row, col});
//
//        while (!queue.isEmpty()) {
//            int[] current = queue.poll();
//            int currentRow = current[0];
//            int currentCol = current[1];
//            if (visited[currentRow][currentCol]) {
//                continue;
//            }
//            visited[currentRow][currentCol] = true;
//
//            List<int[]> neighbors = getNeighbors(grid, currentRow, currentCol, visited);
//            for (int[] neighbor : neighbors) {
//                queue.add(neighbor);
//            }
//        }
//    }

    private List<int[]> getNeighbors(char[][] grid, int row, int col, boolean[][] visited) {
        List<int[]> neighbors = new ArrayList<>();

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (isValidPos(newRow, newCol, grid) && !visited[newRow][newCol] && grid[newRow][newCol] == '1') {
                neighbors.add(new int[] {newRow, newCol});
            }
        }

        return neighbors;
    }

    private boolean isValidPos(int row, int col, char[][] grid) {
        return row >= 0 && row <= grid.length - 1 && col >= 0 && col <= grid[row].length - 1;
    }

}
