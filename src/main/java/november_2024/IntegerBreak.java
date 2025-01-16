package november_2024;

import java.util.HashMap;
import java.util.Map;

public class IntegerBreak {

    public int integerBreak(int n) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(1, 1);
        return dfs(n, n, dp);
    }

    private int dfs(int num, int n, Map<Integer, Integer> dp) {
        if (dp.containsKey(num)) {
            return dp.get(num);
        }
        dp.put(num, num == n ? 0 : num);
        for (int i = 1; i < num; i++) {
            int val = dfs(i, n, dp) * dfs(num - i, n, dp);
            dp.put(num, Math.max(dp.get(num), val));
        }
        return dp.get(num);
    }

}
