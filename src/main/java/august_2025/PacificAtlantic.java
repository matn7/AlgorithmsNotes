package august_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlantic {

    // r, c, ocean, prev

    // O(n * m) time | O(n * m) space
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];

        for (int r = 0; r < heights.length; r++) {
            dfs(heights, r, 0, pacific, -1);
            dfs(heights, r, heights[r].length - 1, atlantic, -1);
        }

        for (int c = 0; c < heights[0].length; c++) {
            dfs(heights, 0, c, pacific, -1);
            dfs(heights, heights.length - 1, c, atlantic, -1);

        }
        List<List<Integer>> result = new ArrayList<>();
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
        prev = height[r][c];
        ocean[r][c] = true;
        dfs(height, r - 1, c, ocean, prev);
        dfs(height, r + 1, c, ocean, prev);
        dfs(height, r, c - 1, ocean, prev);
        dfs(height, r, c + 1, ocean, prev);
    }
}
