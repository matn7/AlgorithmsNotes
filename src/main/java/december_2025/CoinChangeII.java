package december_2025;

import java.util.*;

public class CoinChangeII {

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1,2,5};

        CoinChangeII coinChangeII = new CoinChangeII();
        int result = coinChangeII.change(amount, coins);
        System.out.println(result);
    }

    // O(n * a) time | O(a) space
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int a = 1; a <= amount; a++) {
                if (a >= coin) {
                    dp[a] = dp[a] + dp[a - coin];
                }
            }
        }
        return dp[amount];
    }

    // O(n * s) time | O(n * s) space
    public int change2(int amount, int[] coins) {
        Arrays.sort(coins);
        Map<String, Integer> memo = new HashMap<>();
        return backtrack(0, coins, 0, amount, memo);
    }

    private int backtrack(int i, int[] coins, int sum, int amount, Map<String, Integer> memo) {
        if (sum == amount) {
            return 1;
        }
        if (i == coins.length || sum > amount) {
            return 0;
        }
        String key = i + ":" + sum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        // include
        int count = backtrack(i, coins, sum + coins[i], amount, memo) + backtrack(i + 1, coins, sum, amount, memo);
        memo.put(key, count);
        return count;
    }


}
