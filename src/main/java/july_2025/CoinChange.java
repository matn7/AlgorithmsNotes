package july_2025;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;

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
            for (int a = 1; a < amount; a++) {
                if (a >= c) {
                    if (dp[a - c] == Integer.MAX_VALUE) {
                        continue;
                    }
                    dp[a] = Math.min(dp[a], 1 + dp[a - c]);
                }
            }
        }
        return dp[dp.length - 1] == Integer.MAX_VALUE ? -1 : dp[dp.length - 1];
    }

}
