package udemy.faang.datastructuresalgorithms;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    public static void main(String[] args) {

        Fibonacci fibonacci = new Fibonacci();
        int result = fibonacci.fibonacciRecursive(6);
        int resItera = fibonacci.fibonacciIterative(6);
        System.out.println();

    }

    // O(n) time | O(1) space
    public int fibonacciIterative(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0;
        int b = 1;
        int fib = a + b;
        for (int i = 2; i <= n; i++) {
            a = b;
            b = fib;
            fib = a + b;
        }
        return b;
    }

    // O(n) time | O(n) space
    public int fibonacciRecursive(int n) {
        Map<Integer, Integer> memoize = new HashMap<>();
        memoize.put(0, 0);
        memoize.put(1, 1);
        return fibonacciRecursiveHelper(n, memoize);
    }

    private int fibonacciRecursiveHelper(int n, Map<Integer, Integer> memoize) {
        if (memoize.containsKey(n)) {
            return memoize.get(n);
        }
        int currFibo = fibonacciRecursiveHelper(n - 1, memoize) + fibonacciRecursiveHelper(n - 2, memoize);
        memoize.put(n, currFibo);
        return memoize.get(n);

    }

}
