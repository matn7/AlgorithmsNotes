package july_2025;

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

    // O(n * m) time | O(n * m) space
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];

        int maxLen = 0;

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                maxLen = Math.max(maxLen, dfs(matrix, r, c, -1, dp));
            }
        }

        return maxLen;
    }

    private int dfs(int[][] matrix, int r, int c, int prev, int[][] dp) {
        if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length || prev >= matrix[r][c]) {
            return 0;
        }
        if (dp[r][c] != 0) {
            return dp[r][c];
        }
        int maxLen = 0;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int curr = matrix[r][c];
        for (int dir[] : dirs) {
            maxLen = Math.max(maxLen, 1 + dfs(matrix, r + dir[0], c + dir[1], curr, dp));
        }
        dp[r][c] = maxLen;
        return maxLen;
    }


}
