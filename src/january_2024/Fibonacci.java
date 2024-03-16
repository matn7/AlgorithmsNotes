package january_2024;

import december_2023.CollidingAsteroids;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fibonacci {

    public static void main(String[] args) {

        System.out.println(fib(7));
        System.out.println(fib2(7));
        System.out.println(fibIter(7));
    }


    // O(2^n) time | O(2^n) space
    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    // O(n) time | O(n) space
    public static int fib2(int n) {
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0, 0);
        cache.put(1, 1);
        return fibMemo(n, cache);
    }

    public static int fibMemo(int n, Map<Integer, Integer> cache) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        cache.put(n, fibMemo(n - 1, cache) + fibMemo(n - 2, cache));
        return cache.get(n);
    }

    // O(n) time | O(1) space
    public static int fibIter(int n) {
        int prevprev = 0;
        int prev = 1;
        if (n == 0) {
            return prevprev;
        }
        if (n == 1) {
            return prev;
        }
        int b = prevprev + prev;
        for (int i = 2; i <= n; i++) {
            b = prevprev + prev;
            prevprev = prev;
            prev = b;
        }
        return b;
    }

}
