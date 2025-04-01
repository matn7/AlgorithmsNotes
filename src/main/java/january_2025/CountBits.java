package january_2025;

import august_2024.FrequentSubtree;

public class CountBits {

    public static void main(String[] args) {
        int n = 5;

        CountBits countBits = new CountBits();
        int[] ints = countBits.countBits(n);
        System.out.println();
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


    public int[] countBits2(int n) {
        int[] res = new int[n + 1];

        int idx = 0;
        for (int i = 0; i <= n; i++) {
            int count = 0;
            int num = i;
            while (num != 0) {
                if ((num & 1) == 1) {
                    count++;
                }
                num = num >> 1;
            }
            res[idx] = count;
            idx++;
        }

        return res;
    }

}
