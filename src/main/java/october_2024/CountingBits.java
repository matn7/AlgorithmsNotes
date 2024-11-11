package october_2024;

public class CountingBits {

    public static void main(String[] args) {
        CountingBits countingBits = new CountingBits();
        countingBits.countBits(5);

        int[] x = countingBits.countBits2(5);
        System.out.println(x);
    }

    // O(n * log(m)) time | O(1) space
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ans[i] = count(i);
        }
        return ans;
    }

    private int count(int num) {
        int count = 0;

        while (num > 0) {
            if ((num & 1) == 1) {
                count++;
            }
            num = num >> 1;
        }

        return count;
    }

    public int[] countBits2(int n) {
        int pow = 1;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (2 * pow == i) {
                pow = i;
            }
            dp[i] = 1 + dp[i - pow];
        }
        return dp;
    }

}
