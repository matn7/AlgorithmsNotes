package december_2024;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {5, 2, 1};
        int amount = 11;

//        int[] coins = {2};
//        int amount = 3;

        CoinChange coinChange = new CoinChange();
        int result = coinChange.coinChange(coins, amount);
        System.out.println(result);
    }

    // O(a * c) time | O(a) space
    public int coinChange(int[] coins, int amount) {

        int[] output = new int[amount + 1];
        Arrays.fill(output, Integer.MAX_VALUE);
        output[0] = 0;

        for (int coin : coins) {
            for (int a = 1; a <= amount; a++) {
                if (a >= coin) {
                    if (output[a - coin] != Integer.MAX_VALUE) {
                        output[a] = Math.min(output[a], output[a - coin] + 1);
                    }
                }
            }
        }

        return output[amount] == Integer.MAX_VALUE ? -1 : output[amount];
    }

}
