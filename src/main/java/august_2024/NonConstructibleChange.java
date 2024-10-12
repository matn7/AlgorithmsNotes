package august_2024;

import java.util.Arrays;

public class NonConstructibleChange {

    public static void main(String[] args) {
        int[] coins = {5, 7, 1, 1, 2, 3, 22};

        int result = nonConstructibleChange(coins);
        System.out.println(result);
    }

    // O(nlog(n)) time | O(n) space
    public static int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);

        // [1, 1, 2, 3,  5,  7, 22]
        //     1  2  4   7  12  19
        int sum = 0;
        for (int coin : coins) {
            if (sum + 1 < coin) {
                return sum + 1;
            }
            sum = sum + coin;
        }
        return sum + 1;
    }

}
