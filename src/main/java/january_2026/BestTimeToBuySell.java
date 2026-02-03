package january_2026;

public class BestTimeToBuySell {

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};

        BestTimeToBuySell bestTimeToBuySell = new BestTimeToBuySell();
        int result = bestTimeToBuySell.maxProfit(prices);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = prices[0];
        int sell;

        for (int i = 1; i < prices.length; i++) {
            buy = Math.min(buy, prices[i - 1]);
            sell = prices[i];

            maxProfit = Math.max(maxProfit, sell - buy);
        }
        return maxProfit;
    }

}
