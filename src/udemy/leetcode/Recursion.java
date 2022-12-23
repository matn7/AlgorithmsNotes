package udemy.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Recursion {

    public static void main(String[] args) {
        Recursion recursion = new Recursion();
//        recursion.fun();

        // 1 2 3 4 5 6
        // 1 1 2 3 5 8

        System.out.println(recursion.fibonacci(6));
    }

    public void fun() {
        fun2(1);
    }

    public void fun2(int n) {
        if (n == 6) {
            return;
        }
        System.out.println(n);
        fun2(n + 1);
    }

    public int fibonacci(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(1, 1);
        memo.put(2, 1);
        return fib(n, memo);
    }

    private int fib(int number, Map<Integer, Integer> memo) {
        if (memo.containsKey(number)) {
            return memo.get(number);
        }
        memo.put(number, fib(number - 1, memo) + fib(number - 2, memo));
        return memo.get(number);

    }

}
