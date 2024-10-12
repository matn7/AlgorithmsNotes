package april_2024;

public class BestTimeToBuySellStock {

    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};

        int result = maxProfit(nums);
        System.out.println(result);

        int result2 = maxProfit(nums);
        System.out.println(result2);
    }

    // O(n^2) time | O(1) space
    public static int maxProfit(int[] nums) {
        int profit = 0;
        //                 i
        //              j
        // [7, 1, 5, 3, 6, 4]
        for (int i = nums.length - 1; i >= 0; i--) {
            int sellPrice = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                int buyPrice = nums[j];
                profit = Math.max(profit, sellPrice - buyPrice);
            }
        }

        return profit;
    }

    // O(n) time | O(1) space
    public static int maxProfit2(int[] prices) {
        // [7, 1, 5, 3, 6, 4]
        //     b     s
        int buyPrice = Integer.MAX_VALUE;
        int profit = 0; // 5
        for (int price : prices) {
            if (buyPrice > price) {
                buyPrice = price;
            } else {
                profit = Math.max(profit, price - buyPrice);
            }
        }

        return profit;
    }

}
