package december_2025;

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
        if (n <= 1) {
            return 1;
        }
        int prev = 1;
        int prevprev = 1;
        int res = prev + prevprev;

        for (int i = 3; i <= n; i++) {
            prevprev = prev;
            prev = res;
            res = prevprev + prev;
        }

        return res;
    }

    // O(2^n) time | O(n) space
    // O(n) time | O(n) space
    public int climbStairs2(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0, 1);
        memo.put(1, 1);

        return helper(n, memo);
    }

    private int helper(int n, Map<Integer, Integer> memo) {
        if (n < 0) {
            return 0;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        memo.put(n, helper(n - 1, memo) + helper(n - 2, memo));
        return memo.get(n);
    }

}
