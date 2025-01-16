package december_2024;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        int result = climbingStairs.climbStairs(5);
        System.out.println(result);
    }

    Map<Integer, Integer> cache = new HashMap<>();
    public int climbStairs(int n) {
        return helper(0, n);
    }

    private int helper(int level, int n) {
        if (cache.containsKey(level)) {
            return cache.get(level);
        }
        if (level > n) {
            return 0;
        }
        if (level == n) {
            return 1;
        }

        int steps = 0;

        for (int s = 1; s <= 2; s++) {
            steps += helper(level + s, n);
        }
        cache.put(level, steps);
        return steps;
    }


    public int climbStairs2(int n) {
        return helper2(0, n);
    }

    private int helper2(int level, int n) {
        if (level > n) {
            return 0;
        }
        if (level == n) {
            return 1;
        }
        int steps = 0;

        for (int s = 1; s <= 2; s++) {
            steps += helper2(level + s, n);
        }

        return steps;
    }

}
