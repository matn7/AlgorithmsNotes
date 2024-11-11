package october_2024;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        int res = climbingStairs.climbStairs(5);
        System.out.println(res);

        System.out.println(climbingStairs.climbStairs2(5));
    }

    // O(n) time | O(1) space
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        int prevprev = 1; // 0
        int prev = 1; // 1

        int b = prev + prevprev;
        for (int i = 2; i <= n; i++) {
            b = prev + prevprev;
            prevprev = prev;
            prev = b;
        }
        return b;
    }



    public int climbStairs2(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0, 1);
        memo.put(1, 1);
        return helper(n, memo);
    }

    private int helper(int n, Map<Integer, Integer> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        memo.put(n, helper(n - 1, memo) + helper(n - 2, memo));
        return memo.get(n);
    }


}
