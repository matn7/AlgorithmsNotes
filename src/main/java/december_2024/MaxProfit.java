package december_2024;

import java.util.HashMap;
import java.util.Map;

public class MaxProfit {

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
    }

    public int maxProfit(int[] prices) {
        // State: Buying or Selling?
        // If Buy -> i + 1
        // If Sell -> i + 2

        Map<String, Integer> dp = new HashMap<>();
        return dfs(0, true, prices, dp);
    }

    private int dfs(int i, boolean buying, int[] prices, Map<String, Integer> dp) {
        if (i >= prices.length) {
            return 0;
        }
        String key = i + "-" + buying;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        int cooldown = dfs(i + 1, buying, prices, dp);
        if (buying) {
            int buy = dfs(i + 1, false, prices, dp) - prices[i];
            dp.put(key, Math.max(buy, cooldown));
        } else {
            int sell = dfs(i + 2, true, prices, dp) + prices[i];
            dp.put(key, Math.max(sell, cooldown));
        }
        return dp.get(key);
    }

}
