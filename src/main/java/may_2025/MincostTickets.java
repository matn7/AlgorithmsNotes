package may_2025;

import java.util.HashMap;
import java.util.Map;

public class MincostTickets {

    public static void main(String[] args) {
        int[] days = {1,4,6,7,8,20};
        int[] costs = {2,7,15};

        MincostTickets mincostTickets = new MincostTickets();
        int result = mincostTickets.mincostTickets(days, costs);
        System.out.println(result);
    }

    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length + 1];

        Map<Integer, Integer> c = new HashMap<>();
        c.put(1, costs[0]);
        c.put(7, costs[1]);
        c.put(30, costs[2]);

        for (int i = days.length - 1; i >= 0; i--) {
            int j = i;
            dp[i] = Integer.MAX_VALUE;
            for (Map.Entry<Integer, Integer> elem : c.entrySet()) {
                int duration = elem.getKey();
                int cost = elem.getValue();
                while (j < days.length && days[j] < days[i] + duration) {
                    j++;
                }
                dp[i] = Math.min(dp[i], cost + dp[j]);
            }
        }
        return dp[0];
    }

    // O(n) time | O(n) space
    public int mincostTickets2(int[] days, int[] costs) {
        Map<Integer, Integer> c = new HashMap<>();
        c.put(1, costs[0]);
        c.put(7, costs[1]);
        c.put(30, costs[2]);
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(days.length, 0);
        return dfs(0, days, c, dp);
    }

    private int dfs(int i, int[] days, Map<Integer, Integer> c, Map<Integer, Integer> dp) {
        if (dp.containsKey(i)) {
            return dp.get(i);
        }
        dp.put(i, Integer.MAX_VALUE);
        for (Map.Entry<Integer, Integer> elem : c.entrySet()) {
            int j = i;
            int duration = elem.getKey();
            int cost = elem.getValue();
            while (j < days.length && days[j] < days[i] + duration) {
                j++;
            }
            dp.put(i, Math.min(dp.get(i), cost + dfs(j, days, c, dp)));
        }
        return dp.get(i);
    }

}
