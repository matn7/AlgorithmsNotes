package june_2025;

import java.util.HashMap;
import java.util.Map;

public class BestTimeBuySell2 {

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};

        BestTimeBuySell2 bestTimeBuySell2 = new BestTimeBuySell2();
        int result = bestTimeBuySell2.maxProfit(prices);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int maxProfit(int[] prices) {
        Map<String, Integer> dp = new HashMap<>();
        return helper(prices, 0, true, dp);
    }

    private int helper(int[] prices, int idx, boolean buying, Map<String, Integer> dp) {
        if (idx >= prices.length) {
            return 0;
        }
        String key = idx + ":" + buying;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        if (buying) {
            int buy = helper(prices, idx + 1, !buying, dp) - prices[idx];
            int cooldown = helper(prices, idx + 1, buying, dp);
            dp.put(key, Math.max(buy, cooldown));
        } else {
            int sell = helper(prices, idx + 2, !buying, dp) + prices[idx];
            int cooldown = helper(prices, idx + 1, buying, dp);
            dp.put(key, Math.max(sell, cooldown));
        }
        return dp.get(key);
    }


}
