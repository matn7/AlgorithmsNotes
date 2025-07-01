package june_2025;

public class LongestIncreasingPathInMat {

    public static void main(String[] args) {
        int[][] matrix = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };

        LongestIncreasingPathInMat longestIncreasingPathInMat = new LongestIncreasingPathInMat();
        int result = longestIncreasingPathInMat.longestIncreasingPath(matrix);
        System.out.println(result);
    }

    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        int max = 1;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int r = 0; r < dp.length; r++) {
            for (int c = 0; c < dp[r].length; c++) {
                dp[r][c] = -1;
            }
        }
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                max = Math.max(max, dfs(matrix, r, c, -1, dp));
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int r, int c, int prev, int[][] dp) {
        if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length || prev >= matrix[r][c]) {
            return 0;
        }
        if (dp[r][c] != -1) {
            return dp[r][c];
        }
        int res = 1;
        int curr = matrix[r][c];
        for (int[] dir : directions) {
            res = Math.max(res, 1 + dfs(matrix, r + dir[0], c + dir[1], curr, dp));
        }
        dp[r][c] = res;
        return res;
    }

}
