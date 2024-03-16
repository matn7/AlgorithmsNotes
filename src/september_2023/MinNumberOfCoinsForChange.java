package september_2023;

import java.util.Arrays;

public class MinNumberOfCoinsForChange {

    public static void main(String[] args) {
        int n = 7;
        int[] denoms = {1, 5, 10};

        minNumberOfCoinsForChange(n, denoms);
    }

    // O(nd) time | O(n) space
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        // Write your code here.

        //                  10
        //                  5
        //                  1
        // ---------------------
        // 0 1 2 3 4 5 5 7      coins
        // 0 1 2 3 4 5 6 7

        int[] coins = new int[n + 1];
        Arrays.fill(coins, Integer.MAX_VALUE - 1);
        coins[0] = 0;

        for (int d : denoms) {
            for (int c = 1; c < coins.length; c++) {
                if (c >= d) { // 2 >= 1
                    coins[c] = Math.min(coins[c], coins[c - d] + 1);
                }
            }
        }
        return coins[n] == Integer.MAX_VALUE - 1 ? -1 : coins[n];
    }

}
