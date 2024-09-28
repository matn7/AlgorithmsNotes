package july_2024;


public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};

        int result = maxProfit(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public static int maxProfit(int[] nums) {
        int buyPrice = Integer.MAX_VALUE; // 1
        int profit = 0; // 5
        for (int price : nums) {
            if (buyPrice > price) { // 1 > 4
                buyPrice = price;
            } else {
                profit = Math.max(profit, profit - buyPrice); // max(5, 4 - 1) = 5
            }
        }
        return profit;
    }

}
