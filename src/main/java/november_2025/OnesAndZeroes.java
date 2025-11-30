package november_2025;

import java.util.HashMap;
import java.util.Map;

public class OnesAndZeroes {

    // O(n * m * i) time | O(n * m * i) space
    public int findMaxForm(String[] strs, int m, int n) {
        Map<String, Integer> dp = new HashMap<>();

        return dfs(strs, 0, m, n, dp);
    }

    private int dfs(String[] strs, int i, int m, int n, Map<String, Integer> dp) {
        if (i == strs.length) {
            return 0;
        }
        String key = i + ":" + m + ":" + n;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        int zeroes = 0;
        int ones = 0;
        for (int j = 0; j < strs[i].length(); j++) {
            if (strs[i].charAt(j) == '0') {
                zeroes++;
            } else {
                ones++;
            }
        }
        dp.put(key, dfs(strs, i + 1, m, n, dp));
        if (zeroes <= m && ones <= n) {
            dp.put(key, Math.max(dp.get(key), 1 + dfs(strs, i + 1, m - zeroes, n - ones, dp)));
        }
        return dp.get(key);
    }

}
