package july_2025;

public class OnesAndZeroes {

    private int[][][] dp;
    private int[][] arr;

    // O(n * m * N) time | O(n * m * N) space
    public int findMaxForm(String[] strs, int m, int n) {
        arr = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            for (char c : strs[i].toCharArray()) {
                arr[i][c - '0']++;
            }
        }

        dp = new int[strs.length][m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return dfs(0, m, n);
    }

    private int dfs(int i, int m, int n) {
        if (i == arr.length) {
            return 0;
        }
        if (m == 0 && n == 0) {
            return 0;
        }
        if (dp[i][m][n] != -1) {
            return dp[i][m][n];
        }
        int res = dfs(i + 1, m, n);
        if (m >= arr[i][0] && n >= arr[i][1]) {
            res = Math.max(res, 1 + dfs(i + 1, m - arr[i][0], n - arr[i][1]));
        }
        dp[i][m][n] = res;
        return res;
    }

}
