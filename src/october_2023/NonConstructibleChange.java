package october_2023;

import java.util.Arrays;

public class NonConstructibleChange {

    public static void main(String[] args) {
        int[] coins = {5, 7, 1, 1, 2, 3, 22};
        nonConstructibleChange(coins);
    }

    // O(nlog(n)) time | O(1) space
    public static int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);
        int sum = 0;
        // [1, 1, 2, 3, 5, 7, 22]
        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            if (coin > sum + 1) {
                return sum + 1;
            }
            sum += coin;
        }

        return sum + 1;
    }

}
