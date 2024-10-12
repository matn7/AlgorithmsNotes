package september_2024;

public class MaxProfitsWithKTransactions {

    public static void main(String[] args) {
        int[] prices = {5, 11, 3, 50, 60, 90};
        int k = 2;

        int result = maxProfits(prices, k);
        System.out.println(result);
    }

    // O(nk) time | O(nk) space
    public static int maxProfits(int[] prices, int k) {
        if (prices.length == 0 || k <= 0) {
            return 0;
        }

        int[][] profits = new int[k + 1][prices.length];

        for (int t = 1; t <= k; t++) {
            int maxThusFar = Integer.MIN_VALUE;
            for (int d = 1; d < prices.length; d++) {
                maxThusFar = Math.max(maxThusFar, profits[t - 1][d - 1] - prices[d - 1]); // buy
                profits[t][d] = Math.max(profits[t][d - 1], maxThusFar + prices[d]); // sell
            }
        }

        return profits[k][prices.length - 1];

    }

}
