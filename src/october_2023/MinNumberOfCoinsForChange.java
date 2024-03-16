package october_2023;

import java.util.Arrays;

public class MinNumberOfCoinsForChange {

    public static void main(String[] args) {
        int n = 7;
        int[] denoms = {1, 5, 10};

        minNumber(denoms, n);
    }

    public static int minNumber(int[] denoms, int n) {

        //
        // 0 1 2 3 4 5 6 7

        int[] coins = new int[n + 1];
        Arrays.fill(coins, Integer.MAX_VALUE - 1);
        coins[0] = 0;
        for (int d : denoms) {
            for (int i = 1; i <= n; i++) {
                if (i >= d) {
                    coins[i] = Math.min(coins[i], coins[i - d] + 1);
                }
            }
        }
        return coins[n] == Integer.MAX_VALUE - 1? -1 : coins[n];
    }

}
