package october_2024;

import java.util.Arrays;

public class PerfectSquares {

    public static void main(String[] args) {
        int n = 12;

        PerfectSquares perfectSquares = new PerfectSquares();
        int result = perfectSquares.numSquares(n);
        System.out.println(result);

    }

    // O(n^2) time | O(n) space
    public int numSquares(int n) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= Math.sqrt(n); i++) {
            int square = i * i;
            for (int j = i; j <= n; j++) {
                if (j >= square) {
                    dp[j] = Math.min(dp[j], dp[j - square] + 1);
                }
            }
        }
        return dp[dp.length - 1];
    }

}
