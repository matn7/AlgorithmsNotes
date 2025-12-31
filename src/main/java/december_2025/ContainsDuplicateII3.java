package december_2025;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII3 {

    public static void main(String[] args) {
//        int[] nums = {1,2,3,1};
//        int k = 3;

//        int[] nums = {1,0,1,1};
//        int k = 1;

        int[] nums = {1,2,3,1,2,3};
        int k = 2;

        ContainsDuplicateII containsDuplicateII = new ContainsDuplicateII();
        boolean result = containsDuplicateII.containsNearbyDuplicate(nums, k);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> seen = new HashSet<>();
        int l = 0;
        int r = 0;

        while (r < nums.length) {
            if (r > k) {
                int num = nums[l];
                seen.remove(num);
                l++;
            }
            int curr = nums[r];
            if (seen.contains(curr)) {
                return true;
            }
            seen.add(curr);
            r++;
        }
        return false;
    }


}
