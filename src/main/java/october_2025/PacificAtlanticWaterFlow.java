package october_2025;

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

    // O(n * m) time | O(n * m) space
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];


        for (int r = 0; r < pacific.length; r++) {
            dfs(heights, r, 0, -1, pacific);
            dfs(heights, r, heights[r].length - 1, -1, atlantic);
        }
        for (int c = 0; c < pacific[0].length; c++) {
            dfs(heights, 0, c, -1, pacific);
            dfs(heights, atlantic.length - 1, c, -1, atlantic);
        }

        for (int r = 0; r < pacific.length; r++) {
            for (int c = 0; c < pacific[r].length; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights, int r, int c, int prev, boolean[][] ocean) {
        if (r < 0 || r >= heights.length || c < 0 || c >= heights[r].length || heights[r][c] < prev || ocean[r][c]) {
            return;
        }
        ocean[r][c] = true;
        for (int[] dir : directions) {
            dfs(heights, r + dir[0], c + dir[1], heights[r][c], ocean);
        }
    }

}
