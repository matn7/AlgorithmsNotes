package february_2025;

public class CountingBits {

    public static void main(String[] args) {
        CountingBits countingBits = new CountingBits();
        int[] ints = countingBits.countBits(2);
        System.out.println(ints);
    }

    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        int offset = 1;

        for (int i = 1; i <= n; i++) {
            if (offset * 2 == i) {
                offset = i;
            }
            dp[i] = 1 + dp[i - offset];
        }

        return dp;
    }

}
