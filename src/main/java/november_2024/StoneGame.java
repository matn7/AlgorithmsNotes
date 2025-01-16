package november_2024;

import java.util.HashMap;
import java.util.Map;

public class StoneGame {

    public boolean stoneGame(int[] piles) {
        Map<String, Integer> dp = new HashMap<>();
        int sum = 0;
        for (int p : piles) {
            sum += p;
        }
        return dfs(0, piles.length - 1, piles, dp) > (sum / 2);
    }

    // Max Alice Total
    private int dfs(int l, int r, int[] piles, Map<String, Integer> dp) {
        if (l > r) {
            return 0;
        }
        String key = getKey(l, r);
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        boolean even = (r - 1) % 2 == 0;
        int left = even ? piles[l] : 0;
        int right = even ? piles[r] : 0;

        dp.put(key, Math.max(dfs(l + 1, r, piles, dp) + left,
                dfs(l, r - 1, piles, dp) + right));
        return dp.get(key);
    }

    private String getKey(int l, int r) {
        return l + ":" + r;
    }

}
