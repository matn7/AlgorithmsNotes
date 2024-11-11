package october_2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BurstBaloons2 {

    // O(n^3) time | O(n^2) space
    public int maxCoins(int[] nums) {
        List<Integer> numsArr = new ArrayList<>();
        for (int n : nums) {
            numsArr.add(n);
        }
        numsArr.add(0, 1);
        numsArr.add(1);
        Map<String, Integer> dp = new HashMap<>();
        return dfs(1, numsArr.size() - 2, numsArr, dp);
    }

    private int dfs(int l, int r, List<Integer> nums, Map<String, Integer> dp) {
        if (l > r) {
            return 0;
        }
        String key = l + ":" + r;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        dp.put(key, 0);
        for (int i = l; i < r + 1; i++) {
            int coins = nums.get(l - 1) * nums.get(i) * nums.get(r + 1);
            coins += dfs(l, i - 1, nums, dp) + dfs(i + 1, r, nums, dp);
            dp.put(key, Math.max(dp.get(key), coins));
        }
        return dp.get(key);
    }

}
