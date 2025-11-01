package october_2025;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
//        int[] coins = {1,2,5};
//        int amount = 11;

        int[] coins = {2};
        int amount = 3;

        CoinChange coinChange = new CoinChange();
        int result = coinChange.coinChange(coins, amount);
        System.out.println(result);
    }

    // O(n * m) time | O(m) space
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (i >= coin) {
                    if (dp[i - coin] == Integer.MAX_VALUE) {
                        continue;
                    }
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

}
