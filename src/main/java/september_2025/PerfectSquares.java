package september_2025;

import java.util.HashMap;
import java.util.Map;

public class PerfectSquares {

    // O(n * sqrt(n)) time | O(n) space
    Map<Integer, Integer> dp;
    public int numSquares(int n) {
        dp = new HashMap<>();

        return dfs(n);
    }

    private int dfs(int target) {
        if (target == 0) {
            return 0;
        }
        if (dp.containsKey(target)) {
            return dp.get(target);
        }
        int res = target;
        for (int i = 1; i * i <= target; i++) {
            res = Math.min(res, 1 + dfs(target - i * i));
        }
        dp.put(target, res);
        return res;
    }

}
