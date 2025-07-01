package june_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        // [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]]
        // [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]]
    }


    // O(n*m) time | O(n*m) space
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];

        for (int r = 0; r < heights.length; r++) {
            dfs(r, 0, heights, pacific, heights[r][0]);
            dfs(r, heights[0].length - 1, heights, atlantic,
                    heights[r][heights[0].length - 1]);
        }
        for (int c = 0; c < heights[0].length; c++) {
            dfs(0, c, heights, pacific, heights[0][c]);
            dfs(heights.length - 1, c, heights, atlantic,
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

    private void dfs(int r, int c, int[][] heights, boolean[][] ocean, int prevVal) {
        if (r < 0 || r >= heights.length || c < 0 || c >= heights[r].length || ocean[r][c] || prevVal > heights[r][c]) {
            return;
        }
        ocean[r][c] = true;
        dfs(r + 1, c, heights, ocean, heights[r][c]);
        dfs(r - 1, c, heights, ocean, heights[r][c]);
        dfs(r, c + 1, heights, ocean, heights[r][c]);
        dfs(r, c - 1, heights, ocean, heights[r][c]);
    }



}
