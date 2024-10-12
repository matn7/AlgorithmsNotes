package september_2023;

import java.util.HashMap;
import java.util.Map;

public class NthFibonacci {

    // [0, 1, 1, 2, 3, 5]
    //     pp p
    //        b

    public static void main(String[] args) {
        getNthFib(6);
    }

    // O(n) time | O(1) space
    public static int getNthFib(int n) {
        // Write your code here.
        int prevprev = 0;
        int prev = 1;
        if (n == 1) {
            return prevprev;
        }
        if (n == 2) {
            return prev;
        }
        int b = prev + prevprev;
        for (int i = 2; i < n; i++) {
            b = prev + prevprev;
            prevprev = prev;
            prev = b;
        }
        return b;
    }

    // O(n) time | O(n) space
    public static int getNthFib2(int n) {
        // Write your code here.
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(1, 0);
        cache.put(2, 1);
        return getNthFibHelper(n, cache);
    }

    private static int getNthFibHelper(int n, Map<Integer, Integer> cache) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        cache.put(n, getNthFibHelper(n - 1, cache) + getNthFibHelper(n - 2, cache));
        return cache.get(n);
    }


}
