package march_2025;

public class BestTime {

    public static void main(String[] args) {
        int[] prices = {2,1,4};
        BestTime bestTime = new BestTime();
        int result = bestTime.maxProfit(prices);
        System.out.println(result);
    }

    public int maxProfit(int[] prices) {
        int buy = 0;
        int sell = 1;

        int maxProfit = 0;

        while (sell < prices.length) {
            // profitable
            if (prices[sell] - prices[buy] > 0) {
                int profit = prices[sell] - prices[buy];
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buy = sell;
            }
            sell++;
        }
        return maxProfit;
    }

}
