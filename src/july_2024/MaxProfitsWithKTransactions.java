package july_2024;

public class MaxProfitsWithKTransactions {

    public static void main(String[] args) {
        int[] nums = {5, 11, 3, 50, 60, 90};
        int k = 2;

        int result = maxProfitWithKTransactions(nums, k);
        System.out.println(result);
    }

    // O(nk) time | O(nk) space
    public static int maxProfitWithKTransactions(int[] prices, int k) {
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
