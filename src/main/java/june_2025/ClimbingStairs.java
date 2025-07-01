package june_2025;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    public static void main(String[] args) {
        int n = 5;

        ClimbingStairs climbingStairs = new ClimbingStairs();
        int result = climbingStairs.climbStairs(n);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int climbStairs(int n) {
        int prev = 1;
        int prevprev = 1;
        if (n == 0) {
            return prevprev;
        }
        if (n == 1){
            return prev;
        }
        int res = prev + prevprev;
        for (int i = 3; i <= n; i++) {
            prevprev = prev;
            prev = res;
            res = prev + prevprev;
        }
        return res;
    }

    // O(n) time | O(n) space
    public int climbStairs2(int n) {
        int[] cache = new int[n];
        Arrays.fill(cache, -1);
        return dfs(n, 0, cache);
    }

    private int dfs(int n, int i, int[] cache) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (cache[i] != -1) {
            return cache[i];
        }
        cache[i] = dfs(n, i + 1, cache) + dfs(n, i + 2, cache);
        return cache[i];
    }

}
