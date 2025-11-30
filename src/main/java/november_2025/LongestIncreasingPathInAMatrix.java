package november_2025;

public class LongestIncreasingPathInAMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };

        LongestIncreasingPathInAMatrix longestIncreasingPathInAMatrix = new LongestIncreasingPathInAMatrix();
        int result = longestIncreasingPathInAMatrix.longestIncreasingPath(matrix);
        System.out.println(result);
    }

    // O(n * m) time | O(n * m) space
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int r = 0; r < dp.length; r++) {
            for (int c = 0; c < dp[r].length; c++) {
                dp[r][c] = -1;
            }
        }
        int maxPath = 1;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (dp[r][c] == -1) {
                    maxPath = Math.max(maxPath, dfs(matrix, r, c, -1, dp));
                }
            }
        }
        return maxPath;
    }

    private int dfs(int[][] matrix, int r, int c, int prev, int[][] dp) {
        if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length || matrix[r][c] <= prev) { // 9 <= 4
            return 0;
        }
        if (dp[r][c] != -1) {
            return dp[r][c];
        }
        int cur = matrix[r][c];
        int res = 1;
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for (int[] dir : directions) {
            res= Math.max(res, 1 + dfs(matrix, r + dir[0], c + dir[1], cur, dp));
        }
        dp[r][c] = res;
        return res;
    }

}
