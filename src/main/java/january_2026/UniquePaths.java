package january_2026;

import java.util.Arrays;

public class UniquePaths {

    public static void main(String[] args) {
        int m = 3;
        int n = 7;

        UniquePaths uniquePaths = new UniquePaths();
        int result = uniquePaths.uniquePaths(m, n);
        System.out.println(result);
    }

    // O(m * n) time | O(n) space
    public int uniquePaths(int m, int n) {
        int[] prev = new int[n + 1];
        Arrays.fill(prev, 1);

        for (int i = 1; i < m; i++) {
            int[] curr = new int[n + 1];
            for (int j = n - 1; j >= 0; j--) {
                curr[j] = prev[j] + curr[j + 1];
            }
            prev = curr;
        }
        return prev[0];
    }

    // O(n * m) time | O(n * m) space
    public int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];

        for (int r = 0; r < dp.length; r++) {
            dp[r][0] = 1;
        }
        for (int c = 0; c < dp[0].length; c++) {
            dp[0][c] = 1;
        }
        for (int r = 1; r < dp.length; r++) {
            for (int c = 1; c < dp[r].length; c++) {
                dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

}
