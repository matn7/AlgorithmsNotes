package november_2025;

import java.util.*;

public class CoinChangeII {

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1,2,5};

        CoinChangeII coinChangeII = new CoinChangeII();
        int result = coinChangeII.change(amount, coins);
        System.out.println(result);
    }

    // O(n * a) time | O(n * a) space
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int[][] dp = new int[coins.length + 1][amount + 1];
        int n = coins.length;
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int a = 0; a <= amount; a++) {
                if (a >= coins[i]) {
                    dp[i][a] = dp[i + 1][a]; // skip
                    dp[i][a] += dp[i][a - coins[i]]; // include
                }
            }
        }

        return dp[0][amount];
    }

    private int backtrack(int[] coins, int i, int a, int[][] dp) {
        if (a == 0) {
            return 1;
        }
        if (i >= coins.length) {
            return 0;
        }
        if (dp[i][a] != -1) {
            return dp[i][a];
        }
        int res = 0;
        if (a >= coins[i]) {
            res += backtrack(coins, i,  a - coins[i], dp) + backtrack(coins, i + 1, a, dp);
        }
        dp[i][a] = res;
        return res;
    }


    // O(2^n) time | O(n) space
    // O(n*s) time | O(n*s) space
    public int change3(int amount, int[] coins) {
        Arrays.sort(coins);
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int r = 0; r < dp.length; r++) {
            for (int c = 0; c < dp[r].length; c++) {
                dp[r][c] = -1;
            }
        }
        return backtrack3(coins, 0, amount, dp);
    }

    private int backtrack3(int[] coins, int i, int a, int[][] dp) {
        if (a == 0) {
            return 1;
        }
        if (i >= coins.length) {
            return 0;
        }
        if (dp[i][a] != -1) {
            return dp[i][a];
        }
        int res = 0;
        if (a >= coins[i]) {
            res += backtrack3(coins, i,  a - coins[i], dp) + backtrack3(coins, i + 1, a, dp);
        }
        dp[i][a] = res;
        return res;
    }

    //
    public int change2(int amount, int[] coins) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> part = new ArrayList<>();
        Arrays.sort(coins);

        backtrack2(coins, 0, 0, amount, part, res);

        return res.size();
    }

    private void backtrack2(int[] coins, int i, int sum, int amount, List<Integer> part, List<List<Integer>> res) {
        if (sum == amount) {
            res.add(new ArrayList<>(part));
            return;
        }
        if (i >= coins.length || sum > amount) {
            return;
        }
        part.add(coins[i]); // include
        backtrack2(coins, i, sum + coins[i], amount, part, res);
        part.remove(part.size() - 1); // skip
        backtrack2(coins, i + 1, sum, amount, part, res);
    }

}
