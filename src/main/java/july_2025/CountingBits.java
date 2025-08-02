package july_2025;

public class CountingBits {

    public static void main(String[] args) {
        int n = 5;
        CountingBits countingBits = new CountingBits();
        int[] result = countingBits.countBits(n);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int[] countBits(int n) {
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
