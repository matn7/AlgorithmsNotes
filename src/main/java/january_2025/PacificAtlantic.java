package january_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlantic {

    public static void main(String[] args) {
        int[][] heights = {
            {4, 2, 7, 3, 4},
            {7, 4, 6, 4, 7},
            {6, 3, 5, 3, 6}
        };
    }

    // O(n*m) time | O(n*m) space
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];

        for (int c = 0; c < heights[0].length; c++) {
            dfs(0, c, pacific, heights);
            dfs(heights.length - 1, c, atlantic, heights);
        }

        for (int r = 0; r < heights.length; r++) {
            dfs(r, 0, pacific, heights);
            dfs(r, heights[0].length - 1, atlantic, heights);
        }

        for (int r = 0; r < heights.length; r++) {
            for (int c = 0; c < heights[0].length; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }
        return result;
    }

    private void dfs(int r, int c, boolean[][] ocean, int[][] heights) {
        ocean[r][c] = true;
        for (int[] d : directions) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr >= 0 && nr <= heights.length - 1 && nc >= 0 && nc <= heights[0].length - 1 && !ocean[nr][nc] &&
                heights[nr][nc] >= heights[r][c]) {
                dfs(nr, nc, ocean, heights);
            }
        }
    }

}
