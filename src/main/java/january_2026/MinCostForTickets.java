package january_2026;

import java.util.Arrays;

public class MinCostForTickets {

    // O(n) time | O(n) space
    private int[] dp;

    public int mincostTickets(int[] days, int[] costs) {
        dp = new int[days.length];
        Arrays.fill(dp, -1);
        return dfs(0, days, costs);
    }

    private int dfs(int currDay, int[] days, int[] costs) {
        if (currDay == days.length) {
            return 0;

        }
        if (dp[currDay] != -1) {
            return dp[currDay];
        }

        dp[currDay] = Integer.MAX_VALUE;
        int idx = 0;
        int nextDay = currDay;

        for (int d : new int[] {1, 7, 30}) {
            while (nextDay < days.length && days[nextDay] < days[currDay] + d) {
                nextDay++;
            }
            dp[currDay] = Math.min(dp[currDay], costs[idx] + dfs(nextDay, days, costs));
            idx++;
        }
        return dp[currDay];
    }

}
