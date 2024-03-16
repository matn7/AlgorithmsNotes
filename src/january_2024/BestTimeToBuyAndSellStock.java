package january_2024;

import october_2023.LeastCommonManager;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] prices = {9, 11, 8, 5, 7, 10};

        int result = maxProfit(prices);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public static int maxProfit(int[] prices) {
        int sellValue = prices[prices.length - 1];
        int maxProfit = Integer.MIN_VALUE;

        for (int i = prices.length - 2; i >= 0; i--) {
            int buyValue = prices[i];
            int earnings = sellValue - buyValue;
            if (earnings > maxProfit) {
                maxProfit = earnings;
            }
            sellValue = Math.max(sellValue, buyValue);
        }
        return maxProfit;
    }

}
