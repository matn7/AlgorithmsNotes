package june_2025;

import java.util.HashMap;
import java.util.Map;

public class BestTimeBuySell {

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};

        BestTimeBuySell bestTimeBuySell = new BestTimeBuySell();
        int result = bestTimeBuySell.maxProfit(prices);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int maxProfit(int[] prices) {
        Map<String, Integer> dp = new HashMap<>();
        return helper(prices, 0, true, dp);
    }

    private int helper(int[] prices, int i, boolean buying, Map<String, Integer> dp) {
        if (i >= prices.length) {
            return 0;
        }
        String key = i + ":" + buying;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        if (buying) {
            int buy = helper(prices, i + 1, !buying, dp) - prices[i];
            int cooldown = helper(prices, i + 1, buying, dp);
            dp.put(key, Math.max(buy, cooldown));
        } else {
            int sell = helper(prices, i + 2, !buying, dp) + prices[i];
            int cooldown = helper(prices, i + 1, buying, dp);
            dp.put(key, Math.max(sell, cooldown));
        }
        return dp.get(key);
    }

}
