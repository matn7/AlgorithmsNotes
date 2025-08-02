package july_2025;

public class MinCostForTickets {

    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE;
            int idx = 0;
            int j = i;

            for (int d : new int[] {1, 7, 30}) {
                while (j < n && days[j] < days[i] + d) {
                    j++;
                }
                dp[i] = Math.min(dp[i], costs[idx] + dp[j]);
                idx++;
            }
        }
        return dp[0];
    }

}
