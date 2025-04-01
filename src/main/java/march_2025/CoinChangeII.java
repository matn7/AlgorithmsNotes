package march_2025;

public class CoinChangeII {

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};

        CoinChangeII coinChangeII = new CoinChangeII();
        int result = coinChangeII.change(amount, coins);
        System.out.println(result);
    }

    // O(c * a) time | O(a) space
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int c : coins) {
            for (int i = 1; i <= amount; i++) {
                if (i >= c) {
                    dp[i] = dp[i] + dp[i - c];
                }
            }
        }
        return dp[amount];
    }

}
