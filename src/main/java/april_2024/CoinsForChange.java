package april_2024;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinsForChange {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;

        int result = coinsForChangeRec(coins, amount);
        System.out.println(result);

        int result2 = coinsForChangeRec2(coins, amount);
        System.out.println(result2);

        int result3 = coinChange(coins, amount);
        System.out.println(result3);
    }

    // O(s*n) time (s amount, n no of coins) | O(s) space
    public static int coinsForChangeRec2(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        Map<Integer, Integer> memo = new HashMap<>();
        return solution2(coins, amount, memo);
    }

    private static int solution2(int[] coins, int remaining, Map<Integer, Integer> memo) {
        if (remaining < 0) {
            return -1;
        }
        if (remaining == 0) {
            return 0;
        }
        if (memo.containsKey(remaining)) {
            return memo.get(remaining);
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int result = solution2(coins, remaining - coin, memo);
            if (result >= 0 && result < min) {
                min = 1 + result;
            }
        }
        if (min != Integer.MAX_VALUE) {
            memo.put(remaining, min);
            return min;
        }
        memo.put(remaining, -1);
        return memo.get(remaining);
    }

    // O(s^n) time (s amount, n no of coins) | O(s^n) space
    public static int coinsForChangeRec(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return solution(coins, amount);
    }

    private static int solution(int[] coins, int remaining) {
        if (remaining < 0) {
            return -1;
        }
        if (remaining == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int result = solution(coins, remaining - coin);
            if (result >= 0 && result < min) {
                min = 1 + result;
            }
        }
        if (min != Integer.MAX_VALUE) {
            return min;
        }
        return -1;
    }

    // O(s*n) time (s amount, n num of coins) | O(s) space (s amount)
    public static int coinChange(int[] coins, int amount) {
        if (amount <= 0) {
            return 0;
        }

        int[] change = new int[amount + 1];
        Arrays.fill(change, Integer.MAX_VALUE);

        change[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin && change[i - coin] != Integer.MAX_VALUE) {
                    change[i] = Math.min(change[i], change[i - coin] + 1);
                }
            }
        }

        return change[amount] == Integer.MAX_VALUE ? -1 : change[amount];
    }

}
