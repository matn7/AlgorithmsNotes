package educative.dynamicprogramming;

public class PartitionSet2 {

    // O(n * s) time | O(n * s) space
    public int canPartition(int[] num) {
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            sum += num[i];
        }

        int n = num.length;
        boolean[][] dp = new boolean[n][sum / 2 + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        for (int s = 1; s <= sum / 2; s++) {
            dp[0][s] = (num[0] == s ? true : false);
        }

        for (int i = 1; i < num.length; i++) {
            for (int s = 1; s <= sum / 2; s++) {
                if (dp[i - 1][s]) {
                    dp[i][s] = dp[i - 1][s];
                } else if (s >= num[i]) {
                    dp[i][s] = dp[i - 1][s - num[i]];
                }
            }
        }

        int sum1 = 0;

        for (int i = sum / 2; i >= 0; i--) {
            if (dp[n - 1][i] == true) {
                sum1 = i;
                break;
            }
        }

        int sum2 = sum - sum1;
        return Math.abs(sum2 - sum1);
    }

//    public int canPartition(int[] num) {
//        int sum = 0;
//        for (int i = 0; i < num.length; i++) {
//            sum += num[i];
//        }
//
//        Integer[][] dp = new Integer[num.length][sum + 1];
//        return canPartitionRecursive(dp, num, 0, 0, 0);
//    }
//
//    private int canPartitionRecursive(Integer[][] dp, int[] num, int currentIndex, int sum1, int sum2) {
//        if (currentIndex == num.length) {
//            return Math.abs(sum1 - sum2);
//        }
//
//        if (dp[currentIndex][sum1] == null) {
//            int diff1 = canPartitionRecursive(dp, num, currentIndex + 1, sum1 + num[currentIndex], sum2);
//            int diff2 = canPartitionRecursive(dp, num, currentIndex + 1, sum1, sum2 + num[currentIndex]);
//
//            dp[currentIndex][sum1] = Math.min(diff1, diff2);
//        }
//
//        return dp[currentIndex][sum1];
//    }


//    // O(2^n) time | O(n) space
//    public int canPartition(int[] num) {
//        return canPartitionRecursive(num, 0, 0, 0);
//    }
//
//    private int canPartitionRecursive(int[] num, int currentIndex, int sum1, int sum2) {
//        if (currentIndex == num.length) {
//            return Math.abs(sum1 - sum2);
//        }
//
//        int diff1 = canPartitionRecursive(num, currentIndex + 1, sum1 + num[currentIndex], sum2);
//        int diff2 = canPartitionRecursive(num, currentIndex + 1, sum1, sum2 + num[currentIndex]);
//
//        return Math.min(diff1, diff2);
//    }

    public static void main(String[] args) {
        PartitionSet2 ps = new PartitionSet2();
        int[] num = {1, 2, 3, 9};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 3, 100, 4};
        System.out.println(ps.canPartition(num));
    }

}
