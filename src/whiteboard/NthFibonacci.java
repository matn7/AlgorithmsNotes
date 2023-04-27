package whiteboard;

import java.util.HashMap;
import java.util.Map;

public class NthFibonacci {

    public static void main(String[] args) {
        int n = 6;
        int result = getNthFib(n);
        System.out.println();
    }

    // O(n) time | O(1) space
    public static int getNthFib(int n) {
        int a = 0;
        int b = 1;
        for (int i = 2; i < n; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }

        return n == 1 ? a : b;
    }

    // O(n) time | O(n) space
    public static int getNthFib2(int n) {
        // Write your code here.
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(1, 0);
        cache.put(2, 1);
        return fibHelper(n, cache);
    }

    private static int fibHelper(int n, Map<Integer, Integer> cache) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        cache.put(n, fibHelper(n - 1, cache) + fibHelper(n - 2, cache));
        return cache.get(n);
    }

    // O(2^n) time | O(n) space
    public static int getNthFib3(int n) {
        // Write your code here.
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        return getNthFib3(n - 1) + getNthFib3(n - 2);
    }

    // O(n) time | O(1) space
    public static int getNthFib4(int n) {
        if (n == 1) {
            return 0;
        }
        int prevprev = 0;
        int prev = 1;
        int b = prevprev + prev;
        for (int i = 2; i < n-1; i++) {
            prevprev = prev;
            prev = b;
            b = prevprev + prev;
        }
        return b;
    }
}
