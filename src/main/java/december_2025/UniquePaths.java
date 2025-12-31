package december_2025;

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
        int[] prev = new int[n + 1];
        Arrays.fill(prev, 1);

        for (int r = m - 1; r >= 1; r--) {
            int[] curr = new int[n];
            curr[n - 1] = 1;
            for (int c = n - 2; c >= 0; c--) {
                curr[c] = curr[c + 1] + prev[c];
            }
            prev = curr;
        }
        return prev[0];
    }

    // O(n * m) time | O(n * m) space
    public int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 1;
        }
        for (int r = 1; r < dp.length; r++) {
            for (int c = 1; c < dp[r].length; c++) {
                dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

}
