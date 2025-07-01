package june_2025;

public class LongestIncreasingPath {

    public static void main(String[] args) {
        int[][] matrix = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };

        LongestIncreasingPath longestIncreasingPath = new LongestIncreasingPath();
        int result = longestIncreasingPath.longestIncreasingPath(matrix);
        System.out.println(result);
    }

    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];

        int max = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                max = Math.max(max, dfs(matrix, r, c, dp, -1));

            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int r, int c, int[][] dp, int prev) {
        if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length || matrix[r][c] <= prev) {
            return 0;
        }
        if (dp[r][c] != 0) {
            return dp[r][c];
        }
        int res = 1;
        res = Math.max(res, 1 + dfs(matrix, r + 1, c, dp, matrix[r][c]));
        res = Math.max(res, 1 + dfs(matrix, r - 1, c, dp, matrix[r][c]));
        res = Math.max(res, 1 + dfs(matrix, r, c + 1, dp, matrix[r][c]));
        res = Math.max(res, 1 + dfs(matrix, r, c - 1, dp, matrix[r][c]));
        dp[r][c] = res;
        return res;
    }

}
