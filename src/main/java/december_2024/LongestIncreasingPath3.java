package december_2024;

import java.util.Map;

public class LongestIncreasingPath3 {

    public static void main(String[] args) {
//        int[][] matrix = {
//                {5, 5, 3},
//                {2, 3, 6},
//                {1, 1, 1}
//        };

        // [[9,9,4],[6,6,8],[2,1,1]]
        int[][] matrix = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };

        LongestIncreasingPath3 longestIncreasingPath = new LongestIncreasingPath3();
        int result = longestIncreasingPath.longestIncreasingPath(matrix);
        System.out.println(result);
    }

    // O(n*m) time | O(n*m) space
    public int longestIncreasingPath(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                max = Math.max(max, dfs(r, c, -1, matrix, visited, dp));
            }
        }
        return max;
    }

    private int dfs(int r, int c, int prev, int[][] matrix, boolean[][] visited, int[][] dp) {
        if (r < 0 || r == matrix.length || c < 0 || c == matrix[r].length || matrix[r][c] <= prev) {
            return 0;
        }
        if (visited[r][c]) {
            return dp[r][c];
        }

        int res = 1;
        res = Math.max(res, 1 + dfs(r + 1, c, matrix[r][c], matrix, visited, dp));
        res = Math.max(res, 1 + dfs(r - 1, c, matrix[r][c], matrix, visited, dp));
        res = Math.max(res, 1 + dfs(r, c + 1, matrix[r][c], matrix, visited, dp));
        res = Math.max(res, 1 + dfs(r, c - 1, matrix[r][c], matrix, visited, dp));
        visited[r][c] = true;
        dp[r][c] = res;
        return res;
    }

}
