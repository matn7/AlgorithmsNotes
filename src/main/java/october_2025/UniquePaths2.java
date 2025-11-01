package october_2025;

import java.util.Arrays;

public class UniquePaths2 {

    public static void main(String[] args) {
        int m = 3;
        int n = 7;

        UniquePaths2 uniquePaths2 = new UniquePaths2();
        int result = uniquePaths2.uniquePaths(m, n);
        System.out.println(result);
    }

    // O(n * m) time | O(n) space
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
        return prev[n - 1];
    }

    // O(n * m) time | O(n * m) space
    public int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];
        for (int r = 0; r < m; r++) {
            dp[r][0] = 1;
        }
        for (int c = 0; c < n; c++) {
            dp[0][c] = 1;
        }
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
            }
        }
        return dp[m - 1][n - 1];
    }


}
