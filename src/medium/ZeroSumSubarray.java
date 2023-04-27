package medium;

import java.util.HashSet;
import java.util.Set;

public class ZeroSumSubarray {

    // O(n) time | O(n) space
    public boolean zeroSumSubarray(int[] nums) {
        // Write your code here.
        Set<Integer> sums = new HashSet<>();
        sums.add(0);
        int currentSum = 0;
        for (int num : nums) {
            currentSum += num;
            if (sums.contains(currentSum)) {
                return true;
            }
            sums.add(currentSum);
        }
        return false;
    }

}
