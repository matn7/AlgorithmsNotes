package january_2025;

import java.util.HashMap;
import java.util.Map;

public class BestTimeToBuyWithCooldown {

    // O(n) time | O(n) space
    public int maxProfit(int[] prices) {
        Map<String, Integer> dp = new HashMap<>();
        return dfs(0, true, dp, prices);
    }

    private int dfs(int i, boolean buying, Map<String, Integer> dp, int[] prices) {
        if (i >= prices.length) {
            return 0;
        }
        String key = i + ":" + buying;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        if (buying) {
            int buy = dfs(i + 1, !buying, dp, prices) - prices[i];
            int cooldown = dfs(i + 1, buying, dp, prices);
            dp.put(key, Math.max(buy, cooldown));
        } else {
            int sell = dfs(i + 2, !buying, dp, prices) + prices[i];
            int colldown = dfs(i + 1, buying, dp, prices);
            dp.put(key, Math.max(sell, colldown));
        }
        return dp.get(key);
    }

}
