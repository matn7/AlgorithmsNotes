package june_2025;

import java.util.HashSet;
import java.util.Set;

public class CanPartition {

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};

        CanPartition canPartition = new CanPartition();
        boolean result = canPartition.canPartition(nums);
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
            Set<Integer> nextDp = new HashSet<>();
            for (int t : dp) {
                if (t + num == target) {
                    return true;
                }
                nextDp.add(t + num);
                nextDp.add(t);
            }
            dp = nextDp;
        }
        return false;
    }

}
