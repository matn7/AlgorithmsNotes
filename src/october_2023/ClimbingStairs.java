package october_2023;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    public static void main(String[] args) {
        int n = 5;
        int result = climbingStairs(n);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public static int climbingStairs(int n) {
        int prevprev = 1;
        int prev = 1;
        int curr = prev + prevprev;
        for (int i = 2; i <= n; i++) {
            curr = prev + prevprev;
            prevprev = prev;
            prev = curr;
        }
        return curr;
    }

    // O(n) time | O(n) space
    public static int climbingStairs2(int n) {
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0, 1);
        cache.put(1, 1);
        return climbingStairsHelper(n, cache);
    }

    private static int climbingStairsHelper(int n, Map<Integer, Integer> cache) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        cache.put(n, climbingStairsHelper(n - 1, cache) + climbingStairsHelper(n - 2, cache));
        return cache.get(n);
    }

    // O(2^n) time | O(2^n) space
    public static int climbingStairs3(int n) {
        if (n <= 1) {
            return 1;
        }
        return climbingStairs3(n - 1) + climbingStairs3(n - 2);
    }

}
