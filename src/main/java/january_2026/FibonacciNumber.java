package january_2026;

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumber {


    // O(n) time | O(1) space
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int prevprev = 1;
        if (n == 1) {
            return prevprev;
        }
        int prev = 1;
        if (n == 2) {
            return prev;
        }

        int sum = prev + prevprev;
        for (int i = 4; i <= n; i++) {
            prevprev = prev;
            prev = sum;
            sum = prevprev + prev;
        }

        return sum;
    }

    // O(n) time | O(n) space
    public int fib1(int n) {
        if (n == 0) {
            return 0;
        }
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(1, 1);
        memo.put(2, 1);

        return helper(n, memo);
    }

    private int helper(int n, Map<Integer, Integer> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        memo.put(n, helper(n - 1, memo) + helper(n - 2, memo));
        return memo.get(n);
    }

    // O(2^n) time | O(2^n) space
    public int fib2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        return fib2(n - 1) + fib2(n - 2);
    }


}
