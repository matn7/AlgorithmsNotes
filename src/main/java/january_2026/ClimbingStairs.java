package january_2026;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    public static void main(String[] args) {
        int n = 5;
        ClimbingStairs climbingStairs = new ClimbingStairs();
        int result = climbingStairs.climbStairs(n);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int climbStairs(int n) {
        int prevprev = 1;
        int prev = 1;
        if (n == 0) {
            return prevprev;
        }
        if (n == 1) {
            return prev;
        }
        int sum = prev + prevprev;
        for (int i = 3; i <= n; i++) {
            prevprev = prev;
            prev = sum;
            sum = prev + prevprev;
        }
        return sum;
    }

    // O(2^n) time | O(2^n) space
    // O(n) time | O(n) space
    public int climbStairs2(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0, 1);
        memo.put(1, 1);
        return dfs(n, memo);
    }

    private int dfs(int n, Map<Integer, Integer> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        memo.put(n, dfs(n - 1, memo) + dfs(n - 2, memo));
        return memo.get(n);
    }

}
