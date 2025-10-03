package september_2025;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};

        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        int result = bestTimeToBuyAndSellStock.maxProfit(prices);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int sell = prices[i];
            int curProfit = sell - buy;
            profit = Math.max(profit, curProfit);
            buy = Math.min(buy, sell);
        }
        return profit;
    }


}
