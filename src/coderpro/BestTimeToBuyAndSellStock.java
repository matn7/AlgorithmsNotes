package coderpro;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] prices = {9, 11, 8, 5, 7, 10};
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        int result = bestTimeToBuyAndSellStock.buy_and_sell(prices);
        System.out.println(result);
        int result2 = bestTimeToBuyAndSellStock.buy_and_sell2(prices);
        System.out.println(result2);
    }

    // O(n^2) time | O(1) spcae
    public int buy_and_sell(int[] arr) {
        int max_profit = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                max_profit = Math.max(max_profit, arr[j] - arr[i]);
            }
        }
        return max_profit;
    }

    // O(n) time | O(1) space
    public int buy_and_sell2(int[] arr) {
        int max_current_price = 0;
        int max_profit = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            int price = arr[i];
            max_current_price = Math.max(max_current_price, price);
            max_profit = Math.max(max_profit, max_current_price - price);
        }

        return max_profit;
    }

}
