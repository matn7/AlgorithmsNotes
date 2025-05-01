package april_2025;

public class CountingBits {

    // O(n) time | O(1) space
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        int offset = 1;

        for (int i = 1; i < n + 1; i++) {
            if (offset * 2 == i) {
                offset = i;
            }
            dp[i] = 1 + dp[i - offset];
        }
        return dp;
    }

    // O(nlog(n)) time | O(n) space
    public int[] countBits2(int n) {
        int[] result = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            int num = i;
            int count = 0;
            while (num > 0) {
                if ((num & 1) == 1) {
                    count++;
                }
                num = num >> 1;
            }
            result[i] = count;
        }

        return result;
    }

}
