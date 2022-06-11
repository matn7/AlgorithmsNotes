package veryhard;

public class MaxProfitWithKTransactionsREPEAT {

    public static void main(String[] args) {
        int[] prices = {5, 11, 3, 50, 60, 90};
        int k = 2;

        int result = maxProfitWithKTransactions(prices, k);

        System.out.println(result);
    }

//    // O(nk) time | O(n) space
//    public static int maxProfitWithKTransactions(int[] prices, int k) {
//        if (prices.length == 0) {
//            return 0;
//        }
//        int[] evenProfits = new int[prices.length];
//        int[] oddProfits = new int[prices.length];
//
//        int[] currentProfits = new int[prices.length];
//        int[] previousProfits = new int[prices.length];
//
//        for (int t = 1; t < k + 1; t++) {
//            int maxThusFar = -99999;
//            if (t % 2 == 1) {
//                currentProfits = oddProfits;
//                previousProfits = evenProfits;
//            } else {
//                currentProfits = evenProfits;
//                previousProfits = oddProfits;
//            }
//            for (int d = 1; d < prices.length; d++) {
//                maxThusFar = Math.max(maxThusFar, previousProfits[d - 1] - prices[d - 1]);
//                currentProfits[d] = Math.max(currentProfits[d - 1], maxThusFar + prices[d]);
//            }
//        }
//        return k % 2 == 0 ? evenProfits[prices.length - 1] : oddProfits[prices.length - 1];
//    }

    // OK - repeated 19/02/2022
    // O(nk) time | O(nk) space
    public static int maxProfitWithKTransactions(int[] prices, int k) {
        // Write your code here.
        //                       d
        //  [ 5, 11, 3, 50, 60, 90]
        // -------------------------+
        //    0   0  0   0   0   0  |  0
        //    0   6  6  47  57  87  |  1     (buy 3 sell 90)
        //    0   6  6  53  63  93  |  2  t  (buy 5 sell 11 buy 3 sell 90) -5 + 11 -3 + 90 = 93

        // profit[t][d] = Max(profit[t][d-1], prices[d] + Max(-prices[x] + profit[t-1][x]) 0 <= x < d
        if (prices.length == 0) {
            return 0;
        }
        int[][] profits = new int[k+1][prices.length];

        for (int t = 1; t < k + 1; t++) {
            int maxThusFar = Integer.MIN_VALUE; // -999
            for (int d = 1; d < prices.length; d++) {
                maxThusFar = Math.max(maxThusFar, profits[t - 1][d - 1] - prices[d - 1]); // max(3, 57 - 60)= 3
                profits[t][d] = Math.max(profits[t][d - 1], maxThusFar + prices[d]); // max(63, 3 + 90) = 93
            }
        }

        return profits[k][prices.length - 1];
    }

}
