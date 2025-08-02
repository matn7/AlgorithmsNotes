package june_2025;

import java.util.Arrays;

public class CoinChange2 {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;

//        int[] coins = {2};
//        int amount = 3;

        CoinChange2 coinChange2 = new CoinChange2();
        int result = coinChange2.coinChange(coins, amount);
        System.out.println(result);
    }

    // O(n * m) time | O(n) space
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int c : coins) {
            for (int i = 1; i < dp.length; i++) {
                if (i >= c) {
                    if (dp[i - c] == Integer.MAX_VALUE) {
                        continue;
                    }
                    dp[i] = Math.min(dp[i], 1 + dp[i - c]);
                }
            }
        }
        return dp[dp.length - 1] == Integer.MAX_VALUE ? -1 : dp[dp.length - 1];
    }

}
