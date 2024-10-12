package august_2024;

public class MaxProfitsKTransactions {

    public static void main(String[] args) {
        int[] prices = {5, 11, 3, 50, 60, 90};
        int k = 2;

        maxProfit(prices, k);
    }

    // O(nk) time | O(nk) space
    public static int maxProfit(int[] prices, int k) {

        //      5    11    3    50    60    90
        // 0    0     0    0     0     0     0
        // 1    0     6    6    47    57*
        // 2    0
        if (prices.length == 0) {
            return 0;
        }
        int[][] profits = new int[k + 1][prices.length];

        for (int t = 1; t <= k; t++) {
            int maxThusFar = Integer.MIN_VALUE;
            for (int d = 1; d < prices.length; d++) {
                maxThusFar = Math.max(maxThusFar, profits[t - 1][d - 1] - prices[d - 1]);
                profits[t][d] = Math.max(profits[t][d - 1], maxThusFar + prices[d]);
            }
            System.out.print("");
        }

        return profits[k][prices.length - 1];
    }

}
