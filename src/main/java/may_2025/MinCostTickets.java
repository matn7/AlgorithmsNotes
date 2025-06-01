package may_2025;

import java.util.Arrays;

public class MinCostTickets {

    int[] dp;
    public int mincostTickets(int[] days, int[] costs) {
        dp = new int[days.length];
        Arrays.fill(dp, -1);
        return dfs(0, days, costs);
    }

    private int dfs(int i, int[] days, int[] costs) {
        if (i == days.length) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        dp[i] = Integer.MAX_VALUE;
        int idx = 0;
        int j = i;
        for (int d : new int[] {1, 7, 30}) {
            while (j < days.length && days[j] < days[i] + d) {
                j++;
            }
            dp[i] = Math.min(dp[i], costs[idx] + dfs(j , days, costs));
            idx++;
        }
        return dp[i];
    }


}
