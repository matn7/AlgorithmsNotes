package june_2025;

public class UniquePaths {

    public static void main(String[] args) {
        int m = 3;
        int n = 7;

        UniquePaths uniquePaths = new UniquePaths();
        int result = uniquePaths.uniquePaths(m, n);
        System.out.println(result);
    }

    // O(n*m) time | O(n*m) space
    public int uniquePaths(int m, int n) {
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
