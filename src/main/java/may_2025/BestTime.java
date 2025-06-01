package may_2025;

import java.util.HashMap;
import java.util.Map;

public class BestTime {

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        BestTime bestTime = new BestTime();
        int result = bestTime.maxProfit(prices);
        System.out.println(result);
    }

    public int maxProfit(int[] prices) {
        Map<String, Integer> cache = new HashMap<>();
        return backtrack(0, prices, true, cache);
    }

    private int backtrack(int i, int[] prices, boolean buying, Map<String, Integer> cache) {
        if (i >= prices.length) {
            return 0;
        }
        String key = i + ":" + buying;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        if (buying) {
            int buy = backtrack(i + 1, prices, !buying, cache) - prices[i];
            int cooldown = backtrack(i + 1, prices, buying, cache);
            cache.put(key, Math.max(buy, cooldown));
        } else {
            int sell = backtrack(i + 2, prices, !buying, cache) + prices[i];
            int cooldown = backtrack(i + 1, prices, buying, cache);
            cache.put(key, Math.max(sell, cooldown));
        }
        return cache.get(key);
    }

}
