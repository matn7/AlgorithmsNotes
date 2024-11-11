package november_2024;

import java.util.HashMap;
import java.util.Map;

public class MinimumCostForTickets {

    // O(38 n) time
    public int mincostTickets(int[] days, int[] costs) {
        Map<Integer, Integer> dp = new HashMap<>();

        int[] ticketDays = {1, 7, 30};

        return dfs(0, days, costs, ticketDays, dp);
    }

    private int dfs(int i, int[] days, int[] costs, int[] ticketDays, Map<Integer, Integer> dp) {
        if (i == days.length) {
            return 0;
        }

        if (dp.containsKey(i)) {
            return dp.get(i);
        }

        int minCost = Integer.MAX_VALUE;

        // Try all three ticket types (1-day, 7-day, 30-day)
        for (int idx = 0; idx < ticketDays.length; idx++) {
            int ticketDuration = ticketDays[idx];
            int ticketCost = costs[idx];

            // Find the next day that is outside the coverage of this ticket
            int j = i;
            while (j < days.length && days[j] < days[i] + ticketDuration) {
                j++;
            }

            // Recurse and get the cost for the remaining days
            minCost = Math.min(minCost, ticketCost + dfs(j, days, costs, ticketDays, dp));
        }

        dp.put(i, minCost);
        return minCost;
    }

}
