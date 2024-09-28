package problems.easy;

import java.util.HashMap;
import java.util.Map;

public class NthFibonacci {

    public static void main(String[] args) {
        System.out.println(getNthFib(6));
    }

    // O(n) time | O(1) space
    public static int getNthFibOptimal(int n) {
        int a = 0;
        int b = 1;
        for (int i = 2; i < n; i++) {
            int next = a + b;
            a = b;
            b = next;
        }
        return n == 1 ? a : b;
    }

    // O(2^n) time | O(n) space
    public static int getNthFibNonOptimal(int n) {
        if (n == 2) {
            return 1;
        } else if (n == 1) {
            return 0;
        }
        return getNthFibNonOptimal(n - 1) + getNthFibNonOptimal(n - 2);
    }

    // OK - repeated 02/03/2022
    public static int getNthFib(int n) {
        Map<Integer, Integer> memoize = new HashMap<>();
        memoize.put(1, 0);
        memoize.put(2, 1);
        return getNthFib(n, memoize);
    }

    public static int getNthFib(int n, Map<Integer, Integer> memoize) {
        if (memoize.containsKey(n)) {
            return memoize.get(n);
        }
        int result = getNthFib(n - 1, memoize) + getNthFib(n - 2, memoize);
        memoize.put(n, result);
        return memoize.get(n);
    }
}
