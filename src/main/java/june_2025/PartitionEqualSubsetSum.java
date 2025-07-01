package june_2025;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
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
        dp.add(0);

        for (int num : nums) {
            Set<Integer> newDp = new HashSet<>();

            for (int t : dp) {
                if (t + num == target) {
                    return true;
                }
                newDp.add(t + num);
                newDp.add(t);
            }

            dp = newDp;
        }

        return false;


    }

}
