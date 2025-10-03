package september_2025;

import java.util.HashMap;
import java.util.Map;

public class StoneGameII {

    // O(n^3) time | O(n^2) space
    public int stoneGameII(int[] piles) {
        Map<String, Integer> dp = new HashMap<>();

        return dfs(true, 0, 1, piles, dp);
    }

    private int dfs(boolean alice, int i, int M, int[] piles, Map<String, Integer> dp) {
        if (i == piles.length) {
            return 0;
        }
        String key = alice + ":" + i + ":" + M;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        int res = alice ? 0 : Integer.MAX_VALUE;
        int total = 0;
        for (int X = 1; X < 2 * M + 1; X++) {
            if (i + X > piles.length) {
                break;
            }
            total += piles[i + X - 1];
            if (alice) {
                res = Math.max(res, total + dfs(!alice, i + X, Math.max(M, X), piles, dp));
            } else {
                res = Math.min(res, dfs(!alice, i + X, Math.max(M, X), piles, dp));
            }
        }
        dp.put(key, res);
        return res;
    }

}
