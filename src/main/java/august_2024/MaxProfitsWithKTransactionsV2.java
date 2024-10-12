package august_2024;

public class MaxProfitsWithKTransactionsV2 {

    public static void main(String[] args) {
        int[] prices = {5, 11, 3, 50, 60, 90};
        int k = 2;

        int result = maxProfit(prices, k);
        System.out.println(result);
    }

    // O(nk) time | O(nk) space
    public static int maxProfit(int[] prices, int k) {
        int[][] profits = new int[k + 1][prices.length];

        for (int transaction = 1; transaction <= k; transaction++) {
            int maxThusFar = Integer.MIN_VALUE;
            int yesterdayTransaction = transaction - 1;
            for (int today = 1; today < prices.length; today++) {
                int yesterday = today - 1;
                maxThusFar = Math.max(maxThusFar, profits[yesterdayTransaction][yesterday] - prices[yesterday]);
                profits[transaction][today] = Math.max(profits[transaction][yesterday], maxThusFar + prices[today]);
            }
        }
        return profits[k][prices.length - 1];
    }

}
