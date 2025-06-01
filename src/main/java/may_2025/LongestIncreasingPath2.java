package may_2025;

public class LongestIncreasingPath2 {

    public static void main(String[] args) {
        int[][] matrix = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 2}
        };
        LongestIncreasingPath2 path2 = new LongestIncreasingPath2();
        int result = path2.longestIncreasingPath(matrix);
        System.out.println(result);
    }

    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m][n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                max = Math.max(max, dfs(r, c, -1, matrix, dp));
            }
        }
        return max;
    }

    private int dfs(int r, int c, int prev, int[][] matrix, int[][] dp) {
        if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length || prev >= matrix[r][c]) {
            return 0;
        }
        if (dp[r][c] != 0) {
            return dp[r][c];
        }
        int res = 1;
        for (int[] dir : directions) {
            res = Math.max(res, 1 + dfs(r + dir[0], c + dir[1], matrix[r][c], matrix, dp));
        }
        dp[r][c] = res;
        return res;
    }

}
