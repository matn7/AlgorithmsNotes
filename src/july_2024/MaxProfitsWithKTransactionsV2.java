package july_2024;

public class MaxProfitsWithKTransactionsV2 {

    public static void main(String[] args) {
        int[] prices = {5, 11, 3, 50, 60, 90};
        int k = 2;
    }

    // O(n^2 * k) time | O(n*k) space
    public static int maxProfitWithKTransactions(int[] prices, int k) {
        if (prices.length == 0) {
            return 0;
        }
        int[][] profits = new int[k + 1][prices.length];
        for (int t = 1; t <= k; t++) {
            for (int d = 1; d < prices.length; d++) {
                int first = profits[t][d - 1];
                int max = Integer.MIN_VALUE;
                for (int x = 0; x < d; x++) {
                    max = Math.max(max, -1*prices[x] + profits[t - 1][x]);
                }
                int second = prices[d] + max;
                profits[t][d] = Math.max(first, second);
            }
        }
        return profits[k][prices.length - 1];
    }

    // O(nk) time | O(nk) space
    public static int maxProfitWithKTransactionsV2(int[] prices, int k) {
        if (prices.length == 0) {
            return 0;
        }
        int[][] profits = new int[k + 1][prices.length];
        for (int t = 1; t <= k; t++) {
            int maxThusFar = Integer.MIN_VALUE; // min
            for (int d = 1; d < prices.length; d++) {
                maxThusFar = Math.max(maxThusFar, profits[t - 1][d - 1] - prices[d - 1]); // -5
                profits[t][d] = Math.max(profits[t][d - 1], maxThusFar + prices[d]); // -5 + 11 = 6
            }
        }
        return profits[k][prices.length - 1];
        //   0 1 2 3 4 5 <-- days
        // 0 0 0 0 0 0 0
        // 1 0 6 0 0 0 0
        // 2 0 0 0 0 0 0
        // ^
        // transactions
    }

}
