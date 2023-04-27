package coderpro;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    public static void main(String[] args) {

        ClimbingStairs climbingStairs = new ClimbingStairs();
        int result = climbingStairs.staircase2(5);
        System.out.println(result);

    }

    // O(n) time | O(1) space
    // fibonacci
    public int staircase2(int n) {
        int prev = 1;
        int prevprev = 1;
        int curr = 0;
        for (int i = 2; i < n + 1; i++) {
            curr = prev + prevprev;

            prevprev = prev;
            prev = curr;
        }
        return curr;
    }

    // O(2^n) time | O(2^n) space (without cache)
    // O(n) time | O(n) space (with cache)
    public int staircase(int n) {
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0, 1);
        cache.put(1, 1);
        return staircaseHelper(n, cache);
    }

    public int staircaseHelper(int n, Map<Integer, Integer> cache) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        cache.put(n, staircaseHelper(n - 1, cache) + staircaseHelper(n - 2, cache));
        return cache.get(n);
    }

}
