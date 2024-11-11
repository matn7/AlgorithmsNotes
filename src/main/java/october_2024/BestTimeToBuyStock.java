package october_2024;

import java.util.Map;

public class BestTimeToBuyStock {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        BestTimeToBuyStock buyStock = new BestTimeToBuyStock();
        int result = buyStock.maxProfit(prices);
        System.out.println(result);
    }

    // leetcode 122
    // O(n) time | O(1) space
    public int maxProfit(int[] prices) {
        // [7, 1, 5, 3, 6, 4]
        //              c  n
        int profit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            int curr = prices[i];
            int next = prices[i + 1];
            if (next > curr) {
               profit += (next - curr);
            }
        }

        return profit;
    }

}
