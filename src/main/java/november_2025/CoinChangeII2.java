package november_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        Arrays.sort(coins);
        int[][] dp = new int[coins.length + 1][amount];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }

        return backtrack(coins, 0, 0, amount, dp);
    }

    private int backtrack(int[] coins, int i, int sum, int amount, int[][] dp) {
        if (sum == amount) {
            return 1;
        }
        if (i >= coins.length || sum > amount) {
            return 0;
        }
        if (dp[i][sum] != -1) {
            return dp[i][sum];
        }
        int res = 0;
        res += backtrack(coins, i, sum + coins[i], amount, dp); // include
        res += backtrack(coins, i + 1, sum, amount, dp); // not include

        dp[i][sum] = res;
        return res;
    }

}
