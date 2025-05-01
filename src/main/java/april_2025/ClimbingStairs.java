package april_2025;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    public static void main(String[] args) {
        int n = 3;
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
        int result = prev + prevprev;
        for (int i = 2; i < n; i++) {
            prevprev = prev;
            prev = result;
            result = prevprev + prev;
        }
        return result;
    }


    // O(n) time | O(n) space
    public int climbStairs3(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0, 1);
        return dfs(n, memo);
    }

    private int dfs(int n, Map<Integer, Integer> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        if (n < 0) {
            return 0;
        }
        memo.put(n, dfs(n - 1, memo) + dfs(n - 2, memo));
        return memo.get(n);
    }

    // O(2^n) time | O(n) space
    public int climbStairs2(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        return climbStairs2(n - 1) + climbStairs2(n - 2);
    }

}
