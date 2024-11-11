package october_2024;

import java.util.*;

public class PacificAtlantic {

    public static void main(String[] args) {
        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };

        PacificAtlantic pacificAtlantic = new PacificAtlantic();
        List<List<Integer>> result = pacificAtlantic.pacificAtlantic(heights);
        System.out.println(result);
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Set<String> canReachBoth = new HashSet<>();
        for (int row = 0; row < heights.length; row++) {
            for (int col = 0; col < heights[row].length; col++) {
                String key = getKey(row, col);
                if (!visited.contains(key)) {
                    dfs(row, col, heights, visited, canReachBoth, result);
                }
            }
        }

        return result;
    }

    private void dfs(int row, int col, int[][] heights, Set<String> visited, Set<String> canReachBoth, List<List<Integer>> result) {
        String key = getKey(row, col);
        if ((isPacificOcean(row, col, heights) && isAtlanticOcean(row, col, heights)) && !visited.contains(key)) {
            result.add(Arrays.asList(row, col));
            canReachBoth.add(key);
            return;
        }
        if (row == 3 && col == 3) {
            System.out.println();
        }
        visited.add(key);
        int[][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        for (int[] direction : directions) {
            int newRow = direction[0] + row;
            int newCol = direction[1] + col;
            // valid coord and curr height is greater then neighbor and neighbor not visited
            if (isValidPos(newRow, newCol, heights) && canReachNeighbor(row, col, newRow, newCol, heights)
                    && !visited.contains(getKey(newRow, newCol))) {
                if (canReachBoth.contains(getKey(newRow, newCol))) {
                    result.add(Arrays.asList(row, col));
                    return;
                }
                dfs(newRow, newCol, heights, visited, canReachBoth, result);
            }
        }
    }

    private boolean isValidPos(int row, int col, int[][] heights) {
        return row >= 0 && row <= heights.length - 1 && col >= 0 && col <= heights[row].length - 1;
    }

    private boolean canReachNeighbor(int row, int col, int newRow, int newCol, int[][] heights) {
        int currentHeight = heights[row][col];
        int neighborHeights = heights[newRow][newCol];
        return currentHeight >= neighborHeights;
    }

    private boolean isPacificOcean(int row, int col, int[][] heights) {
        return row == 0 || col == 0;
    }

    private boolean isAtlanticOcean(int row, int col, int[][] heights) {
        return row == heights.length - 1 || col == heights[row].length - 1;
    }

    private String getKey(int row, int col) {
        return row + ":" + col;
    }

}
