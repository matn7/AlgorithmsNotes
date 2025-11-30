package november_2025;

import java.util.HashMap;
import java.util.Map;

public class OnesAndZeroes2 {


    // O(n * m * i) time | O(n * m * i) space
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
        String str = strs[i];
        for (int j = 0; j < str.length(); j++) {
            if (str.charAt(j) == '0') {
                zeroes++;
            } else {
                ones++;
            }
        }
        memo.put(key, dfs(strs, i + 1, m, n, memo));
        if (zeroes <= m && ones <= n) {
            memo.put(key, Math.max(memo.get(key), 1 + dfs(strs, i + 1, m - zeroes, n - ones, memo)));
        }
        return memo.get(key);
    }


}
