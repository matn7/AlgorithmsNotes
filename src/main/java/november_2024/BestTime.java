package november_2024;

import java.util.HashMap;
import java.util.Map;

public class BestTime {

    public int maxProfit(int[] prices) {
        Map<String, Integer> dp = new HashMap<>();
        return dfs(0, true, prices, dp);
    }

    private int dfs(int i, boolean buying, int[] prices, Map<String, Integer> dp) {
        if (i >= prices.length) {
            return 0;
        }
        String key = getKey(i, buying);
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

    private String getKey(int i, boolean buying) {
        return i + ":" + buying;
    }

}
