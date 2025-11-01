package october_2025;

import java.util.HashMap;
import java.util.Map;

public class BestTimeToBuyAndSellStockWithCooldown {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithCooldown maxProfit = new BestTimeToBuyAndSellStockWithCooldown();
        int[] prices = {1,2,3,0,2};
        int result = maxProfit.maxProfit(prices);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int maxProfit(int[] prices) {
//        int[][] memo = new int[2][prices.length];
        Map<String, Integer> memo = new HashMap<>();
        return dfs(prices, 0, true, memo);
    }

    private int dfs(int[] prices, int i, boolean buying, Map<String, Integer> memo) {
        if (i >= prices.length) {
            return 0;
        }
        String key = i + ":" + buying;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int profit = 0;
        if (buying) {
            int buy = dfs(prices, i + 1, !buying, memo) - prices[i];
            int cooldown = dfs(prices, i + 1, buying, memo);
            profit = Math.max(buy, cooldown);
        } else {
            int sell = dfs(prices, i + 2, !buying, memo) + prices[i];
            int cooldown = dfs(prices, i + 1, buying, memo);
            profit = Math.max(sell, cooldown);
        }
        memo.put(key, profit);
        return profit;
    }

}
