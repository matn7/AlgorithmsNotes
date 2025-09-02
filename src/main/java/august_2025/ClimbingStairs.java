package august_2025;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    // O(n) time | O(1) space
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        int prevprev = 1;
        int prev = 1;
        int result = prev + prevprev;
        for (int i = 3; i <= n; i++) {
            prevprev = prev;
            prev = result;
            result = prev + prevprev;
        }
        return result;
    }

    // O(n) time | O(n) sspace
    public int climbStairs2(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0, 1);

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
