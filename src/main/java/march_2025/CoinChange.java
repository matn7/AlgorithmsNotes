package march_2025;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
//        int[] coins = {1, 2, 5};
//        int amount = 11;

        int[] coins = {2};
        int amount = 3;

        CoinChange coinChange = new CoinChange();
        int result = coinChange.coinChange(coins, amount);
        System.out.println(result);
    }

    // O(c * a) time | O(a) space
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int c : coins) {
            for (int i = 0; i < dp.length; i++) {
                if (i >= c && dp[i - c] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - c]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

}
