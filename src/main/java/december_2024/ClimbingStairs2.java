package december_2024;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs2 {

    public static void main(String[] args) {
        ClimbingStairs2 climbingStairs = new ClimbingStairs2();
        int result = climbingStairs.climbStairs(5);
        System.out.println(result);
    }


    public int climbStairs(int n) {

        if (n == 0 || n == 1) {
            return 1;
        }
        int prevprev = 1;
        int prev = 1;
        int res = prev + prevprev;
        for (int i = 2; i < n; i++) {
            prevprev = prev;
            prev = res;
            res = prev + prevprev;
        }
        return res;
    }


    public int climbStairs2(int n) {

        if (n == 0 || n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

    }



}
