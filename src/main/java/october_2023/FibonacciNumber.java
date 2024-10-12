package october_2023;

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumber {

    public static void main(String[] args) {
        int n = 6;

        int result = fibonacciIterative(n);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public static int fibonacciIterative(int n) {
        int prevprev = 0;
        int prev = 1;
        if (n == 0) {
            return prevprev;
        }
        if (n == 1) {
            return prev;
        }
        int curr = 0;
        for (int i = 2; i <= n; i++) {
            curr = prev + prevprev;
            prevprev = prev;
            prev = curr;
        }

        return curr;
    }

    // O(n) time | O(n) space
    public static int fibonacciMemo(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0, 0);
        memo.put(1, 1);
        return fibonacciHelper(n, memo);
    }

    private static int fibonacciHelper(int n, Map<Integer, Integer> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        memo.put(n, fibonacciHelper(n - 1, memo) + fibonacciHelper(n - 2, memo));
        return memo.get(n);
    }

    // O(2^n) time | O(2^n) space
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

}
