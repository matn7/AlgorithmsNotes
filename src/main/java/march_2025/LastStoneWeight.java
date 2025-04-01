package march_2025;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};

        LastStoneWeight lastStoneWeight = new LastStoneWeight();
        int result = lastStoneWeight.lastStoneWeightII(stones);
        System.out.println(result);
    }

    // O(n * m) time | O(n * m) space
    public int lastStoneWeightII(int[] stones) {
        int stoneSum = 0;
        for (int stone : stones) {
            stoneSum += stone;
        }
        int target = (int) Math.ceil(stoneSum / 2);
        Map<String, Integer> dp = new HashMap<>();
        return dfs(0, 0, stones, target, stoneSum, dp);
    }

    private int dfs(int i, int total, int[] stones, int target, int stoneSum, Map<String, Integer> dp) {
        if (total >= target || i == stones.length) {
            return Math.abs(total - (stoneSum - total));
        }
        String key = i + ":" + total;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        dp.put(key, Math.min(dfs(i + 1, total, stones, target, stoneSum, dp),
                dfs(i + 1, total + stones[i], stones, target, stoneSum, dp)));
        return dp.get(key);
    }
}
