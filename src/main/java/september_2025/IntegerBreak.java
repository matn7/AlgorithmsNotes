package september_2025;

import java.util.HashMap;
import java.util.Map;

public class IntegerBreak {

    // O(n^2) time | O(n) space
    Map<Integer, Integer> dp;

    public int integerBreak(int n) {
        dp = new HashMap<>();
        dp.put(1, 1);
        return dfs(n, n);
    }

    private int dfs(int num, int n) {
        if (dp.containsKey(num)) {
            return dp.get(num);
        }
        int res = (num == n) ? 0 : num;

        for (int i = 1; i < num; i++) {
            int val = dfs(i, n) * dfs(num - i, n);
            res = Math.max(res, val);
        }
        dp.put(num, res);
        return res;
    }

}
