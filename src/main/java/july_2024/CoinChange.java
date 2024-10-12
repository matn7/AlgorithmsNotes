package july_2024;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1, 3, 5};
        int amount = 11;

        coinChange(coins, amount);
    }

    // O(ns) time | O(s) space (s amount, n coins)
    public static int coinChange(int[] coins, int amount) {

        //  5
        //c 3
        //  1
        //      0 1 2 1 2 1 2 3 4 3  2  3
        //      0 1 2 3 4 5 6 7 8 9 10 11
        //                              i

        if (amount <= 0) {
            return 0;
        }
        int[] result = new int[amount + 1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin && result[i - coin] != Integer.MAX_VALUE) {
                    result[i] = Math.min(result[i], result[i - coin] + 1);
                }
            }
        }

        return result[amount] == Integer.MAX_VALUE ? -1 : result[amount];
    }

}
