package april_2025;

import java.util.HashMap;
import java.util.Map;

public class TargetSum2 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;

        TargetSum2 targetSum = new TargetSum2();
        int result = targetSum.findTargetSumWays(nums, target);
        System.out.println(result);
    }

    // O(n*m) time | O(m) space
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);

        for (int num : nums) {
            Map<Integer, Integer> nextDp = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : dp.entrySet()) {
                int total = entry.getKey();
                int count = entry.getValue();
                nextDp.put(total + num,
                        nextDp.getOrDefault(total + num, 0) + count);
                nextDp.put(total - num,
                        nextDp.getOrDefault(total - num, 0) + count);
            }
            dp = nextDp;
        }
        return dp.getOrDefault(target, 0);
    }

    // O(n*m) time | O(n*m) space
    public int findTargetSumWays2(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer>[] dp = new HashMap[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = new HashMap<>();
        }
        dp[0].put(0, 1);

        for (int i = 0; i < n; i++) {
            for (Map.Entry<Integer, Integer> entry : dp[i].entrySet()) {
                int total = entry.getKey();
                int count = entry.getValue();
                dp[i + 1].put(total + nums[i],
                        dp[i + 1].getOrDefault(total + nums[i], 0) + count);
                dp[i + 1].put(total - nums[i],
                        dp[i + 1].getOrDefault(total - nums[i], 0) + count);
            }
        }
        return dp[n].getOrDefault(target, 0);
    }

}
