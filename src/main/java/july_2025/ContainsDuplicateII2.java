package july_2025;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicateII2 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int k = 3;

        ContainsDuplicateII2 containsDuplicateII2 = new ContainsDuplicateII2();
        boolean result = containsDuplicateII2.containsNearbyDuplicate(nums, k);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> seen = new HashSet<>();
        int L = 0;
        int R = 0;

        while (R < nums.length) {
            if (R - L > k) {
                seen.remove(nums[L]);
                L++;
            }
            if (seen.contains(nums[R])) {
                return true;
            }
            seen.add(nums[R]);
            R++;
        }
        return false;
    }

}
