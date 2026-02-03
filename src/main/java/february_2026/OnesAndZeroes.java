package february_2026;

import java.util.HashMap;
import java.util.Map;

public class OnesAndZeroes {

    // O(i * m * n) time | O(i * m * n) space
    public int findMaxForm(String[] strs, int m, int n) {
        Map<String, Integer> memo = new HashMap<>();
        return dfs(strs, 0, m, n, memo);
    }

    private int dfs(String[] strs, int i, int m, int n, Map<String, Integer> memo) {
        if (i == strs.length) {
            return 0;
        }
        String key = i + ":" + m + ":" + n;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int ones = 0;
        int zeroes = 0;

        for (int j = 0; j < strs[i].length(); j++) {
            if (strs[i].charAt(j) == '0') {
                zeroes++;
            } else {
                ones++;
            }
        }

        memo.put(key, dfs(strs, i + 1, m, n, memo));

        if (m >= zeroes && n >= ones) {
            memo.put(key, Math.max(memo.get(key), 1 + dfs(strs, i + 1, m - zeroes, n - ones, memo)));
        }
        return memo.get(key);
    }

}
