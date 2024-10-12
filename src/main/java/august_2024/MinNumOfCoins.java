package august_2024;

import java.util.Arrays;

public class MinNumOfCoins {

    public static void main(String[] args) {
        int n = 7;
        int[] denoms = {1, 5, 10};

        int result = numOfCoins(n, denoms);
        System.out.println(result);
    }

    public static int numOfCoins(int n, int[] denoms) {

        int[] coins = new int[n + 1];
        Arrays.fill(coins, Integer.MAX_VALUE);
        coins[0] = 0;

        for (int d : denoms) {
            for (int i = 1; i <= n; i++) {
                if (i >= d) {
                    coins[i] = Math.min(coins[i], coins[i - d] + 1);
                }
            }
        }

        return coins[n] == Integer.MAX_VALUE - 1 ? -1 : coins[coins.length - 1];
    }

}
