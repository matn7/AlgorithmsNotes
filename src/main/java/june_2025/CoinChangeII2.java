package june_2025;

import java.util.Arrays;

public class CoinChangeII2 {

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};

        CoinChangeII2 coinChangeII2 = new CoinChangeII2();
        int result = coinChangeII2.change(amount, coins);
        System.out.println(result);
    }

    // O(n * m) time | O(n * m) space
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];

        for (int r = 0; r < dp.length; r++) {
            dp[r][0] = 1;
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


    // O(n*m) time | O(n*m) space
    public int change2(int amount, int[] coins) {
        Arrays.sort(coins);
        int[][] memo = new int[coins.length + 1][amount + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(0, amount, coins, memo);
    }

    private int dfs(int i, int a, int[] coins, int[][] memo) {
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
            res = dfs(i + 1, a, coins, memo);
            res += dfs(i, a - coins[i], coins, memo);
        }
        memo[i][a] = res;
        return res;

    }

}
