package may_2025;

import java.util.HashSet;
import java.util.Set;

public class CanPartition {

    public static void main(String[] args) {
//        int[] nums = {1,5,11,5};
        int[] nums = {1,2,5};
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
            Set<Integer> newDp = new HashSet<>();
            for (Integer n : dp) {
                if (num + n == target) {
                    return true;
                }
                newDp.add(num + n);
                newDp.add(num);
            }

            dp = newDp;
        }
        return false;
    }

}
