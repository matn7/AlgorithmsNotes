package december_2025;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII {

    // O(n) time | O(n) space
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int l = 0;
        int r = 0;
        Set<Integer> window = new HashSet<>();
        while (r < nums.length) {
            if (r - l > k) {
                window.remove(nums[l]);
                l++;
            }
            int num = nums[r];
            if (window.contains(num)) {
                return true;
            }
            window.add(num);
            r++;
        }
        return false;
    }

}
