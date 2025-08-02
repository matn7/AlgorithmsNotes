package july_2025;

import java.util.Arrays;

public class CoinChangeII2 {

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1,2,5};

        CoinChangeII2 coinChangeII2 = new CoinChangeII2();
        int result = coinChangeII2.change(amount, coins);
        System.out.println(result);
    }

    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int[][] memo = new int[coins.length + 1][amount + 1];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                memo[i][j] = -1;
            }
        }
        return dfs(amount, 0, coins, memo);
    }

    private int dfs(int a, int i, int[] coins, int[][] memo) {
        if (a == 0) {
            return 1;
        }
        if (i >= coins.length) {
            return 0;
        }
        if (memo[i][a] != -1) {
            return memo[i][a];
        }
        int res = 0;
        if (a >= coins[i]) {
            res = dfs(a, i + 1, coins, memo); // do not repeat number
            res += dfs(a - coins[i], i, coins, memo);
        }
        memo[i][a] = res;
        return res;
    }

    // O(n * m) time | O(n * m) space
    public int change2(int amount, int[] coins) {
        Arrays.sort(coins);
        int[][] dp = new int[coins.length + 1][amount + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = coins.length - 1; i >= 0; i--) {
            for (int a = 0; a <= amount; a++) {
                if (a >= coins[i]) {
                    dp[i][a] = dp[i + 1][a];
                    dp[i][a] += dp[i][a - coins[i]];
                }
            }
        }

        return dp[0][amount];
    }

}
