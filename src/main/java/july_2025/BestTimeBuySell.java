package july_2025;

public class BestTimeBuySell {

    public static void main(String[] args) {
//        int[] prices = {7,1,5,3,6,4};
        int[] prices = {7,6,4,3,1};

        BestTimeBuySell bestTimeBuySell = new BestTimeBuySell();
        int result = bestTimeBuySell.maxProfit(prices);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = prices[0];
        for (int i = 0; i < prices.length; i++) {
            int sell = prices[i];
            maxProfit = Math.max(maxProfit, sell - buy);
            buy = Math.min(buy, prices[i]);
        }
        return maxProfit;
    }


}
