package october_2023;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] prices = {9, 11, 8, 5, 7, 10};

        int maxProfit = maxProfit2(prices);
        System.out.println(maxProfit);
    }

    // O(n^2) time | O(1) space
    public static int maxProfit2(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            int buyPrice = prices[i];
            for (int j = i; j < prices.length; j++) {
                int sellPrice = prices[j];
                int currProfit = sellPrice - buyPrice;
                maxProfit = Math.max(maxProfit, currProfit);
            }
        }
        return maxProfit;
    }

    // O(n) time | O(1) space
    public static int maxProfit(int[] prices) {

        int maxCurrPrice = 0;
        int maxProfit = 0;

        for (int i = prices.length - 1; i >= 0; i--) {
            int price = prices[i];
            maxCurrPrice = Math.max(maxCurrPrice, price);
            maxProfit = Math.max(maxProfit, maxCurrPrice - price);
        }

        return maxProfit;

    }

}
