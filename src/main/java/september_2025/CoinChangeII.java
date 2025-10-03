package september_2025;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChangeII {

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};

        CoinChangeII coinChangeII = new CoinChangeII();
        int result = coinChangeII.change(amount, coins);
        System.out.println(result);

    }

    // O(n * a) time | O(n * a) space
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
//        Map<String, Integer> memo = new HashMap<>();
        int[][] memo = new int[coins.length + 1][amount + 1];
        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                memo[i][j] = -1;
            }
        }
        return dfs(amount, 0, coins, memo);

    }

    private int dfs(int amount, int i, int[] coins, int[][] memo) {
        if (amount == 0) {
            return 1;
        }
        if (i >= coins.length) {
            return 0;
        }
        if (memo[i][amount] != -1) {
            return memo[i][amount];
        }

        int count = 0;
        if (amount >= coins[i]) {
            count = dfs(amount, i + 1, coins, memo); // avoid duplicates
            count += dfs(amount - coins[i], i, coins, memo);
        }
        memo[i][amount] = count;
        return count;
    }


}
