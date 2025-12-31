package december_2025;

import java.util.Arrays;
import java.util.Map;

public class MinimumCoinCombination {

    public static void main(String[] args) {
//        int[] coins = {1, 2, 5};
//        int amount = 11;

        int[] coins = {2};
        int amount = 3;

        MinimumCoinCombination minimumCoinCombination = new MinimumCoinCombination();
        int result = minimumCoinCombination.coinChange(coins, amount);
        System.out.println(result);
    }

    // O(c * a) time | O(a) space
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.sort(coins); // O(c log(c)) time
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int coin : coins) {
            for (int a = 1; a <= amount; a++) {
                if (a >= coin) {
                    if (dp[a - coin] == Integer.MAX_VALUE) {
                        continue;
                    }
                    dp[a] = Math.min(dp[a], 1 + dp[a - coin]);
                }
            }
        }
        return dp[dp.length - 1] != Integer.MAX_VALUE ? dp[dp.length - 1] : -1;
    }

}
