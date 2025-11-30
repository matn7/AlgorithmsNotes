package november_2025;

import javax.swing.plaf.InsetsUIResource;
import java.util.*;

public class PartitionEqualSubsetSum3 {

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        PartitionEqualSubsetSum3 partitionEqualSubsetSum3 = new PartitionEqualSubsetSum3();
        boolean result = partitionEqualSubsetSum3.canPartition(nums);
        System.out.println(result);
    }

    // O(n * sum(nums)) time | O(sum(nums)) space
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        Arrays.sort(nums);
        int target = sum / 2;
        Map<String, Boolean> memo = new HashMap<>();
        return dfs(nums, 0, 0, target, memo);
    }

    private boolean dfs(int[] nums, int i, int sum, int target, Map<String, Boolean> memo) {
        if (sum == target) {
            return true;
        }
        if (i == nums.length) {
            return false;
        }
        String key = i + ":" + sum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        memo.put(key, dfs(nums, i + 1,
                sum + nums[i], target, memo) || dfs(nums, i + 1, sum, target, memo)); // include || not include
        return memo.get(key);
    }

    // O(n * sum(nums)) time | O(sum(nums)) space
    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        Set<Integer> dp = new HashSet<>();
        dp.add(0);

        for (int num : nums) {
            Set<Integer> nextDp = new HashSet<>();
            for (int t : dp) {
                if (num + t == target) {
                    return true;
                }
                nextDp.add(t);
                nextDp.add(num + t);
            }
            dp = nextDp;
        }
        return false;
    }


}
