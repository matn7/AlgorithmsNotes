package september_2023;

import java.util.HashSet;
import java.util.Set;

public class ZeroSumSubarray {

    public static void main(String[] args) {
        int[] nums = {-5, -5, 2, 3, -2};

        ZeroSumSubarray zeroSumSubarray = new ZeroSumSubarray();
        zeroSumSubarray.zeroSumSubarray(nums);
    }

    // O(n) time | O(n) space
    public boolean zeroSumSubarray(int[] nums) {
        // Write your code here.
        // [-5, -5, 2, 3, -2]
        Set<Integer> numsSet = new HashSet<>();
        int sum = 0;
        numsSet.add(sum); // {0, -5, -10, -8, -5}
        for (int num : nums) {
            sum += num;
            if (numsSet.contains(sum)) {
                return true;
            }
            numsSet.add(sum);
        }
        return false;
    }


}
