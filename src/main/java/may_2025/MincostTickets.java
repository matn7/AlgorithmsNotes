package may_2025;

import java.util.HashMap;
import java.util.Map;

public class MincostTickets {

    // O(n) time | O(n) space
    public int mincostTickets(int[] days, int[] costs) {
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
        int j = i;
        for (Map.Entry<Integer, Integer> elem : c.entrySet()) {
            int cost = elem.getKey();
            int duration = elem.getValue();
            while (j < days.length && days[j] < days[i] + duration) {
                j++;
            }
            dp.put(i, Math.min(dp.get(i), cost + dfs(j, days, c, dp)));
        }
        return dp.get(i);
    }

}
