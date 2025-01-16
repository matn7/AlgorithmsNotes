package december_2024;

import java.util.*;

public class PacificAtlantic {

    public static void main(String[] args) {
//        int[][] heights = {
//                {4, 2, 7, 3, 4},
//                {7, 4, 6, 4, 7},
//                {6, 3, 5, 3, 6}
//        };

        int[][] heights = {
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5}
        };


        // [[0,2],[0,4],[1,0],[1,1],[1,2],[1,3],[1,4],[2,0]]


        PacificAtlantic pacificAtlantic = new PacificAtlantic();

        List<List<Integer>> result = pacificAtlantic.pacificAtlantic(heights);
        System.out.println(result);
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();

        int ROWS = heights.length;
        int COLS = heights[0].length;
        Set<String> pac = new HashSet<>();
        Set<String> atl = new HashSet<>();

        for (int c = 0; c < COLS; c++) {
            dfs(0, c, pac, heights[0][c], heights, ROWS, COLS);
            dfs(ROWS - 1, c, atl, heights[ROWS - 1][c], heights, ROWS, COLS);
        }

        for (int r = 0; r < ROWS; r++) {
            dfs(r, 0, pac, heights[r][0], heights, ROWS, COLS);
            dfs(r, COLS - 1, atl, heights[r][COLS - 1], heights, ROWS, COLS);
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                String key = getKey(r, c);
                if (pac.contains(key) && atl.contains(key)) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int r, int c, Set<String> visit, int preHeight, int[][] heights, int ROWS, int COLS) {
        String key = getKey(r, c);
        if (visit.contains(key) || r < 0 || c < 0 || r == ROWS || c == COLS || heights[r][c] < preHeight) {
            return;
        }
        visit.add(key);
        dfs(r + 1, c, visit, heights[r][c], heights, ROWS, COLS);
        dfs(r - 1, c, visit, heights[r][c], heights, ROWS, COLS);
        dfs(r, c + 1, visit, heights[r][c], heights, ROWS, COLS);
        dfs(r, c - 1, visit, heights[r][c], heights, ROWS, COLS);
    }

    private String getKey(int r, int c) {
        return r + ":" + c;
    }
}
