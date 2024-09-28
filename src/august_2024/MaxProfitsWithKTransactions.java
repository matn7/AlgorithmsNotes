package august_2024;

public class MaxProfitsWithKTransactions {

    public static void main(String[] args) {
        int[] prices = {5, 11, 3, 50, 60, 90};

        maxProfitWithKTransactions(prices, 2);
    }

    public static int maxProfitWithKTransactions(int[] prices, int k) {
        if (prices.length == 0) {
            return 0;
        }
        int[][] maxProfits = new int[k + 1][prices.length];

        for (int transaction = 1; transaction <= k; transaction++) {
            for (int day = 1; day < prices.length; day++) {
                // no transaction this dat
                int noTransactionProfit = maxProfits[transaction][day - 1];

                // sell on this day but in one of previous day
                int maxProfitIfSoldToday = Integer.MIN_VALUE;
                for (int prevDay = 0; prevDay < day; prevDay++) {
                    int potentialProfit = -1 * prices[prevDay] + maxProfits[transaction - 1][prevDay];
                    maxProfitIfSoldToday = Math.max(maxProfitIfSoldToday, potentialProfit);
                }
            }
        }
        return 0;
    }

}
