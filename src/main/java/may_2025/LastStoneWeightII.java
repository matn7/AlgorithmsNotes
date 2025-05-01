package may_2025;

import java.util.HashMap;
import java.util.Map;

public class LastStoneWeightII {

    // O(n * total) time | O(n * total) space
    public int lastStoneWeightII(int[] stones) {
        int stoneSum = 0;
        for (int s : stones) {
            stoneSum += s;
        }
        int target = (int) (Math.ceil(stoneSum) / 2);
        Map<String, Integer> dp = new HashMap<>();
        return dfs(0, 0, stoneSum, stones, target, dp);
    }

    private int dfs(int i, int total, int stoneSum, int[] stones, int target, Map<String, Integer> dp) {
        if (total >= target || i == stones.length) {
            return Math.abs(total - (stoneSum - total));
        }
        String key = i + ":" + total;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        dp.put(key, Math.min(dfs(i + 1, total, stoneSum, stones, target, dp),
                dfs(i + 1, total + stones[i], stoneSum, stones, target, dp)));
        return dp.get(key);
    }

}
