package july_2024;

public class BestTimeToBuyAndSellStockV2 {

    public static void main(String[] args) {
        int[] prices = {9, 11, 8, 5, 7, 10};

        int result = buyAndSell(prices);
        System.out.println(result);

    }

    // O(n) time | O(1) space
    public static int buyAndSell(int[] arr) {
        int maxCurrPrice = 0;
        int maxProfit = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            int price = arr[i];
            maxCurrPrice = Math.max(maxCurrPrice, price);
            maxProfit = Math.max(maxProfit, maxCurrPrice - price);
        }
        return maxProfit;
    }

}
