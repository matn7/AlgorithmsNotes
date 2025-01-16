package december_2024;

import java.util.Arrays;

public class CoinChangeII {

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};

        CoinChangeII coinChangeII = new CoinChangeII();
        int result = coinChangeII.change(amount, coins);
        System.out.println(result);
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        Arrays.sort(coins);

        int[][] dp = new int[n + 1][amount + 1];

        for (int r = 0; r < dp.length; r++) {
            dp[r][0] = 1;
        }

        for (int i = n - 1; i >= 0; i--) {
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
