package april_2025;

import java.util.HashSet;
import java.util.Set;

public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
//        int[] nums = {1, 5, 11, 5};

//        int[] nums = {1,2,3,5};

        int[] nums = {2,2,3,5};

        PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();
        boolean result = partitionEqualSubsetSum.canPartition(nums);
        System.out.println(result);
    }

    // O(n*target) time | O(n*target) space - target sum of elems / 2
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        Set<Integer> dp = new HashSet<>();
        dp.add(0);

        for (int i = nums.length - 1; i >= 0; i--) {
            Set<Integer> newDp = new HashSet<>();
            for (Integer d : dp) {
                if (nums[i] + d == target) {
                    return true;
                }
                newDp.add(nums[i] + d);
                newDp.add(d);
            }
            dp = newDp;
        }

        return false;
    }

}
