package april_2025;

import java.util.HashMap;
import java.util.Map;

public class BestTimeToBuyAndSell {

    // O(n) time | O(n) space
    public int maxProfit(int[] prices) {
        // State: Buying or Selling?
        // If Buy -> i + 1
        // If Sell -> i + 2
        Map<String, Integer> dp = new HashMap<>(); // key = (i, buying), val = max_profit
        return dfs(0, true, prices, dp);
    }

    private int dfs(int i, boolean buying, int[] prices, Map<String, Integer> dp) {
        if (i >= prices.length) {
            return 0;
        }
        String key = i + ":" + buying;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        if (buying) {
            int buy = dfs(i + 1, !buying, prices, dp) - prices[i];
            int cooldown = dfs(i + 1, buying, prices, dp);
            dp.put(key, Math.max(buy, cooldown));
        } else {
            int sell = dfs(i + 2, !buying, prices, dp) + prices[i];
            int cooldown = dfs(i + 1, buying, prices, dp);
            dp.put(key, Math.max(sell, cooldown));
        }
        return dp.get(key);
    }

}
