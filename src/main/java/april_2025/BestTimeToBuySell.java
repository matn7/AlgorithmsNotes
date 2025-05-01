package april_2025;

public class BestTimeToBuySell {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};

        BestTimeToBuySell bestTimeToBuySell = new BestTimeToBuySell();
        int result = bestTimeToBuySell.maxProfit(prices);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int maxProfit(int[] prices) {
        int buy = 0;
        int maxProfit = 0;
        for (int sell = 1; sell < prices.length; sell++) {
            if (prices[sell] - prices[buy] > 0) {
                maxProfit = Math.max(maxProfit, prices[sell] - prices[buy]);
            } else {
                buy = sell;
            }
        }
        return maxProfit;
    }

}
