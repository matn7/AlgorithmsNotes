package december_2025;

import java.util.ArrayList;
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
    }

    // O(n * m) time | O(n * m) space
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];

        // populate tables
        for (int row = 0; row < heights.length; row++) {
            dfs(row, 0, -1, pacific, heights);
            dfs(row, heights[row].length - 1, -1, atlantic, heights);
        }

        for (int col = 0; col < heights[0].length; col++) {
            dfs(0, col, -1, pacific, heights);
            dfs(heights.length - 1, col, -1, atlantic, heights);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }
        return result;
    }

    private void dfs(int r, int c, int prev, boolean[][] ocean, int[][] heights) {
        if (r < 0 || r >= heights.length || c < 0 || c >= heights[r].length || heights[r][c] < prev || ocean[r][c]) {
            return;
        }
        ocean[r][c] = true;
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int curHeight = heights[r][c];
        for (int[] dir : directions) {
            dfs(r + dir[0], c + dir[1], curHeight, ocean, heights);
        }
    }

}
