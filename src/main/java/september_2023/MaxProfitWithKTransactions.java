package september_2023;

public class MaxProfitWithKTransactions {

    public static void main(String[] args) {
        int[] prices = {5, 11, 3, 50, 60, 90};
        int k = 2;

        maxProfitWithKTransactions(prices, k);
    }

    // O(n^2k) time | O(nk) space
    public static int maxProfitWithKTransactions(int[] prices, int k) {
        // Write your code here.

        //      5   11  3   50  60  90          prices
        //  ----------------------------
        //  0   0   0   0   0   0   0           profit
        //  1   0   6   6   47  57  87
        //  2   0   6   6   53  63
        //
        //  t (transaction)

        // profit[t][d] = max(  1) profit[t][d-1]                                                   )
        //                      2) prices[d] + max(-prices[x] + profit[t-1][x])
        //                                     "x <= x < d"
        if (prices.length == 0) {
            return 0;
        }
        int[][] profits = new int[k + 1][prices.length];

        for (int t = 1; t <= k; t++) {
            for (int d = 1; d < prices.length; d++) {
                int firstPart = profits[t][d - 1];
                int max = Integer.MIN_VALUE;
                for (int x = 0; x < d; x++) {
                    max = Math.max(max, -1 * prices[x] + profits[t - 1][x]);
                }
                int secondPart = prices[d] + max;
                profits[t][d] = Math.max(firstPart, secondPart);
            }
        }

        int result = profits[k][prices.length - 1];
        return result;
    }

    // O(nk) time | O(nk) space
    public static int maxProfitWithKTransactions2(int[] prices, int k) {
        // Write your code here.
        if (prices.length == 0) {
            return 0;
        }
        int[][] profits = new int[k+1][prices.length];

        for (int t = 1; t < k + 1; t++) {
            int maxThusFar = Integer.MIN_VALUE;
            for (int d = 1; d < prices.length; d++) {
                maxThusFar = Math.max(maxThusFar, profits[t - 1][d - 1] - prices[d - 1]);
                profits[t][d] = Math.max(profits[t][d - 1], maxThusFar + prices[d]);
            }
        }

        return profits[k][prices.length-1];
    }

}
