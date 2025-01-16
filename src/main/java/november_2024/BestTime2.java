package november_2024;

public class BestTime2 {

    public static void main(String[] args) {
        int[] prices = {7, 2, 5, 3, 1, 6, 4};

        BestTime2 bestTime2 = new BestTime2();
        int result = bestTime2.maxProfit(prices);
        System.out.println(result);
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = prices[0];

        for (int sell : prices) {
            profit = Math.max(profit, sell - buy);
            buy = Math.min(buy, sell);
        }
        return profit;
    }

}
