package january_2026;

public class HammingWeight {

    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for (int x = 1; x <= n; x++) {
            dp[x] = dp[x >> 1] + (x & 1);
        }

        return dp;
    }

}
