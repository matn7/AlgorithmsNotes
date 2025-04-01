package february_2025;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    public static void main(String[] args) {

        ClimbingStairs climbingStairs = new ClimbingStairs();
        int result = climbingStairs.climbStairs(3);
        System.out.println(result);

    }

    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        int prevprev = 1;
        int prev = 1;
        int fib = prev + prevprev;

        for (int i = 3; i <= n; i++) {
            prevprev = prev;
            prev = fib;
            fib = prev + prevprev;
        }

        return fib;
    }

    public int climbStairs2(int n) {
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0, 1);
        cache.put(1, 1);
        return helper(n, cache);
    }

    private int helper(int n, Map<Integer, Integer> cache) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        cache.put(n, helper(n - 1, cache) + helper(n - 2, cache));
        return cache.get(n);
    }

}
