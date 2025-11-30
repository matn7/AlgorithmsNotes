package november_2025;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int k = 3;

//        int[] nums = {1,2,3,1,2,3};
//        int k = 2;

        ContainsDuplicateII containsDuplicateII = new ContainsDuplicateII();
        boolean result = containsDuplicateII.containsNearbyDuplicate(nums, k);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int l = 0;
        Set<Integer> seen = new HashSet<>();
        seen.add(nums[l]);

        for (int r = 1; r < nums.length; r++) {
            int num = nums[r];
            if (seen.contains(num)) {
                return true;
            }
            if (r - l + 1 > k) {
                int toRemove = nums[l];
                l++;
                seen.remove(toRemove);
            }
            seen.add(num);
        }
        return false;
    }

}
