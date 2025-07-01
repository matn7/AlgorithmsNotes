package june_2025;

import java.util.HashMap;
import java.util.Map;

public class MaxProfit {

    public static void main(String[] args) {
//        int[] prices = {1,2,3,0,2};
        int[] prices = {1};

        MaxProfit maxProfit = new MaxProfit();
        int result = maxProfit.maxProfit(prices);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    Map<String, Integer> memo;

    public int maxProfit(int[] prices) {
        memo = new HashMap<>();
        return dfs(prices, 0, true);
    }

    private int dfs(int[] prices, int i, boolean buying) {
        if (i >= prices.length) {
            return 0;
        }
        String key = i + ":" + buying;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (buying) {
            int buy = dfs(prices, i + 1, !buying) - prices[i];
            int cooldown = dfs(prices, i + 1, buying);
            memo.put(key, Math.max(buy, cooldown));
        } else {
            int sell = dfs(prices, i + 2, !buying) + prices[i];
            int cooldown = dfs(prices, i + 1, buying);
            memo.put(key, Math.max(sell, cooldown));
        }
        return memo.get(key);
    }

}
