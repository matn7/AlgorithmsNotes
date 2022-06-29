package educative.dynamicprogramming;

public class TargetSum {

    // O(n * s) time | O(s) space
    public int findTargetSubsets(int[] num, int s) {
        int totalSum = 0;
        for (int n : num) {
            totalSum += n;
        }

        if (totalSum < s || (s + totalSum) % 2 == 1) {
            return 0;
        }

        return countSubsets(num, (s + totalSum) / 2);
    }

    private int countSubsets(int[] num, int sum) {
        int n = num.length;
        int[] dp = new int[sum + 1];
        dp[0] = 1;

        for (int s = 1; s <= sum; s++) {
            dp[s] = (num[0] == s ? 1 : 0);
        }

        for (int i = 1; i < num.length; i++) {
            for (int s = sum; s >= 0; s--) {
                if (s >= num[i]) {
                    dp[s] += dp[s - num[i]];
                }
            }
        }

        return dp[sum];
    }


//    // O(n * s) time | O(n * s) space
//    public int findTargetSubsets(int[] num, int s) {
//        int totalSum = 0;
//        for (int n : num) {
//            totalSum += n;
//        }
//
//        if (totalSum < s || (s + totalSum) % 2 == 1) {
//            return 0;
//        }
//
//        return countSubsets(num, (s + totalSum) / 2);
//    }
//
//    private int countSubsets(int[] num, int sum) {
//        int n = num.length;
//        int[][] dp = new int[n][sum + 1];
//
//        for (int i = 0; i < n; i++) {
//            dp[i][0] = 1;
//        }
//
//        for (int s = 1; s <= sum; s++) {
//            dp[0][s] = (num[0] == s ? 1 : 0);
//        }
//
//        for (int i = 1; i < num.length; i++) {
//            for (int s = 1; s <= sum; s++) {
//                dp[i][s] = dp[i - 1][s];
//                if (s >= num[i]) {
//                    dp[i][s] += dp[i - 1][s - num[i]];
//                }
//            }
//        }
//
//        return dp[num.length - 1][sum];
//    }

    public static void main(String[] args) {
        TargetSum ts = new TargetSum();
        int[] num = {1, 1, 2, 3};
        System.out.println(ts.findTargetSubsets(num, 1));
        num = new int[]{1, 2, 7, 1};
        System.out.println(ts.findTargetSubsets(num, 9));
    }
}
