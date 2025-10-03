package september_2025;

import november_2024.InterchangeableRectangles;

import java.util.HashMap;
import java.util.Map;

public class BestTimeToBuySell {

    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};

        BestTimeToBuySell bestTimeToBuySell = new BestTimeToBuySell();
        int result = bestTimeToBuySell.maxProfit(prices);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int maxProfit(int[] prices) {
//        Map<String, Integer> memo = new HashMap<>();
        int[][] memo = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            memo[i][0] = -1;
            memo[i][1] = -1;
        }
        return dfs(prices, 0, true, memo);
    }

    private int dfs(int[] prices, int i, boolean buying, int[][] memo) {
        if (i >= prices.length) {
            return 0;
        }
        int x = buying ? 1 : 0;
        if (memo[i][x] != -1) {
            return memo[i][x];
        }

        int sum;
        if (buying) {
            int buy = dfs(prices, i + 1, !buying, memo) - prices[i];
            int cooldown = dfs(prices, i + 1, buying, memo);
            sum = Math.max(buy, cooldown);
        } else {
            int sell = dfs(prices, i + 2, !buying, memo) + prices[i];
            int cooldown = dfs(prices, i + 1, buying, memo);
            sum = Math.max(sell, cooldown);
        }
        memo[i][x] = sum;
        return sum;
    }

}
