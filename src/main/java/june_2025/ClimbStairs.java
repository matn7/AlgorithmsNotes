package june_2025;

import net.bytebuddy.description.field.FieldDescription;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        int result = climbStairs.climbStairs(2);
        System.out.println(result);
    }

    public int climbStairs(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        int prev = 1;
        int prevprev = 1;
        int res = prevprev + prev;
        for (int i = 2; i < n; i++) {
            prevprev = prev;
            prev = res;
            res = prevprev + prev;
        }
        return res;
    }


    public int climbStairs2(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return dfs(n, 0, memo);
    }

    private int dfs(int n, int pos, Map<Integer, Integer> memo) {
        if (memo.containsKey(pos)) {
            return memo.get(pos);
        }
        if (pos > n) {
            return 0;
        }
        if (pos == n) {
            return 1;
        }
        memo.put(pos, dfs(n, pos + 1, memo) + dfs(n, pos + 2, memo));
        return memo.get(pos);
    }

}
