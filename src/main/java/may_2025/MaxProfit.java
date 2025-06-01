package may_2025;

public class MaxProfit {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        MaxProfit maxProfit = new MaxProfit();
        int result = maxProfit.maxProfit(prices);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int max = 0;
        for (int price : prices) {
            int profit = price - buy;
            max = Math.max(max, profit);
            buy = Math.min(buy, price);
        }
        return max;
    }

}
