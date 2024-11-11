package october_2024;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountIslands {

    public static void main(String[] args) {
        int[][] grid1 = {
                {1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1}
        };

        int[][] grid2 = {
                {1, 1, 1, 0, 0},
                {0, 0, 1, 1, 1},
                {0, 1, 0, 0, 0},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 1, 0}
        };

        CountIslands countIslands = new CountIslands();
        int result = countIslands.countSubIslands(grid1, grid2);
        System.out.println(result);
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        Set<String> visit = new HashSet<>();

        for (int r = 0; r < grid1.length; r++) {
            for (int c = 0; c < grid1[r].length; c++) {
                String key = getKey(r, c);
                if (grid2[r][c] == 1 && !visit.contains(key) && dfs(r, c, grid1, grid2, visit)) {
                    count++;
                }
            }
        }
        return count;
    }

    private String getKey(int r, int c) {
        return r + ":" + c;
    }

    private boolean dfs(int r, int c, int[][] grid1, int[][] grid2, Set<String> visit) {
        String key = getKey(r, c);
        if (r < 0 || c < 0 || r == grid1.length || c == grid1[r].length || grid2[r][c] == 0 || visit.contains(key)) {
            return true;
        }
        visit.add(key);
        boolean res = true;
        if (grid1[r][c] == 0) {
            res = false;
        }
        res = dfs(r - 1, c, grid1, grid2, visit) && res;
        res = dfs(r + 1, c, grid1, grid2, visit) && res;
        res = dfs(r, c - 1, grid1, grid2, visit) && res;
        res = dfs(r, c + 1, grid1, grid2, visit) && res;
        return res;
    }

}


























