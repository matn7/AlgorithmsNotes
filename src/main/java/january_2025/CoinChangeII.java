package january_2025;

import java.util.Arrays;

public class CoinChangeII {

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};

        CoinChangeII coinChangeII = new CoinChangeII();
        int change = coinChangeII.change(amount, coins);
        System.out.println(change);
    }

    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        Arrays.sort(coins);

        for (int i = 0; i <= coins.length; i++) {
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
