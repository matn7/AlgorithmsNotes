package educative.dynamicprogramming;

public class PartitionSet {

    // O(n * s) time | O(n * s) space
    public boolean canPartition(int[] num) {
        int n = num.length;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += num[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        sum /= 2;

        boolean[][] dp = new boolean[n][sum + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        for (int s = 1; s <= sum; s++) {
            dp[0][s] = (num[0] == s ? true : false);
        }

        for (int i = 1; i < n; i++) {
            for (int s = 1; s <= sum; s++) {
                if (dp[i - 1][s]) {
                    dp[i][s] = dp[i - 1][s];
                } else if (s >= num[i]) {
                    dp[i][s] = dp[i - 1][s - num[i]];
                }
            }
        }

        return dp[n - 1][sum];
    }

//    // O(n * s) time | O(n * s) space
//    public boolean canPartition(int[] num) {
//        int sum = 0;
//        for (int i = 0; i < num.length; i++) {
//            sum += num[i];
//        }
//
//        if (sum %2 != 0) {
//            return false;
//        }
//
//        Boolean[][] dp = new Boolean[num.length][sum / 2 + 1];
//        return canPartitionRecursive(dp, num, sum / 2, 0);
//    }
//
//    private boolean canPartitionRecursive(Boolean[][] dp, int[] num, int sum, int currentIndex) {
//        if (sum == 0) {
//            return true;
//        }
//
//        if (num.length == 0 || currentIndex >= num.length) {
//            return false;
//        }
//
//        if (dp[currentIndex][sum] == null) {
//            if (num[currentIndex] <= sum) {
//                if (canPartitionRecursive(dp, num, sum - num[currentIndex], currentIndex + 1)) {
//                    dp[currentIndex][sum] = true;
//                    return true;
//                }
//            }
//            dp[currentIndex][sum] = canPartitionRecursive(dp, num, sum, currentIndex + 1);
//        }
//
//        return dp[currentIndex][sum];
//    }


//    // O(2^n) time | O(n) space
//    public boolean canPartition(int[] num) {
//        int sum = 0;
//        for (int i = 0; i < num.length; i++) {
//            sum += num[i];
//        }
//
//        if (sum %2 != 0) {
//            return false;
//        }
//
//        return canPartitionRecursive(num, sum / 2, 0);
//    }
//
//    private boolean canPartitionRecursive(int[] num, int sum, int currentIndex) {
//        if (sum == 0) {
//            return true;
//        }
//
//        if (num.length == 0 || currentIndex >= num.length) {
//            return false;
//        }
//
//        if (num[currentIndex] <= sum) {
//            if (canPartitionRecursive(num, sum - num[currentIndex], currentIndex + 1)) {
//                return true;
//            }
//        }
//
//        return canPartitionRecursive(num, sum, currentIndex + 1);
//    }

    public static void main(String[] args) {
        PartitionSet ps = new PartitionSet();
        int[] num = {1, 2, 3, 4};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(ps.canPartition(num));
        num = new int[]{2, 3, 4, 6};
        System.out.println(ps.canPartition(num));
    }

}
