package november_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {

    public static void main(String[] args) {
        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };

        PacificAtlanticWaterFlow pacificAtlanticWaterFlow = new PacificAtlanticWaterFlow();
        List<List<Integer>> result = pacificAtlanticWaterFlow.pacificAtlantic(heights);
        System.out.println(result);
    }

    // O(m * n) time | O(m * n) space
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];
        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < heights.length; r++) {
            canReach(heights, r, 0, -1, pacific);
            canReach(heights, r, heights[0].length - 1, -1, atlantic);
        }

        for (int c = 0; c < heights[0].length; c++) {
            canReach(heights, 0, c, -1, pacific);
            canReach(heights, heights.length - 1, c, -1, atlantic);
        }

        for (int r = 0; r < heights.length; r++) {
            for (int c = 0; c < heights[r].length; c++) {
                if (atlantic[r][c] && pacific[r][c]) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }

        return res;
    }

    private void canReach(int[][] heights, int r, int c, int level, boolean[][] ocean) {
        if (r < 0 || r >= heights.length || c < 0 || c >= heights[r].length || heights[r][c] < level || ocean[r][c]) {
            return;
        }
        ocean[r][c] = true;
        int curLevel = heights[r][c];
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        for (int[] dir : directions) {
            canReach(heights, r + dir[0], c + dir[1], curLevel, ocean);
        }
    }

}
