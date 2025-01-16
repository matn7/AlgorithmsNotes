package december_2024;

import java.util.Arrays;

public class UniquePaths {

    public static void main(String[] args) {
        int m = 3;
        int n = 7;

        UniquePaths uniquePaths = new UniquePaths();
        int result = uniquePaths.uniquePaths(m, n);
        System.out.println(result);
    }

    public int uniquePaths(int m, int n) {
        int[] prev = new int[n];
        Arrays.fill(prev, 1);
        for (int r = 1; r < m; r++) {
            int[] curr = new int[n];
            curr[0] = 1;
            for (int c = 1; c < n; c++) {
                curr[c] = curr[c - 1] + prev[c];
            }
            prev = curr;
        }
        return prev[prev.length - 1];
    }

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

        return dp[m - 1][n - 1];
    }

}
