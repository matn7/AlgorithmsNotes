package september_2025;

public class CountingBits {

    public static void main(String[] args) {
        int n = 5;
        CountingBits countingBits = new CountingBits();
        int[] result = countingBits.countBits(n);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            int count = 0;
            int num = i;
            while (num > 0) {
                if ((num & 1) == 1) {
                    count++;
                }
                num = num >> 1;
            }
            dp[i] = count;
        }
        return dp;
    }

    // O(n) time | O(1) space
    public int[] countBits2(int n) {
        int[] dp = new int[n + 1];

        int off = 1;
        for (int i = 1; i <= n; i++) {
            if (2 * off == i) {
                off = i;
            }
            dp[i] = 1 + dp[i - off];
        }
        return dp;
    }


}
