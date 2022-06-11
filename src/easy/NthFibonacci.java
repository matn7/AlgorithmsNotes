package easy;

import java.util.HashMap;
import java.util.Map;

public class NthFibonacci {

    public static void main(String[] args) {
        System.out.println(getNthFib(6));
    }

//    // O(n) time | O(1) space
//    // rec(6)
//    public static int getNthFib(int n) {
//        int a = 0;
//        int b = 1;
//        for (int i = 2; i < n; i++) { // 5
//            int next = a + b; // 5
//            a = b; // 3
//            b = next; // 5
//        }
//        return n == 1 ? a : b;
//    }

//    // O(2^n) time | O(n) space
//    public static int getNthFib(int n) {
//        if (n == 2) {
//            return 1;
//        } else if (n == 1) {
//            return 0;
//        }
//        return getNthFib(n - 1) + getNthFib(n - 2);
//    }

    // OK - repeated 02/03/2022
    // rec(6)
    // O(n) time | O(n) space
    public static int getNthFib(int n) {
        Map<Integer, Integer> memoize = new HashMap<>();
        memoize.put(1, 0);
        memoize.put(2, 1);
        // memoize = {1: 0, 2: 1}
        // rec(6, {1: 0, 2: 1})
        return getNthFib(n, memoize);
    }

    // rec(2, {1: 0, 2: 1}) => 1    rec(1, {1: 0, 2: 1}) => 1
    // rec(3, {1: 0, 2: 1}) => 2
    // rec(4, {1: 0, 2: 1}) => 3
    // rec(5, {1: 0, 2: 1}) => 5
    // rec(6, {1: 0, 2: 1})
    public static int getNthFib(int n, Map<Integer, Integer> memoize) {
        if (memoize.containsKey(n)) {
            return memoize.get(n);
        }
        int result = getNthFib(n - 1, memoize) + getNthFib(n - 2, memoize);
        memoize.put(n, result);
        return memoize.get(n);
    }
}
