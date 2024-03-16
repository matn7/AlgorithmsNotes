package january_2024;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    public static void main(String[] args) {

        int staircase = staircase(5);
        System.out.println(staircase);

        System.out.println(staircase2(5));

        System.out.println(staircase3(5));

    }

    // O(2^n) time | O(n) space
    public static int staircase(int n) {
        if (n <= 1) {
            return 1;
        }
        return staircase(n - 1) + staircase(n - 2);
    }

    // O(n) time | O(n) space
    public static int staircase2(int n) {
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0, 1);
        cache.put(1, 1);
        return staircaseHelper(n, cache);
    }

    private static int staircaseHelper(int n, Map<Integer, Integer> cache) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        cache.put(n, staircaseHelper(n - 1, cache) + staircaseHelper(n - 2, cache));
        return cache.get(n);
    }

    // O(n) time | O(1) space
    public static int staircase3(int n) {
        int prevprev = 1;
        int prev = 1;
        if (n == 0) {
            return prevprev;
        }
        if (n == 1) {
            return prev;
        }
        int b = 0;
        for (int i = 2; i <= n; i++) {
            b = prevprev + prev;
            prevprev = prev;
            prev = b;
        }
        return b;
    }

}
