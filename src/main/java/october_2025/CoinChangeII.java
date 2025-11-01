package october_2025;

import java.util.*;

public class CoinChangeII {

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};

        CoinChangeII coinChangeII = new CoinChangeII();
        int result = coinChangeII.change(amount, coins);
        System.out.println(result);
    }

    // O(n * m) time | O(n * m) space
    // n - amount
    // m - number of coins
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
//        Map<String, Integer> memo = new HashMap<>();
        int[][] memo = new int[coins.length + 1][amount + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return backtrack(coins, 0, 0, amount, memo);
    }

    private int backtrack(int[] coins, int i, int sum, int amount, int[][] memo) {
        if (sum == amount) {
            return 1;
        }
        if (sum > amount || i >= coins.length) {
            return 0;
        }
        if (memo[i][sum] != -1) {
            return memo[i][sum];
        }

        int count = 0;
        if (amount >= coins[i]) {
            count += backtrack(coins, i, sum + coins[i], amount, memo);
            count += backtrack(coins, i + 1, sum, amount, memo);
        }
        memo[i][sum] = count;
        return count;
    }

    //
    public int change2(int amount, int[] coins) {
        Arrays.sort(coins);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> oneRes = new ArrayList<>();

        backtrack2(coins, 0, 0, amount, oneRes, result);

        return result.size();
    }

    private void backtrack2(int[] coins, int i, int sum, int amount, List<Integer> oneRes, List<List<Integer>> result) {
        if (sum == amount) {
            result.add(new ArrayList<>(oneRes));
            return;
        }
        if (sum > amount) {
            return;
        }
        if (i >= coins.length) {
            return;
        }
        oneRes.add(coins[i]); // include
        backtrack2(coins, i, sum + coins[i], amount, oneRes, result);
        oneRes.remove(oneRes.size() - 1); // not include
        backtrack2(coins, i + 1, sum, amount, oneRes, result);
    }


}
