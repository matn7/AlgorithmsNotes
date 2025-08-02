package july_2025;

public class MaxProfit {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        MaxProfit maxProfit = new MaxProfit();
        int result = maxProfit.maxProfit(prices);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int maxProfit(int[] prices) {
        int curBuy = 0;
        int curSell = 0;
        int nextBuy = 0;
        int nextSell = 0;

        for (int i = prices.length - 1; i >= 0; i--) {
            curBuy = Math.max(curBuy, -prices[i] + nextSell);
            curSell = Math.max(curSell, prices[i] + nextBuy);
            nextBuy = curBuy;
            nextSell = curSell;
        }
        return curBuy;
    }

    // O(n) time | O(n) space
    public int maxProfit2(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return dfs(prices, 0, 0, dp);
    }

    private int dfs(int[] prices, int i, int buying, int[][] dp) {
        if (i == prices.length) {
            return 0;
        }
        if (dp[i][buying] != -1) {
            return dp[i][buying];
        }
        int res = dfs(prices, i + 1, buying, dp);
        if (buying == 0) {
            res = Math.max(res, -prices[i] + dfs(prices, i + 1, 1, dp));
        } else {
            res = Math.max(res, prices[i] + dfs(prices, i + 1, 0, dp));
        }
        dp[i][buying] = res;
        return res;
    }

}
