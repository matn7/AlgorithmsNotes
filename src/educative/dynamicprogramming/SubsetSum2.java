package educative.dynamicprogramming;

public class SubsetSum2 {

    // O(n * s) time | O(n * s) space
    public int countSubsets(int[] num, int sum) {
        int n = num.length;
        int[][] dp = new int[n][sum + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int s = 1; s <= sum; s++) {
            dp[0][s] = (num[0] == s ? 1 : 0);
        }

        for (int i = 1; i < num.length; i++) {
            for (int s = 1; s <= sum; s++) {
                dp[i][s] = dp[i - 1][s];
                if (s >= num[i]) {
                    dp[i][s] += dp[i - 1][s - num[i]];
                }
            }
        }
        return dp[num.length - 1][sum];
    }

//    // O(2^n) time | O(n) space
//    public int countSubsets(int[] num, int sum) {
//        Integer[][] dp = new Integer[num.length][sum + 1];
//        return countSubsetsRecursive(dp, num, sum, 0);
//    }
//
//    private int countSubsetsRecursive(Integer[][] dp, int[] num, int sum, int currentIndex) {
//        if (sum == 0) {
//            return 1;
//        }
//
//        if (num.length == 0 || currentIndex >= num.length) {
//            return 0;
//        }
//
//        if (dp[currentIndex][sum] == null) {
//            int sum1 = 0;
//            if (num[currentIndex] <= sum) {
//                sum1 = countSubsetsRecursive(dp, num, sum - num[currentIndex], currentIndex + 1);
//            }
//
//            int sum2 = countSubsetsRecursive(dp, num, sum, currentIndex + 1);
//
//            dp[currentIndex][sum] = sum1 + sum2;
//        }
//
//        return dp[currentIndex][sum];
//    }

//    // O(2^n) time | O(n) space
//    public int countSubsets(int[] num, int sum) {
//        return countSubsetsRecursive(num, sum, 0);
//    }
//
//    private int countSubsetsRecursive(int[] num, int sum, int currentIndex) {
//        if (sum == 0) {
//            return 1;
//        }
//
//        if (num.length == 0 || currentIndex >= num.length) {
//            return 0;
//        }
//
//        int sum1 = 0;
//        if (num[currentIndex] <= sum) {
//            sum1 = countSubsetsRecursive(num, sum - num[currentIndex], currentIndex + 1);
//        }
//
//        int sum2 = countSubsetsRecursive(num, sum, currentIndex + 1);
//
//        return sum1 + sum2;
//    }

    public static void main(String[] args) {
        SubsetSum2 ss = new SubsetSum2();
        int[] num = {1, 1, 2, 3};
        System.out.println(ss.countSubsets(num, 4));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ss.countSubsets(num, 9));
    }

}
