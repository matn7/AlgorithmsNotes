package january_2025;

import java.util.*;

public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        int[] nums = {1, 4, 12, 5};

        PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();
        boolean result = partitionEqualSubsetSum.canPartition(nums);
        System.out.println(result);
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        Set<Integer> dp = new HashSet<>();
        Set<Integer> nextDp = new HashSet<>();
        dp.add(0);
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int t : dp) {
                if (t + nums[i] == target) {
                    return true;
                }
                nextDp.add(t);
                nextDp.add(t + nums[i]);
            }
            dp = nextDp;
            nextDp.clear();
        }
        return false;
    }

}
