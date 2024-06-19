package may_2024;

import java.util.Arrays;

public class MinNumberOfCoins {

    public static void main(String[] args) {
        int[] denoms = {1, 5, 10};
        int n = 7;

        int result = minNumberOfCoins(denoms, n);
        System.out.println(result);
    }

    // O(nd) time | O(n) space
    public static int minNumberOfCoins(int[] denoms, int n) {
        int[] coins = new int[n + 1];
        Arrays.fill(coins, Integer.MAX_VALUE);
        coins[0] = 0;
        for (int d : denoms) {
            for (int c = 1; c < coins.length; c++) {
                if (c >= d) {
                    coins[c] = Math.min(coins[c], coins[c - d] + 1);
                }
            }
        }
        return coins[n];
    }

}
