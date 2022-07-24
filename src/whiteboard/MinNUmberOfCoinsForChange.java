package whiteboard;

import java.util.Arrays;

public class MinNUmberOfCoinsForChange {

    // O(nd) time | O(n) space (n - target amount, d - num of coins denominations)
    // #2: 12/07/2022
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        // Write your code here.
        int[] coins = new int[n + 1];
        Arrays.fill(coins, 9999);
        coins[0] = 0;

        for (int denom : denoms) {
            for (int c = 0; c <= n; c++) {
                if (c >= denom) {
                    coins[c] = Math.min(coins[c], 1 + coins[c - denom]);
                }
            }
        }

        return coins[n] != 9999 ? coins[n] : -1;
    }

}
