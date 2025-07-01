package june_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlantic2 {

    public static void main(String[] args) {
        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };

        PacificAtlantic2 pacificAtlantic2 = new PacificAtlantic2();
        List<List<Integer>> result = pacificAtlantic2.pacificAtlantic(heights);
        System.out.println(result);
    }

    // O(n * m) time | O(n * m) space
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];

        for (int r = 0; r < heights.length; r++) {
            dfs(heights, pacific, r, 0, heights[r][0]);
            dfs(heights, atlantic, r, heights[0].length - 1,
                    heights[r][heights[0].length - 1]);
        }
        for (int c = 0; c < heights[0].length; c++) {
            dfs(heights, pacific, 0, c, heights[0][c]);
            dfs(heights, atlantic, heights.length - 1, c,
                    heights[heights.length - 1][c]);
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

    private void dfs(int[][] heights, boolean[][] ocean, int r, int c, int prev) {
        if (r < 0 || r >= heights.length || c < 0 || c >= heights[r].length
                || ocean[r][c] || heights[r][c] < prev) {
            return;
        }

        ocean[r][c] = true;
        int curr = heights[r][c];
        dfs(heights, ocean, r + 1, c, curr);
        dfs(heights, ocean, r - 1, c, curr);
        dfs(heights, ocean, r, c + 1, curr);
        dfs(heights, ocean, r, c - 1, curr);
    }


}
