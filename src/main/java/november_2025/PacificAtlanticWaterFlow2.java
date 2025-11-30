package november_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow2 {

    // O(n * m) time | O(n * m) space
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];

        for (int r = 0; r < heights.length; r++) {
            canReach(heights, r, 0, -1, pacific);
            canReach(heights, r, heights[r].length - 1, -1, atlantic);
        }
        for (int c = 0; c < heights[0].length; c++) {
            canReach(heights, 0, c, -1, pacific);
            canReach(heights, heights.length - 1, c, -1, atlantic);
        }

        for (int r = 0; r < heights.length; r++) {
            for (int c = 0; c < heights[r].length; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
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
        int curLevel = heights[r][c];
        ocean[r][c] = true;
        for (int[] dir : directions) {
            canReach(heights, r + dir[0], c + dir[1], curLevel, ocean);
        }
    }

}
