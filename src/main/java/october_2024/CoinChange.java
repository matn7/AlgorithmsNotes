package october_2024;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 3;

        CoinChange coinChange = new CoinChange();
        int result = coinChange.coinChange(coins, amount);
        System.out.println(result);
    }

    // O(n*c) time | O(n) space
    public int coinChange(int[] coins, int amount) {
        int[] result = new int[amount + 1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;

        for (int coin : coins) {
            for (int a = 1; a <= amount; a++) {
                if (a >= coin && result[a - coin] != Integer.MAX_VALUE) {
                    result[a] = Math.min(result[a], result[a - coin] + 1);
                }
            }
        }

        return result[result.length - 1] == Integer.MAX_VALUE ? -1 : result[result.length - 1];
    }

}
