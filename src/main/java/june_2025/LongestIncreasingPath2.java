package june_2025;

public class LongestIncreasingPath2 {

    public static void main(String[] args) {
        int[][] matrix = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };

        LongestIncreasingPath2 longestIncreasingPath2 = new LongestIncreasingPath2();
        int result = longestIncreasingPath2.longestIncreasingPath(matrix);
        System.out.println(result);
    }


    // O(n * m) time | O(n * m) space
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];

        int max = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (dp[r][c] == 0) {
                    max = Math.max(max, dfs(matrix, r, c, -1, dp));
                } else {
                    max = Math.max(max, dp[r][c]);
                }
            }
        }

        return max;
    }

    private int dfs(int[][] matrix, int r, int c, int prev, int[][] dp) {
        if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length || prev >= matrix[r][c]) {
            return 0;
        }
        if (dp[r][c] != 0) {
            return dp[r][c];
        }
        int currMax = 1;
        int curr = matrix[r][c];

        for (int[] dir : directions) {
            currMax =Math.max(currMax, 1 + dfs(matrix, r + dir[0], c + dir[1], curr, dp));
        }
        dp[r][c] = currMax;
        return currMax;
    }

}
