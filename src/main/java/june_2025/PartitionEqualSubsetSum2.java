package june_2025;

import java.util.HashSet;
import java.util.Set;

public class PartitionEqualSubsetSum2 {

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        PartitionEqualSubsetSum2 partitionEqualSubsetSum2 = new PartitionEqualSubsetSum2();
        boolean result = partitionEqualSubsetSum2.canPartition(nums);
        System.out.println(result);
    }

    // O(n * t) time | O(n * t) space
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
            Set<Integer> newDp = new HashSet<>();
            for (int d : dp) {
                int t = num + d;
                if (t == target) {
                    return true;
                }
                newDp.add(d);
                newDp.add(t);
            }
            dp = newDp;
        }
        return false;
    }

}
