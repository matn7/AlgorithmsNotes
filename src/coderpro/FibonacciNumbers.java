package coderpro;

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumbers {

    public static void main(String[] args) {
        FibonacciNumbers fibonacciNumbers = new FibonacciNumbers();
        int result = fibonacciNumbers.fibonacci(6);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int fib(int n) {
        int prevprev = 0;
        int prev = 1;
        if (n == 0) {
            return prevprev;
        }
        if (n == 1) {
            return prev;
        }
        int b = prev + prevprev;
        for (int i = 2; i <= n; i++) {
            b = prev + prevprev;
            prevprev = prev;
            prev = b;
        }
        return b;
    }

    // O(n) time | O(n) space
    public int fibonacci(int n) {
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0, 0);
        cache.put(1, 1);

        int i = fibHelper(n, cache);
        return i;
    }

    private int fibHelper(int n, Map<Integer, Integer> cache) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        cache.put(n, fibHelper(n - 1, cache) + fibHelper(n - 2, cache));
        return cache.get(n);
    }

}
