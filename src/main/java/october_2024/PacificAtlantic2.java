package october_2024;

import java.util.*;

public class PacificAtlantic2 {

    public static void main(String[] args) {
        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };

        PacificAtlantic2 pacificAtlantic = new PacificAtlantic2();
        List<List<Integer>> result = pacificAtlantic.pacificAtlantic(heights);
        System.out.println(result);
    }

    // O(n*m) time | O(n*m) space
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();

        int rows = heights.length;
        int cols = heights[0].length;
        Set<String> pac = new HashSet<>();
        Set<String> atl = new HashSet<>();

        for (int c = 0; c < cols; c++) {
            dfs(0, c, pac, heights[0][c], heights);
            dfs(rows - 1, c, atl, heights[rows - 1][c], heights);
        }

        for (int r = 0; r < rows; r++) {
            dfs(r, 0, pac, heights[r][0], heights);
            dfs(r, cols - 1, atl, heights[r][cols - 1], heights);
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                String key = getKey(r, c);
                if (pac.contains(key) && atl.contains(key)) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int r, int c, Set<String> visit, int prevHeight, int[][] heights) {
        String key = getKey(r, c);
        if (visit.contains(key)
                || r < 0 || c < 0 || r == heights.length || c == heights[r].length
                || heights[r][c] < prevHeight) {
            return;
        }
        visit.add(key);
        dfs(r + 1, c, visit, heights[r][c], heights);
        dfs(r - 1, c, visit, heights[r][c], heights);
        dfs(r, c + 1, visit, heights[r][c], heights);
        dfs(r, c - 1, visit, heights[r][c], heights);
    }

    private String getKey(int r, int c) {
        return r + ":" + c;
    }




}
