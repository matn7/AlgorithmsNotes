package june_2025;

public class CoinChangeIIDfs {

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};

        CoinChangeIIDfs coinChange = new CoinChangeIIDfs();
        int result = coinChange.change(amount, coins);
        System.out.println(result);
    }

    int[][] dp;

    public int change(int amount, int[] coins) {
        dp = new int[coins.length + 1][amount + 1];
        for (int r = 0; r < dp.length; r++) {
            for (int c = 0; c < dp[r].length; c++) {
                dp[r][c] = -1;
            }
        }
        return dfs(amount, 0, coins);
    }

    private int dfs(int a, int i, int[] coins) {
        if (a == 0) {
            return 0;
        }
        if (i >= coins.length) {
            return 0;
        }
        if (dp[a][i] != -1) {
            return dp[a][i];
        }
        int res = 0;
        if (a >= coins[i]) {
            res = dfs(a, i + 1, coins);
            res += dfs(a, i, coins);
        }
        dp[a][i] = res;
        return res;
    }

}
