package april_2025;

import java.util.HashMap;
import java.util.Map;

public class OnesAndZeroes {

    // O(N*m*n) time | O(N*m*n) space
    public int findMaxForm(String[] strs, int m, int n) {
        Map<String, Integer> dp = new HashMap<>();
        return dfs(0, m, n, strs, dp);
    }

    private int dfs(int i, int m, int n, String[] strs, Map<String, Integer> dp) {
        if (i == strs.length) {
            return 0;
        }
        String key = i + ":" + m + ":" + n;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        int mCnt = 0;
        int nCnt = 0;
        String str = strs[i];
        for (char c : str.toCharArray()) {
            if (c == '0') {
                mCnt++;
            }
            if (c == '1') {
                nCnt++;
            }
        }
        dp.put(key, dfs(i + 1, m, n, strs, dp));
        if (mCnt <= m && nCnt <= n) {
            dp.put(key, Math.max(dp.get(key), 1 + dfs(i + 1, m - mCnt, n - nCnt, strs, dp)));
        }
        return dp.get(key);
    }

}
