package march_2025;

import java.util.HashSet;
import java.util.Set;

public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};

//        int[] nums = {2,2,3,5};
        PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();
        boolean result = partitionEqualSubsetSum.canPartition(nums);
        System.out.println(result);
    }

    // O(n * t) time | O(t) space
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
