package may_2025;

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
            for (int c = 0; c < matrix.length; c++) {
                max = Math.max(max, dfs(r, c, -1, matrix, dp));
            }
        }
        return max;
    }

    private int dfs(int r, int c, int prevVal, int[][] matrix, int[][] dp) {
        if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length || matrix[r][c] <= prevVal) {
            return 0;
        }
        if (dp[r][c] != 0) {
            return dp[r][c];
        }

        int res = 1;
        res = Math.max(res, 1 + dfs(r + 1, c, matrix[r][c], matrix, dp));
        res = Math.max(res, 1 + dfs(r - 1, c, matrix[r][c], matrix, dp));
        res = Math.max(res, 1 + dfs(r, c + 1, matrix[r][c], matrix, dp));
        res = Math.max(res, 1 + dfs(r, c - 1, matrix[r][c], matrix, dp));
        dp[r][c] = res;
        return res;
    }

}
