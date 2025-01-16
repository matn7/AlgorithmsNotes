package december_2024;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PartitionEqualSubsets {

    public static void main(String[] args) {
//        int[] nums = {1, 2, 5, 5, 9};
//        int[] nums = {3, 3, 3, 4, 5};

        int[] nums = {23,13,11,7,6,5,5};

        PartitionEqualSubsets partitionEqualSubsets = new PartitionEqualSubsets();
        boolean result = partitionEqualSubsets.canPartition(nums);
        System.out.println(result);
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        Set<Integer> dp = new HashSet<>();
        dp.add(0);
        int target = sum / 2;

        for (int i = nums.length - 1; i >= 0; i--) {
            Set<Integer> nextDp = new HashSet<>();
            for (Integer t : dp) {
                nextDp.add(t + nums[i]);
                nextDp.add(t);
            }
            dp = nextDp;
        }

        return dp.contains(target);
    }

}
