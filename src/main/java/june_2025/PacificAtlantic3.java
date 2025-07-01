package june_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlantic3 {

    public static void main(String[] args) {
        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };

        PacificAtlantic3 pacificAtlantic3 = new PacificAtlantic3();
        List<List<Integer>> result = pacificAtlantic3.pacificAtlantic(heights);
        System.out.println(result);
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];
        List<List<Integer>> result = new ArrayList<>();

        for (int r = 0; r < heights.length; r++) {
            dfs(heights, r, 0, pacific, -1);
            dfs(heights, r, heights[r].length - 1, atlantic, -1);
        }

        for (int c = 0; c < heights[0].length; c++) {
            dfs(heights, 0, c, pacific, -1);
            dfs(heights, heights.length - 1, c, atlantic, -1);
        }

        for (int r = 0; r < heights.length; r++) {
            for (int c = 0; c < heights[r].length; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] height, int r, int c, boolean[][] ocean, int prev) {
        if (r < 0 || r >= height.length || c < 0 || c >= height[r].length || ocean[r][c] || prev > height[r][c]) {
            return;
        }
        ocean[r][c] = true;
        int curr = height[r][c];
        dfs(height, r + 1, c, ocean, curr);
        dfs(height, r - 1, c, ocean, curr);
        dfs(height, r, c + 1, ocean, curr);
        dfs(height, r, c - 1, ocean, curr);
    }

}
