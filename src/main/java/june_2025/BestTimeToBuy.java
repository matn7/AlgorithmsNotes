package june_2025;

public class BestTimeToBuy {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};

        BestTimeToBuy bestTimeToBuy = new BestTimeToBuy();
        int result = bestTimeToBuy.maxProfit(prices);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int sell = prices[i];
            int profit = sell - buy;
            maxProfit = Math.max(maxProfit, profit);
            buy = Math.min(buy, prices[i]);
        }

        return maxProfit;
    }

}
